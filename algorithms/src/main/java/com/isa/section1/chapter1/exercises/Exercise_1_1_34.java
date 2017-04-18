package com.isa.section1.chapter1.exercises;

import java.io.InputStream;
import java.util.Scanner;

public class Exercise_1_1_34 {
    private static final int DEFAULT_N = 100;

    public static void main(String[] args) {
        System.out.printf("Max: %s %n", findMaximum(DEFAULT_N));
        System.out.printf("Min: %s %n", findMinimum(DEFAULT_N));
        System.out.printf("Kth Smallest: %s %n", findKthSmallest(DEFAULT_N, 1));
        System.out.printf("Kth Smallest: %s %n", findKthSmallest(DEFAULT_N, 2));
        System.out.printf("Kth Smallest: %s %n", findKthSmallest(DEFAULT_N, 3));
        System.out.printf("Kth Smallest: %s %n", findKthSmallest(DEFAULT_N, DEFAULT_N));
        System.out.printf("Sum of Squares : %s %n", findSumOfSquares(10));
        System.out.printf("Average: %s %n", findAverage(3));
    }

    /**
     * Store one variable using a filter
     */
    private static int findMaximum(int N) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("1Kints.txt");
        int max;
        try (Scanner scanner = new Scanner(stream)) {
            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int current = scanner.nextInt();
                if (current > max) {
                    max = current;
                }
            }
        }

        return max;
    }

    /**
     * Store one variable using a filter
     */
    private static int findMinimum(int N) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("1Kints.txt");
        try (Scanner scanner = new Scanner(stream)) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int current = scanner.nextInt();
                if (current < min) {
                    min = current;
                }
            }

            return min;
        }
    }

    /**
     * Store fixed-sized array
     */
    private static int findKthSmallest(int N, int k) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("1Kints.txt");
        try (Scanner scanner = new Scanner(stream)) {
            int[] smallest = new int[k + 1];
            for (int i = 0; i < k + 1; i++) {
                smallest[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < N; i++) {
                smallest[k] = scanner.nextInt();
                for (int j = k; j > 0 && less(smallest[j], smallest[j - 1]); j--) {
                    swap(smallest, j - 1, j);
                }
            }

            return smallest[k - 1];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }


    /**
     * Store one variable using a filter
     */
    private static long findSumOfSquares(int N) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("1Kints.txt");
        try (Scanner scanner = new Scanner(stream)) {
            long sum = 0;
            for (int i = 0; i < N; i++) {
                int current = scanner.nextInt();
                sum += (current * current);
            }

            return sum;
        }
    }

    /**
     * Store two variables
     */
    private static double findAverage(int N) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("1Kints.txt");
        try (Scanner scanner = new Scanner(stream)) {
            long sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                int current = scanner.nextInt();
                sum += current;
                count++;
            }

            return sum / (double) count;
        }
    }

}
