package com.az._31;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class XorTest {

    @Test
    public void test() {
        assertThat(Solution.solution(0, 3)).isEqualTo(2);
        assertThat(Solution.solution(17, 4)).isEqualTo(14);
    }

}