package com.isa.section1.chapter1;

import java.util.Arrays;

public class BinarySearch {
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
        return rankIterative(key);
    }

    private int rankRecursive(int key, int min, int max) {
        if (min > max) {
            return -1;
        }

        int middle = (min + max) / 2;
        if (source[middle] == key) {
            return middle;
        } else {
            if (key > source[middle]) {
                return rankRecursive(key, middle + 1, max);
            } else {
                return rankRecursive(key, min, middle - 1);
            }
        }
    }

    private int rankIterative(int key) {
        int min = 0;
        int max = source.length - 1;

        while (min <= max) {
            int middle = (min + max) / 2;
            if (source[middle] == key) {
                return middle;
            } else if (key > source[middle]) {
                min = middle + 1;
            } else if (key < source[middle]) {
                max = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch(new int[]{3, 5, 7, 9, 11});
        System.out.println(binarySearch.rankIterative(2));
        System.out.println(binarySearch.rankIterative(3));
        System.out.println(binarySearch.rankIterative(7));
        System.out.println(binarySearch.rankIterative(11));
        System.out.println(binarySearch.rankRecursive(2, 0, 4));
        System.out.println(binarySearch.rankRecursive(3, 0, 4));
        System.out.println(binarySearch.rankRecursive(7, 0, 4));
        System.out.println(binarySearch.rankRecursive(11, 0, 4));
    }
}
