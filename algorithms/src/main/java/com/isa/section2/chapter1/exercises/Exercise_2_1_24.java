package com.isa.section2.chapter1.exercises;

public class Exercise_2_1_24 {
    public static void main(String[] args) {
        String[] a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        InsertionSortWithSentinel.sort(a);
        assert InsertionSortWithSentinel.isSorted(a);
        InsertionSortWithSentinel.show(a);
    }

    public static class InsertionSortWithSentinel {
        public static void sort(Comparable[] values) {
            int minIndex = 0;
            for (int i = 0; i < values.length; i++) {
                if (less(values[i], values[minIndex])) {
                    minIndex = i;
                }
            }
            exch(values, 0, minIndex);

            for (int i = 1; i < values.length; i++) {
                for (int k = i; less(values[k], values[k - 1]); k--) {
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
