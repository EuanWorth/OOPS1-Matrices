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
import static org.junit.Assert.assertThrows;

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

  @Test
  public void add_dimensionMisMatch() {
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
                            {13, 14, 15}
                    });

    // ACT
    // ASSERT
    assertThrows(IllegalArgumentException.class, () -> a.add(b));
  }

  @Test
  public void mult_producesCorrectAnswer() {
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
                            {13, 14, 15}
                    });

    // ACT
    Matrix c = a.mult(b);
    // ASSERT
    assertThat(c.get(0, 0)).isWithin(1E-7).of(66);
    assertThat(c.get(0, 1)).isWithin(1E-7).of(72);
    assertThat(c.get(0, 2)).isWithin(1E-7).of(78);
    assertThat(c.get(1, 0)).isWithin(1E-7).of(156);
    assertThat(c.get(1, 1)).isWithin(1E-7).of(171);
    assertThat(c.get(1, 2)).isWithin(1E-7).of(186);
  }

  @Test
  public void mult_dimensionMisMatch() {
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
    // ASSERT
    assertThrows(IllegalArgumentException.class, () -> a.mult(b));
  }

  @Test
  public void transposeTest() {
    // ARRANGE
    Matrix a =
            new Matrix(
                    new double[][]{
                            {1, 2, 3}, //
                            {4, 5, 6}
                    });
    // ACT
    Matrix b = a.transpose();

    // ASSERT
    assertThat(b.get(0, 0)).isWithin(1E-7).of(1);
    assertThat(b.get(0, 1)).isWithin(1E-7).of(4);
    assertThat(b.get(1, 0)).isWithin(1E-7).of(2);
    assertThat(b.get(1, 1)).isWithin(1E-7).of(5);
    assertThat(b.get(2, 0)).isWithin(1E-7).of(3);
    assertThat(b.get(2, 1)).isWithin(1E-7).of(6);
  }

  @Test
  public void accessOutOfBounds() {
    //ARRANGE
    Matrix m = new Matrix(
            new double[][] {{1}}
    );

    //ACT
    //ASSERT

    assertThrows(IndexOutOfBoundsException.class, () -> m.get(4,4));
  }
}
