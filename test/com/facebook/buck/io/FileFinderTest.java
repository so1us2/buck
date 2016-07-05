/*
 * Copyright 2015-present Facebook, Inc.
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

package com.facebook.buck.io;

import com.facebook.buck.testutil.integration.TemporaryPaths;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Test for FileFinder.
 */
public class FileFinderTest {
  @Rule
  public TemporaryPaths tmp = new TemporaryPaths();

  @Test
  public void combine() {
    Object[] result = FileFinder.combine(null, "foo", null).toArray();
    Arrays.sort(result);
    Assert.assertArrayEquals(
        new String[] { "foo" },
        result);

    result = FileFinder.combine(
        ImmutableSet.<String>of(),
        "foo",
        ImmutableSet.of(".exe", ".com", ".bat")).toArray();
    Arrays.sort(result);
    Assert.assertArrayEquals(
        new String[] { "foo.bat", "foo.com", "foo.exe" },
        result);

    result = FileFinder.combine(
        ImmutableSet.<String>of("lib", ""),
        "foo",
        null).toArray();
    Arrays.sort(result);
    Assert.assertArrayEquals(
        new String[] { "foo", "libfoo" },
        result);
  }

  @Test
  public void firstMatchInPath() throws IOException {
    Path fee = tmp.newFolder("fee");
    Path fie = tmp.newFolder("fie");
    tmp.newFile("fee/foo");
    tmp.newFile("fie/foo");
    ImmutableList<Path> searchPath = ImmutableList.of(fie, fee);
    Optional<Path> result = FileFinder.getOptionalFile("foo", searchPath);
    Assert.assertTrue(result.isPresent());
    Assert.assertEquals(fie.resolve("foo"), result.get());
  }

  @Test
  public void matchAny() throws IOException {
    Path fee = tmp.newFolder("fee");
    tmp.newFile("fee/foo");
    Path fie = tmp.newFolder("fie");
    tmp.newFile("fie/bar");

    ImmutableSet<String> names = ImmutableSet.of(
        "foo",
        "bar",
        "baz");
    Optional<Path> result =
        FileFinder.getOptionalFile(
            names,
            ImmutableSortedSet.of(fee));
    Assert.assertTrue(result.isPresent());
    Assert.assertEquals(fee.resolve("foo"), result.get());

    result = FileFinder.getOptionalFile(
        names,
        ImmutableSortedSet.of(fie));
    Assert.assertTrue(result.isPresent());
    Assert.assertEquals(fie.resolve("bar"), result.get());
  }

  @Test
  public void noMatch() throws IOException {
    Path fee = tmp.newFolder("fee");
    tmp.newFile("fee/foo");
    Path fie = tmp.newFolder("fie");
    tmp.newFile("fie/bar");

    Optional<Path> result =
        FileFinder.getOptionalFile(
            "baz",
            ImmutableSortedSet.of(fee, fie));
    Assert.assertFalse(result.isPresent());
  }
}
