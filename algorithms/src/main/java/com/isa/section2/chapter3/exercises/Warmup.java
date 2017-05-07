package com.isa.section2.chapter3.exercises;

public class Warmup {
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        QuickSort.sort(a);
        assert QuickSort.isSorted(a);
        QuickSort.show(a);
    }

    public static class QuickSort {
        public static <T extends Comparable<T>> void sort(T[] values) {
            sort(values, 0, values.length - 1);
        }


        private static <T extends Comparable<T>> void sort(T[] values, int low, int high) {
            if (low >= high) {
                return;
            }

            int partition = partition(values, low, high);
            sort(values, low, partition - 1);
            sort(values, partition + 1, high);
        }

        private static <T extends Comparable<T>> int partition(T[] values, int low, int high) {
            int left = 0;
            int right = high + 1;
            T partitionKey = values[low];
            while (true) {
                while (less(values[++left], partitionKey)) {
                    if (left == high) {
                        break;
                    }
                }

                while (less(partitionKey, values[--right])) {
                    if (right == low) {
                        break;
                    }
                }

                if (left >= right) {
                    break;
                }

                exch(values, left, right);
            }

            exch(values, low, right);
            return right;
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
                System.out.print(a[i] + " ");
            System.out.println();
        }

        public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1]))
                    return false;
            return true;
        }
    }
}
