package com.az._42;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test1() {
        assertThat(
                Solution.solution(
                        new int[]{0, 1}, new int[]{4, 5},
                        new int[][]{
                                {0, 0, 4, 6, 0, 0},
                                {0, 0, 5, 2, 0, 0},
                                {0, 0, 0, 0, 4, 4},
                                {0, 0, 0, 0, 6, 6},
                                {0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0}}
                )
        ).isEqualTo(16);
    }

    @Test
    public void test2() {
        assertThat(
                Solution.solution(
                        new int[]{0},
                        new int[]{3},
                        new int[][]{
                                {0, 7, 0, 0},
                                {0, 0, 6, 0},
                                {0, 0, 0, 8},
                                {9, 0, 0, 0}}
                )
        ).isEqualTo(6);
    }
}