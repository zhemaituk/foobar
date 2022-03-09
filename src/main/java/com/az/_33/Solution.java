package com.az._33;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public static int[] solution(int[][] m) {
        // [0,1,0,0,0,1],  # s0, the initial state, goes to s1 and s5 with equal probability
        // [4,0,0,3,2,0],  # s1 can become s0, s3, or s4, but with different probabilities
        // [0,0,0,0,0,0],  # s2 is terminal, and unreachable (never observed in practice)
        // [0,0,0,0,0,0],  # s3 is terminal
        // [0,0,0,0,0,0],  # s4 is terminal
        // [0,0,0,0,0,0],  # s5 is terminal
        // s5 = 1/2 + 1/2*4/9*1/2 + 1/2*4/9*1/2*4/9*1/2 + = 1/2 (1+ 1/2*4/9 + (1/2*4/9)^2 +) = 1/2 * 9/7 = 9/14
        // s3 = 1/2*3/9 + 1/2*4/9*1/2*3/9 + 1/2*4/9*1/2*4/9*1/2*3/9 = 1/2*3/9 * (1 + 1/2*4/9 + (1/2*4/9)^2)
        // = 3/18 * (1 / (1-2/9)) = 3/18*9/7 = 3/14

        Set<Integer> terminals = terminals(m);

        if (terminals.contains(0)) {
            int[] r = new int[m.length + 1];
            r[0] = 1;
            r[m.length] = 1;
            return r;
        }

        removeDiagonal(m);

        Fraction[][] probabilities = probabilities(m);

        for (int i = 0; i < m.length; i++) {
            if (!terminals.contains(i)) {
                collapseState(probabilities, i);
            }
        }

        long commonDenominator = terminals.stream().map(i -> probabilities[0][i]).map(f -> f.denominator).reduce(Fraction::lcm).orElseThrow();

        Integer[] terminalsArray = terminals.toArray(new Integer[]{});
        int[] result = new int[terminals.size() + 1];
        for (int i = 0; i < terminals.size(); i++) {
            int t = terminalsArray[i];
            Fraction f = probabilities[0][t];
            result[i] = (int) (commonDenominator / f.denominator * f.numerator);
        }

        result[result.length - 1] = (int) commonDenominator;

        return result;
    }


    static void collapseState(Fraction[][] pm, int node) {
        for (int i = 0; i < pm.length; i++) {
            for (int j = 0; j < pm.length; j++) {
                if (i != node && j != node) {
                    pm[i][j] = pm[i][j].add(pm[i][node].multiply(pm[node][j]));
                }
            }
        }

        for (int i = 0; i < pm.length; i++) {
            pm[i][node] = Fraction.ZERO;
        }

        for (int i = 0; i < pm.length; i++) {
            if (!pm[i][i].equals(Fraction.ZERO)) {
                Fraction multiplier = sumGeometricSeries(pm[i][i]);
                for (int j = 0; j < pm.length; j++) {
                    if (i == j) {
                        pm[i][j] = Fraction.ZERO;
                    } else {
                        pm[i][j] = pm[i][j].multiply(multiplier);
                    }
                }
            }
        }
    }

    static Fraction sumGeometricSeries(Fraction r) {
        if (r.equals(Fraction.ONE)) {
            return Fraction.ONE;
        }
        return Fraction.ONE.divide(Fraction.ONE.subtract(r));
    }


    static Set<Integer> terminals(int[][] m) {
        Set<Integer> result = new LinkedHashSet<>();
        for (int i = 0; i < m.length; i++) {
            if (sum(m[i]) == 0) {
                result.add(i);
            }
        }
        return result;
    }

    static int sum(int[] r) {
        return IntStream.of(r).sum();
    }

    static void removeDiagonal(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            m[i][i] = 0;
        }
    }

    static Fraction[][] probabilities(int[][] m) {
        Fraction[][] result = new Fraction[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            final int sum = sum(m[i]);
            for (int j = 0; j < m.length; j++) {
                result[i][j] = sum > 0 ? new Fraction(m[i][j], sum) : Fraction.ZERO;
            }
        }
        return result;
    }


    public static class Fraction {
        public static final Fraction ZERO = new Fraction(0, 1);
        public static final Fraction ONE = new Fraction(1, 1);

        final long numerator;
        final long denominator;

        public Fraction(long numerator, long denominator) {
            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        public static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public static long lcm(long a, long b) {
            return (a / gcd(a, b)) * b;
        }

        public Fraction add(Fraction fractionTwo) {
            return new Fraction(
                    (numerator * fractionTwo.denominator) + (fractionTwo.numerator * denominator),
                    denominator * fractionTwo.denominator
            );
        }

        public Fraction subtract(Fraction fractionTwo) {
            return new Fraction(
                    (numerator * fractionTwo.denominator) - (fractionTwo.numerator * denominator),
                    denominator * fractionTwo.denominator
            );
        }

        public Fraction multiply(Fraction fractionTwo) {
            return new Fraction(numerator * fractionTwo.numerator, denominator * fractionTwo.denominator);
        }

        public Fraction divide(Fraction fractionTwo) {
            return new Fraction(numerator * fractionTwo.denominator, denominator * fractionTwo.numerator);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return numerator == fraction.numerator && denominator == fraction.denominator;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numerator, denominator);
        }

        @Override
        public String toString() {
            return numerator == 0 ? "0" : "" + numerator + " / " + denominator;
        }
    }
}