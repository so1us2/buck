/*
 * Copyright 2014-present Facebook, Inc.
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

package com.facebook.buck.rules;

import static com.facebook.buck.io.Watchman.NULL_WATCHMAN;

import com.facebook.buck.android.AndroidDirectoryResolver;
import com.facebook.buck.android.FakeAndroidDirectoryResolver;
import com.facebook.buck.cli.BuckConfig;
import com.facebook.buck.cli.FakeBuckConfig;
import com.facebook.buck.io.ProjectFilesystem;
import com.facebook.buck.json.ProjectBuildFileParserFactory;
import com.facebook.buck.testutil.FakeProjectFilesystem;
import com.facebook.buck.testutil.TestConsole;
import com.facebook.buck.timing.FakeClock;
import com.facebook.buck.util.ProcessExecutor;
import com.google.common.base.Function;
import com.google.common.base.Optional;

import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nullable;

public class TestCellBuilder {

  private ProjectFilesystem filesystem;
  private BuckConfig buckConfig;
  private AndroidDirectoryResolver androidDirectoryResolver;
  @Nullable
  private ProjectBuildFileParserFactory parserFactory;

  public TestCellBuilder() throws InterruptedException, IOException {
    filesystem = new FakeProjectFilesystem();
    buckConfig = FakeBuckConfig.builder().build();
    androidDirectoryResolver = new FakeAndroidDirectoryResolver();
  }

  public TestCellBuilder setFilesystem(ProjectFilesystem filesystem) {
    this.filesystem = filesystem;
    return this;
  }

  public TestCellBuilder setBuckConfig(BuckConfig buckConfig) {
    this.buckConfig = buckConfig;
    return this;
  }

  public TestCellBuilder setAndroidDirectoryResolver(AndroidDirectoryResolver resolver) {
    this.androidDirectoryResolver = resolver;
    return this;
  }

  public TestCellBuilder setBuildFileParserFactory(ProjectBuildFileParserFactory factory) {
    this.parserFactory = factory;
    return this;
  }

  public Cell build() throws IOException, InterruptedException {
    ProcessExecutor executor = new ProcessExecutor(new TestConsole());

    KnownBuildRuleTypesFactory typesFactory = new KnownBuildRuleTypesFactory(
        executor,
        androidDirectoryResolver,
        Optional.<Path>absent());

    if (parserFactory == null) {
      return new Cell(
          filesystem,
          new TestConsole(),
          NULL_WATCHMAN,
          buckConfig,
          typesFactory,
          androidDirectoryResolver,
          new FakeClock(0));
    }

    return new Cell(
        filesystem,
        new TestConsole(),
        NULL_WATCHMAN,
        buckConfig,
        typesFactory,
        androidDirectoryResolver,
        new FakeClock(0)) {
      @Override
      protected ProjectBuildFileParserFactory createBuildFileParserFactory(boolean watchmanGlob) {
        return parserFactory;
      }
    };
  }

  public static Function<Optional<String>, Path> createCellRoots(
      @Nullable ProjectFilesystem filesystem) {
    final ProjectFilesystem toUse = filesystem == null ? new FakeProjectFilesystem() : filesystem;

    return new Function<Optional<String>, Path>() {
      @Override
      public Path apply(Optional<String> cellName) {
        if (cellName.isPresent()) {
          throw new RuntimeException("No known cell with the name: " + cellName);
        }
        return toUse.getRootPath();
      }
    };
  }
}
