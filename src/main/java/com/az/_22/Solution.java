package com.az._22;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Solution {
    public static int solution(String n, int b) {
        Set<String> seen = new HashSet<String>();

        String next = n;
        String firstEncounter = null;
        int result = 0;
        while (true) {
            if (firstEncounter == null) {
                if (seen.contains(next)) {
                    firstEncounter = next;
                } else {
                    seen.add(next);
                }
            } else {
                result++;
                if (firstEncounter.equals(next)) {
                    return result;
                }
            }

            next = next(next, b);
        }
    }

    private static String next(String n, int b) {
        String low = sortChars(n);
        String high = reverse(low);

        BigInteger next = new BigInteger(high, b)
                .subtract(new BigInteger(low, b));

        return padLeft(next.toString(b), n.length());
    }

    private static String sortChars(String n) {
        char[] chars = n.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static String reverse(String n) {
        return new StringBuilder(n).reverse().toString();
    }

    private static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s).replace(' ', '0');
    }

}