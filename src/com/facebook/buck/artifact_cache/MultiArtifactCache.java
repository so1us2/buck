/*
 * Copyright 2012-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.artifact_cache;

import com.facebook.buck.artifact_cache.config.CacheReadMode;
import com.facebook.buck.io.file.BorrowablePath;
import com.facebook.buck.io.file.LazyPath;
import com.facebook.buck.rules.RuleKey;
import com.facebook.buck.util.MoreCollectors;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.Optional;

/**
 * MultiArtifactCache encapsulates a set of ArtifactCache instances such that fetch() succeeds if
 * any of the ArtifactCaches contain the desired artifact, and store() applies to all
 * ArtifactCaches.
 */
public class MultiArtifactCache implements ArtifactCache {

  private final ImmutableList<ArtifactCache> artifactCaches;
  private final ImmutableList<ArtifactCache> writableArtifactCaches;
  private final boolean isStoreSupported;

  public MultiArtifactCache(ImmutableList<ArtifactCache> artifactCaches) {
    this.artifactCaches = artifactCaches;
    this.writableArtifactCaches =
        artifactCaches
            .stream()
            .filter(c -> c.getCacheReadMode().equals(CacheReadMode.READWRITE))
            .collect(MoreCollectors.toImmutableList());
    this.isStoreSupported = this.writableArtifactCaches.size() > 0;
  }

  /**
   * Fetch the artifact matching ruleKey and store it to output. If any of the encapsulated
   * ArtifactCaches contains the desired artifact, this method succeeds, and it may store the
   * artifact to one or more of the other encapsulated ArtifactCaches as a side effect.
   */
  @Override
  public ListenableFuture<CacheResult> fetchAsync(RuleKey ruleKey, LazyPath output) {
    ListenableFuture<CacheResult> cacheResult = Futures.immediateFuture(CacheResult.miss());
    // This is the list of higher-priority caches that we should write the artifact to.
    ImmutableList.Builder<ArtifactCache> cachesToFill = ImmutableList.builder();
    for (ArtifactCache artifactCache : artifactCaches) {
      cacheResult =
          Futures.transformAsync(
              cacheResult,
              (result) -> {
                if (result.getType().isSuccess()) {
                  return Futures.immediateFuture(result);
                }
                if (artifactCache.getCacheReadMode().isWritable()) {
                  cachesToFill.add(artifactCache);
                }
                return artifactCache.fetchAsync(ruleKey, output);
              },
              MoreExecutors.directExecutor());
    }

    // Propagate the artifact to previous writable caches.
    return Futures.transform(
        cacheResult,
        (CacheResult result) -> {
          if (!result.getType().isSuccess()) {
            return result;
          }
          storeToCaches(
              cachesToFill.build(),
              ArtifactInfo.builder().addRuleKeys(ruleKey).setMetadata(result.getMetadata()).build(),
              BorrowablePath.notBorrowablePath(output.getUnchecked()));
          return result;
        },
        MoreExecutors.directExecutor());
  }

  private static ListenableFuture<Void> storeToCaches(
      ImmutableList<ArtifactCache> caches, ArtifactInfo info, BorrowablePath output) {
    // TODO(cjhopman): support BorrowablePath with multiple writable caches.
    if (caches.size() != 1) {
      output = BorrowablePath.notBorrowablePath(output.getPath());
    }
    List<ListenableFuture<Void>> storeFutures = Lists.newArrayListWithExpectedSize(caches.size());
    for (ArtifactCache artifactCache : caches) {
      storeFutures.add(artifactCache.store(info, output));
    }

    // Aggregate future to ensure all store operations have completed.
    return Futures.transform(Futures.allAsList(storeFutures), Functions.<Void>constant(null));
  }

  /** Store the artifact to all encapsulated ArtifactCaches. */
  @Override
  public ListenableFuture<Void> store(ArtifactInfo info, BorrowablePath output) {
    return storeToCaches(writableArtifactCaches, info, output);
  }

  @Override
  public CacheReadMode getCacheReadMode() {
    return isStoreSupported ? CacheReadMode.READWRITE : CacheReadMode.READONLY;
  }

  @Override
  public void close() {
    Optional<RuntimeException> throwable = Optional.empty();
    for (ArtifactCache artifactCache : artifactCaches) {
      try {
        artifactCache.close();
      } catch (RuntimeException e) {
        throwable = Optional.of(e);
      }
    }
    if (throwable.isPresent()) {
      throw throwable.get();
    }
  }

  @VisibleForTesting
  ImmutableList<ArtifactCache> getArtifactCaches() {
    return ImmutableList.copyOf(artifactCaches);
  }
}
