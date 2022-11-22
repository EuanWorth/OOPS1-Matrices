/*
 * Copyright 2022 Andrew Rice <acr31@cam.ac.uk>, E.C. Worth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ecw66.matrices;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MatrixTest {

  @Test
  public void add_producesCorrectAnswer() {
    // ARRANGE
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3}, //
              {4, 5, 6}
            });
    Matrix b =
        new Matrix(
            new double[][] {
              {7, 8, 9}, //
              {10, 11, 12},
            });

    // ACT
    Matrix c = a.add(b);

    // ASSERT
    assertThat(c.get(0, 0)).isWithin(1E-7).of(8);
    assertThat(c.get(0, 1)).isWithin(1E-7).of(10);
    assertThat(c.get(0, 2)).isWithin(1E-7).of(12);
    assertThat(c.get(1, 0)).isWithin(1E-7).of(14);
    assertThat(c.get(1, 1)).isWithin(1E-7).of(16);
    assertThat(c.get(1, 2)).isWithin(1E-7).of(18);
  }
}
