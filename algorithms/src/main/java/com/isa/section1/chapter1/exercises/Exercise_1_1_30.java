package com.isa.section1.chapter1.exercises;

import java.util.Arrays;

public class Exercise_1_1_30 {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] result = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = isRelativelyPrime(i, j);
            }
        }

        System.out.println(Arrays.toString(result[0]));
        System.out.println(isRelativelyPrime(3,5));
    }

    private static boolean isRelativelyPrime(int x, int y) {
        return greatestCommonDivisor(x, y) == 1;
    }

    private static int greatestCommonDivisor(int x, int y) {
        if (y > x) {
            return greatestCommonDivisor(y, x);
        }

        if (y == 0) {
            return x;
        } else {
            return greatestCommonDivisor(y, x % y);
        }
    }
}
