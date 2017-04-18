package com.isa.section1.chapter1.exercises;

import java.util.Arrays;

public class Exercise_1_1_29 {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch(new int[]{3, 5, 7, 7, 9, 9, 9, 11, 11, 11, 11, 11});
        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rank(3));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(3));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rank(5));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(5));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rank(7));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(7));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rank(9));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(9));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rank(11));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(11));
    }

    private static class BinarySearch {
        private final int[] source;

        public BinarySearch(int[] input) {
            this(input, false);
        }

        public BinarySearch(int[] input, boolean clone) {
            if (clone) {
                this.source = Arrays.copyOf(input, input.length);
            } else {
                this.source = input;
            }

            Arrays.sort(this.source);
        }

        public boolean contains(int key) {
            if (rank(key) == -1) {
                return false;
            }

            return true;
        }

        public int rank(int key) {
            return rankRecursive(key, 0, source.length - 1);
        }

        private int rankRecursive(int key, int min, int max) {
            if (min > max) {
                return -1;
            }

            int middle = (min + max) / 2;
            if (source[middle] == key) {
                return findLeftMost(key, middle);
            } else {
                if (key > source[middle]) {
                    return rankRecursive(key, middle + 1, max);
                } else {
                    return rankRecursive(key, min, middle - 1);
                }
            }
        }

        private int findLeftMost(int key, int position) {
            while (position >= 0 && source[position] == key) {
                position--;
            }
            return position + 1;
        }

        public int count(int key) {
            int count = 0;

            int position = rank(key);
            if (position >= 0) {
                while (position < source.length && source[position] == key) {
                    count++;
                    position++;
                }
            }

            return count;
        }
    }
}
