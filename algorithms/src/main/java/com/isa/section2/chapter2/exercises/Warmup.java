package com.isa.section2.chapter2.exercises;

public class Warmup {
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MergeSort.sort(a);
        assert MergeSort.isSorted(a);
        MergeSort.show(a);

        a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MergeSort.sortBottomUp(a);
        assert MergeSort.isSorted(a);
        MergeSort.show(a);
    }

    public static class MergeSort {
        public static void sort(Comparable[] values) {
            Comparable[] aux = new Comparable[values.length];
            sort(values, aux, 0, values.length - 1);
        }

        private static void sort(Comparable[] values, Comparable[] aux, int low, int high) {
            if (low >= high) {
                return;
            }

            int middle = (low + high) / 2;
            sort(values, aux, low, middle);
            sort(values, aux, middle + 1, high);
            merge(values, aux, low, middle, high);
        }

        private static void merge(Comparable[] values, Comparable[] aux, int low, int middle, int high) {
            int leftPointer = low;
            int rightPointer = middle + 1;
            int auxPointer = low;
            while (auxPointer <= high) {
                if (leftPointer > middle) {
                    aux[auxPointer++] = values[rightPointer++];
                } else if (rightPointer > high) {
                    aux[auxPointer++] = values[leftPointer++];
                } else {
                    if (less(values[leftPointer], values[rightPointer])) {
                        aux[auxPointer++] = values[leftPointer++];
                    } else {
                        aux[auxPointer++] = values[rightPointer++];
                    }
                }
            }

            for (int i = low; i <= high; i++) {
                values[i] = aux[i];
            }
        }

        private static void sortBottomUp(Comparable[] values) {
            Comparable[] aux = new Comparable[values.length];
            for (int i = 1; i < values.length; i *= 2) {
                for (int k = 0; k < values.length; k += 2 * i) {
                    int low = k;
                    int middle = k + i - 1;
                    int high = Math.min(k + 2 * i - 1, values.length - 1);
                    merge(values, aux, low, middle, high);
                }
            }
        }

        private static boolean less(Comparable first, Comparable second) {
            return first.compareTo(second) < 0;
        }

        public static void show(Comparable[] a) { // Print the array, on a single line.
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
