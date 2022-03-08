package com.az._32;

import java.math.BigInteger;

public class Solution {
    public static int solution(String x) {
        return solution(new BigInteger(x));
    }

    private static int solution(BigInteger x) {
        if (BigInteger.ONE.equals(x)) {
            return 0;
        }

        if (BigInteger.valueOf(3).equals(x)) {
            return 2;
        }

        int mod = x.mod(BigInteger.valueOf(4)).intValue();
        BigInteger next;
        if (mod == 0 || mod == 2) {
            next = x.divide(BigInteger.TWO);
        } else if (mod == 1) {
            next = x.subtract(BigInteger.ONE);
        } else {
            next = x.add(BigInteger.ONE);
        }
        return 1 + solution(next);
    }
}