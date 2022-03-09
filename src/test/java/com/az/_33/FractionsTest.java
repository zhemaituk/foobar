package com.az._33;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FractionsTest {

    @Test
    void testCase1() {

        assertThat(
                Solution.solution(new int[][]{{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}})
        ).containsExactly(7, 6, 8, 21);

    }

    @Test
    void testCase2() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1, 0, 0, 0, 1},
                        {4, 0, 0, 3, 2, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}
                })
        ).containsExactly(0, 3, 2, 9, 14);

    }

    @Test
    void testCase3() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1},
                        {0, 0},
                })
        ).containsExactly(1, 1);

    }

    @Test
    void testCase4() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1, 1},
                        {0, 0, 0},
                        {0, 0, 0},
                })
        ).containsExactly(1, 1, 2);

    }

    @Test
    void testCase5() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1, 1},
                        {1, 0, 1},
                        {0, 0, 0},
                })
        ).containsExactly(1, 1);

    }

    @Test
    void testCase6() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1, 1, 1},
                        {1, 0, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                })
        ).containsExactly(1, 1, 2);

    }

    @Test
    void testCase7() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 0, 0, 0},
                        {1, 0, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                })
        ).containsExactly(1, 0, 0, 0, 1);

    }

    @Test
    void testCase8() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1, 1, 1},
                        {1, 0, 1, 1},
                        {1, 1, 0, 1},
                        {0, 0, 0, 0},
                })
        ).containsExactly(1, 1);

    }

    @Test
    void testCase9() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                })
        ).containsExactly(1, 1, 2);

    }

    @Test
    void testCase10() {

        assertThat(
                Solution.solution(new int[][]{
                        {0, 1, 1, 1},
                        {1, 0, 1, 1},
                        {1, 1, 0, 1},
                        {0, 0, 0, 0},
                })
        ).containsExactly(1, 1);

    }

    @Test
    void testCase11() {

        assertThat(
                Solution.solution(new int[][]{
                        {0},
                })
        ).containsExactly(1, 1);

    }

    @Test
    void test6() {
        assertThat(
                Solution.solution(new int[][]{
                        {0, 7, 0, 17, 0, 1, 0, 5, 0, 2},
                        {0, 0, 29, 0, 28, 0, 3, 0, 16, 0},
                        {0, 3, 0, 0, 0, 1, 0, 0, 0, 0},
                        {48, 0, 3, 0, 0, 0, 17, 0, 0, 0},
                        {0, 6, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                })
        ).containsExactly(4, 5, 5, 4, 2, 20);
    }

    @Test
    void test10() {
        assertThat(
                Solution.solution(new int[][]{
                        {0, 0, 0, 0, 3, 5, 0, 0, 0, 2},
                        {0, 0, 4, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 4, 4, 0, 0, 0, 1, 1},
                        {13, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                        {0, 1, 8, 7, 0, 0, 0, 1, 3, 0},
                        {1, 7, 0, 0, 0, 0, 0, 2, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                })
        ).containsExactly(1, 1, 1, 2, 5);
    }
}