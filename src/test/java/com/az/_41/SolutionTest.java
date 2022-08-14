package com.az._41;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void test1() {
        assertThat(
                Solution.solution(
                        new int[][]{
                                {0, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1},
                                {1, 1, 0, 1, 1},
                                {1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 0}
                        },
                        3)
        ).containsExactly(0, 1);
    }

    @Test
    public void test2() {
        assertThat(
                Solution.solution(
                        new int[][]{
                                {0, 2, 2, 2, -1},
                                {9, 0, 2, 2, -1},
                                {9, 3, 0, 2, -1},
                                {9, 3, 2, 0, -1},
                                {9, 3, 2, 2, 0}
                        },
                        1)
        ).containsExactly(1, 2);
    }
}