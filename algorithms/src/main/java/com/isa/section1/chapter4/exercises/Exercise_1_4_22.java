package com.isa.section1.chapter4.exercises;


import java.util.Arrays;

public class Exercise_1_4_22 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findFibonacciParts(13)));
        int[] values = new int[100];
        for (int i = 0; i < 100; i++) {
            values[i] = i;
        }

        System.out.println(Arrays.toString(values));

        for (int value : values) {
            System.out.printf("Rank of %s: %s%n ", value, FibonacciSearch.rank(values, value));
        }
    }

    public static class FibonacciSearch {

        public static int rank(int[] source, int key) {
            int low = 0;
            int high = source.length - 1;
            int[] ks = findFibonacciParts(high - low);
            int kminus1 = ks[1];
            int kminus2 = ks[0];
            while (low <= high) {
                if (source[low + kminus2] == key) {
                    return low + kminus2;
                } else if (key < source[low + kminus2]) {
                    high = low + kminus2;
                    kminus1 = kminus1 - kminus2;
                    kminus2 = kminus2 - kminus1;
                } else {
                    low = low + kminus2;
                    ks = findFibonacciParts(high - low);
                    kminus1 = ks[1];
                    kminus2 = ks[0];
                }
            }

            return -1;
        }
    }

    private static int[] findFibonacciParts(int number) {
        if (number == 1) {
            return new int[]{1, 1};
        }

        int g = 1;
        int f = 0;
        while (true) {
            if (g + f >= number) {
                return new int[]{g, f};
            }
            int temp = f;
            f = f + g;
            g = temp;
        }
    }
}
