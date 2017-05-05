package com.isa.section2.chapter1.exercises;

import com.isa.section2.chapter1.Insertion;
import com.sedgewick.stdlib.StdRandom;
import com.sedgewick.stdlib.Stopwatch;

import java.util.Arrays;

public class Exercise_2_1_26 {
    public static void main(String[] args) {
        int size = 20_000;
        int limit = 1_000_000;
        int[] primitiveValues = new int[size];
        Integer[] wrapperValues = new Integer[size];
        for (int i = 0; i < size; i++) {
            int val = StdRandom.uniform(limit);
            primitiveValues[i] = val;
            wrapperValues[i] = val;
        }

        Stopwatch stopwatch = new Stopwatch();
        InsertionSortWithPrimitives.sort(primitiveValues);
        assert InsertionSortWithPrimitives.isSorted(primitiveValues);
        System.out.println(stopwatch.elapsedTime());

        Integer[] copy = Arrays.copyOf(wrapperValues, wrapperValues.length);
        stopwatch = new Stopwatch();
        Insertion.sort(copy);
        assert Insertion.isSorted(copy);
        System.out.println(stopwatch.elapsedTime());

        copy = Arrays.copyOf(wrapperValues, wrapperValues.length);
        stopwatch = new Stopwatch();
        Warmup.InsertionSort.sort(copy, Warmup.DIRECTION.ASC);
        assert Warmup.InsertionSort.isSorted(copy);
        System.out.println(stopwatch.elapsedTime());

        copy = Arrays.copyOf(wrapperValues, wrapperValues.length);
        stopwatch = new Stopwatch();
        Exercise_2_1_24.InsertionSortWithSentinel.sort(copy);
        assert Exercise_2_1_24.InsertionSortWithSentinel.isSorted(copy);
        System.out.println(stopwatch.elapsedTime());
    }

    public static class InsertionSortWithPrimitives {
        public static void sort(int[] values) {
            for (int i = 0; i < values.length; i++) {
                for (int k = i; k > 0 && less(values[k], values[k - 1]); k--) {
                    exch(values, k, k - 1);
                }
            }
        }

        private static boolean less(int first, int second) {
            return first < second;
        }

        private static void exch(int[] values, int first, int second) {
            int temp = values[first];
            values[first] = values[second];
            values[second] = temp;
        }

        public static void show(int[] a) { // Print the array, on a single line.
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }

        public static boolean isSorted(int[] a) { // Test whether the array entries are in order.
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1]))
                    return false;
            return true;
        }
    }
}
