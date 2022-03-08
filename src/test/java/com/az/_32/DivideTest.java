package com.az._32;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @Test
    void solution() {
        assertThat(Solution.solution("15")).isEqualTo(5);
        assertThat(Solution.solution("4")).isEqualTo(2);
        assertThat(Solution.solution("12")).isEqualTo(4);
        // 12 --> 6 --> 3 --> 2 --> 1
        // 12 --> 11 -> 10 -> 9 --> 8?
        //

        assertThat(Solution.solution("13")).isEqualTo(5);
        // 13 --> 12 --> 6 --> 3 --> 2 --> 1
        // 13 --> 14 --> 7 --> 8 --> 4 --> 2 --> 1

        assertThat(Solution.solution("11")).isEqualTo(5);
        // 11 --> 12 --> 6 --> 3 --> 2 --> 1
        // 11 --> 10 --> 5 --> 4 --> 2 --> 1

        assertThat(Solution.solution("7")).isEqualTo(4);
        // 7 --> 8 --> 4 --> 2 --> 1
        // 7 --> 6 --> 3 --> 2 --> 1

        assertThat(Solution.solution("3")).isEqualTo(2);
        // 3 --> 2 --> 1

        assertThat(Solution.solution("29")).isEqualTo(7);
        // 29 --> 28 --> 14 --> 7 --> 8 --> 4 --> 2 --> 1
        // 29 --> 30 --> 31 --> 32 --> 16 --> 8 --> 4 --> 2??

        assertThat(Solution.solution("61")).isEqualTo(8);
        // 61 --> 60 --> 30 --> 15 --> 16 --> 8 --> 4 --> 2 --> 1
        // 61 --> 62 --> 63 --> 64 --> 32 --> 16 ???

        assertThat(Solution.solution("5")).isEqualTo(3);
        assertThat(Solution.solution("6")).isEqualTo(3);
    }
}