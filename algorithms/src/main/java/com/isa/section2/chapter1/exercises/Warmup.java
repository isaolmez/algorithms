package com.isa.section2.chapter1.exercises;


public class Warmup {
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        SelectionSort.sort(a, DIRECTION.ASC);
        assert SelectionSort.isSorted(a);
        SelectionSort.show(a);

        a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        SelectionSort.sort(a, DIRECTION.DESC);
        assert SelectionSort.isSorted(a);
        SelectionSort.show(a);

        a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        InsertionSort.sort(a, DIRECTION.ASC);
        assert InsertionSort.isSorted(a);
        InsertionSort.show(a);

        a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        InsertionSort.sort(a, DIRECTION.DESC);
        assert InsertionSort.isSorted(a);
        InsertionSort.show(a);
    }

    public enum DIRECTION {
        ASC, DESC;
    }

    public static class SelectionSort {
        public static void sort(Comparable[] values, DIRECTION direction) {
            if (direction == DIRECTION.ASC) {
                sortAscending(values);
            } else {

            }
        }

        private static void sortAscending(Comparable[] values) {
            for (int i = 0; i < values.length; i++) {
                int minIndex = i;
                for (int k = i + 1; k < values.length; k++) {
                    if (less(values[k], values[minIndex])) {
                        minIndex = k;
                    }
                }

                exch(values, i, minIndex);
            }
        }

        private static void sortDescending(Comparable[] values) {
            for (int i = 0; i < values.length; i++) {
                int maxIndex = i;
                for (int k = i + 1; k < values.length; k++) {
                    if (less(values[maxIndex], values[k])) {
                        maxIndex = k;
                    }
                }

                exch(values, i, maxIndex);
            }
        }

        public static boolean less(Comparable first, Comparable second) {
            return first.compareTo(second) < 0;
        }

        public static void exch(Comparable[] values, int first, int second) {
            Comparable temp = values[first];
            values[first] = values[second];
            values[second] = temp;
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

    public static class InsertionSort {
        public static void sort(Comparable[] values, DIRECTION direction) {
            if (direction == DIRECTION.ASC) {
                sortAscending(values);
            } else {
                sortDescending(values);
            }
        }

        private static void sortAscending(Comparable[] values) {
            for (int i = 0; i < values.length; i++) {
                for (int k = i; k > 0 && less(values[k], values[k - 1]); k--) {
                    exch(values, k, k - 1);
                }
            }
        }

        private static void sortDescending(Comparable[] values) {
            for (int i = 0; i < values.length; i++) {
                for (int k = i; k > 0 && !less(values[k], values[k - 1]); k--) {
                    exch(values, k, k - 1);
                }
            }
        }

        public static boolean less(Comparable first, Comparable second) {
            return first.compareTo(second) < 0;
        }

        public static void exch(Comparable[] values, int first, int second) {
            Comparable temp = values[first];
            values[first] = values[second];
            values[second] = temp;
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
