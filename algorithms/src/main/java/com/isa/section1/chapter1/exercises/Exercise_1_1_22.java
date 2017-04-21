package com.isa.section1.chapter1.exercises;

import java.util.Arrays;

public class Exercise_1_1_22 {

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(search.contains(2));
        System.out.println(search.contains(7));
    }

    private static class BinarySearch {
        private int[] source;

        public BinarySearch(int[] input) {
            this.source = Arrays.copyOf(input, input.length);
            for (int i : source) {
                System.out.print(i);
            }

            System.out.println();
            Arrays.sort(this.source);
        }

        public boolean contains(int key) {
            if (rankRecursive(key, 0, source.length - 1, 0) == -1) {
                return false;
            }

            return true;
        }

        public int rankRecursive(int key, int min, int max, int degree) {
            int justify = 40 + degree;
            System.out.printf("%" + justify + "s%n", "Continuing up with min: " + (min) + " max: " + (max));

            if (min > max) {
                return -1;
            }

            int middle = (min + max) / 2;
            if (source[middle] == key) {
                return middle;
            } else {
                if (key > source[middle]) {

                    return rankRecursive(key, middle + 1, max, degree + 1);
                } else {
                    return rankRecursive(key, min, middle - 1, degree + 1);
                }
            }
        }
    }
}