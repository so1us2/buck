/*
 * Copyright 2017-present Facebook, Inc.
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

import com.facebook.buck.event.ArtifactCompressionEvent;
import com.facebook.buck.event.BuckEventBus;
import com.facebook.buck.event.ConsoleEvent;
import com.facebook.buck.io.file.BorrowablePath;
import com.facebook.buck.io.file.MoreFiles;
import com.facebook.buck.io.filesystem.ProjectFilesystem;
import com.facebook.buck.log.Logger;
import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.rules.RuleKey;
import com.facebook.buck.util.CloseableHolder;
import com.facebook.buck.util.NamedTemporaryFile;
import com.facebook.buck.util.exceptions.BuckUncheckedExecutionException;
import com.facebook.buck.util.zip.Zip;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.nio.file.Path;
import java.util.SortedSet;

/**
 * ArtifactUploader contains the logic of how to take a list of artifact paths and metadata and
 * store that to the ArtifactCache.
 */
public class ArtifactUploader {
  private static final Logger LOG = Logger.get(ArtifactUploader.class);

  public static ListenableFuture<Void> performUploadToArtifactCache(
      ImmutableSet<RuleKey> ruleKeys,
      ArtifactCache artifactCache,
      BuckEventBus eventBus,
      ImmutableMap<String, String> buildMetadata,
      SortedSet<Path> pathsToIncludeInZip,
      BuildTarget buildTarget,
      ProjectFilesystem projectFilesystem) {
    NamedTemporaryFile zip =
        getTemporaryArtifactZip(
            buildTarget, projectFilesystem, ruleKeys, eventBus, pathsToIncludeInZip);

    // Store the artifact, including any additional metadata.
    ListenableFuture<Void> storeFuture =
        artifactCache.store(
            ArtifactInfo.builder().setBuildTarget(buildTarget).setRuleKeys(ruleKeys).setMetadata(buildMetadata).build(),
            BorrowablePath.borrowablePath(zip.get()));
    Futures.addCallback(
        storeFuture,
        new FutureCallback<Void>() {
          @Override
          public void onSuccess(Void result) {
            onCompletion();
          }

          @Override
          public void onFailure(Throwable t) {
            onCompletion();
            LOG.info(t, "Failed storing RuleKeys %s to the cache.", ruleKeys);
            eventBus.post(
                ConsoleEvent.severe(
                    "Failed storing an artifact to the cache," + "see log for details."));
          }

          private void onCompletion() {
            try {
              zip.close();
            } catch (IOException e) {
              throw new BuckUncheckedExecutionException(
                  e, "When deleting temporary zip %s.", zip.get());
            }
          }
        });

    return storeFuture;
  }

  private static NamedTemporaryFile getTemporaryArtifactZip(
      BuildTarget buildTarget,
      ProjectFilesystem projectFilesystem,
      ImmutableSet<RuleKey> ruleKeys,
      BuckEventBus eventBus,
      SortedSet<Path> pathsToIncludeInZip) {
    ArtifactCompressionEvent.Started started =
        ArtifactCompressionEvent.started(ArtifactCompressionEvent.Operation.COMPRESS, ruleKeys);
    eventBus.post(started);
    try (CloseableHolder<NamedTemporaryFile> zip =
        new CloseableHolder<>(
            new NamedTemporaryFile(
                "buck_artifact_" + MoreFiles.sanitize(buildTarget.getShortName()), ".zip"))) {
      Zip.create(projectFilesystem, pathsToIncludeInZip, zip.get().get());
      return zip.release();
    } catch (IOException e) {
      throw new BuckUncheckedExecutionException(
          e,
          "When creating artifact zip for %s containing: \n %s.",
          buildTarget,
          Joiner.on('\n').join(ImmutableSortedSet.copyOf(pathsToIncludeInZip)));
    } finally {
      eventBus.post(ArtifactCompressionEvent.finished(started));
    }
  }
}
