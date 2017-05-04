package com.isa.section2.chapter3.exercises;

import java.util.Arrays;

import com.isa.section2.chapter1.Insertion;
import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.StdRandom;
import com.sedgewick.stdlib.Stopwatch;

public class Exercise_2_3_17 {
    public static void main(String[] args) { // Read strings from standard input, sort them, and print.
        // String[] a = In.readStrings();
        // String[] a = { "A", "E", "I", "C", "K", "S", "O", "R", "T", "E", "X", "U", "M", "P", "L", "Q" };
        Double[] a = new Double[10000000];
        for (int i = 0; i < 10000000; i++) {
            a[i] = (double) StdRandom.uniform(1000000);
        }

        Stopwatch st = new Stopwatch();
        Quick.sort(a);
        assert Quick.isSorted(a);
        // show(a);
        System.out.println(st.elapsedTime());
    }

    public static class Quick {

        public static void sort(Comparable[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            Comparable max = findMax(arr);
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = max;
            // show(arr);
            innerSort(arr, 0, arr.length - 1);
        }

        private static void innerSort(Comparable[] arr, int low, int high) {
            if (low + 15 >= high) {
                Insertion.sort(arr, low, high);
                return;
            }

            int partition = partition(arr, low, high);
            innerSort(arr, low, partition - 1);
            innerSort(arr, partition + 1, high);
        }

        public static int partition(Comparable[] arr, int low, int high) {
            Comparable partitionKey = arr[low];
            int headPointer = low;
            int tailPointer = high + 1;

            while (true) {
                while (less(arr[++headPointer], partitionKey))
                    ; // {}

                while (less(partitionKey, arr[--tailPointer]))
                    ; // {}

                if (headPointer >= tailPointer) {
                    break;
                }

                exch(arr, headPointer, tailPointer);
            }

            // Final exchange
            exch(arr, low, tailPointer);
            return tailPointer;
        }

        public static int partitionCustom(Comparable[] arr, int low, int high) {
            Comparable partitionKey = arr[low];
            int headPointer = low + 1;
            int tailPointer = high;
            boolean leftStopped = false;
            boolean rightStopped = false;
            while (headPointer <= tailPointer) {
                if (!leftStopped) {
                    if (!less(arr[headPointer], partitionKey)) {
                        leftStopped = true;
                    } else {
                        headPointer++;
                    }
                }

                if (!rightStopped) {
                    if (less(arr[tailPointer], partitionKey)) {
                        rightStopped = true;
                    } else {
                        tailPointer--;
                    }
                }

                if (leftStopped && rightStopped) {
                    exch(arr, headPointer, tailPointer);
                    leftStopped = rightStopped = false;
                    headPointer++;
                    tailPointer--;
                }
            }

            // Final exchange
            exch(arr, low, tailPointer);
            return tailPointer;
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        private static void show(Comparable[] a) { // Print the array, on a single line.
            for (int i = 0; i < a.length; i++)
                StdOut.print(a[i] + " ");
            StdOut.println();
        }

        public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1]))
                    return false;
            return true;
        }

        private static Comparable findMax(Comparable[] arr) {
            Comparable max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (less(max, arr[i])) {
                    max = arr[i];
                }
            }

            return max;
        }
    }
}
