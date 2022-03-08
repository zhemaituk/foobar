package com.az._31;

public class Solution {

    // last digit:
    // 0..4k -> 0
    // 0..4k+1 -> 1
    // 0..4k+2 -> 1
    // 0..4k+3 -> 0

    // 4K:
    // 0..4k-1 -> 0
    // 4k..8k-2 -> 1
    // 8k..12k-3 -> 1
    // 12k..16k-4 -> 0

    // 4K+1:
    // 0..4k -> 0
    // 4k+1..8k -> 0
    // 8k+2..12k -> 1
    // 12k+3..16k -> 1

    // 4K+2:
    // 0..4k+1 -> 1
    // 4k+2..8k+2 -> 0
    // 8k+4..12k+3 -> 0
    // 12k+2..16k+4 -> 1

    // 4K+3:
    // 0..4k+2 -> 1
    // 4k+3..8k+4 --> 1
    // 8k+6..12k+6 --> 0
    // 12k+9..16k+8 --> 0

    // 0 1 0 /
    // 1 0 / 1
    // 0 / 1 0

    // 0 0 1 /
    // 1 0 / 0
    // 1 / 1 0

    // 0 0 0 /
    // 0 1 / 1
    // 1 / 1 0

    // 0 0 0 /
    // 0 / 0 0
    // / 0 0 1

    public static int solution(int start, int length) {
        int result = 0;
        for (int line = 0; line < length; line++) {
            result = result ^ xor(start, start + length - line - 1);
            start += length;
        }

        return result;
    }

    private static int xor(int from, int to) {
        if (from == 0) {
            return xorFromOne(to);
        }
        return xorFromOne(from - 1) ^ xorFromOne(to);
    }

    private static int xorFromOne(int to) {
        int mod = to % 4;

        if (mod == 0) {
            return to;
        } else if (mod == 1) {
            return 1;
        } else if (mod == 2) {
            return to + 1;
        } else if (mod == 3) {
            return 0;
        }

        throw new IllegalArgumentException("Invalid argument: " + to);
    }


}
