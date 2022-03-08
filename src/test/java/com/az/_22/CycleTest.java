package com.az._22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CycleTest {

    @Test
    public void test() {
        assertThat(Solution.solution("1211", 10)).isEqualTo(1);
        assertThat(Solution.solution("210022", 3)).isEqualTo(3);
    }

}