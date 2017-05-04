package com.isa.section1.chapter1.exercises;

import java.util.Arrays;

public class Exercise_1_1_29 {
    public static void main(String[] args) {
        BinarySearchInLinear binarySearchInLinear = new BinarySearchInLinear(new int[]{3, 5, 7, 7, 9, 9, 9, 11, 11, 11, 11, 11});
        System.out.printf("Rank of %s : %s%n", 3, binarySearchInLinear.rank(3));
        System.out.printf("Count of %s : %s%n", 3, binarySearchInLinear.count(3));

        System.out.printf("Rank of %s : %s%n", 3, binarySearchInLinear.rank(5));
        System.out.printf("Count of %s : %s%n", 3, binarySearchInLinear.count(5));

        System.out.printf("Rank of %s : %s%n", 3, binarySearchInLinear.rank(7));
        System.out.printf("Count of %s : %s%n", 3, binarySearchInLinear.count(7));

        System.out.printf("Rank of %s : %s%n", 3, binarySearchInLinear.rank(9));
        System.out.printf("Count of %s : %s%n", 3, binarySearchInLinear.count(9));

        System.out.printf("Rank of %s : %s%n", 3, binarySearchInLinear.rank(11));
        System.out.printf("Count of %s : %s%n", 3, binarySearchInLinear.count(11));


        BinarySearch binarySearch = new BinarySearch(new int[]{3, 5, 7, 7, 9, 9, 9, 11, 11, 11, 11, 11});
        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rankWithLeft(3));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(3));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rankWithLeft(5));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(5));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rankWithLeft(7));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(7));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rankWithLeft(9));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(9));

        System.out.printf("Rank of %s : %s%n", 3, binarySearch.rankWithLeft(11));
        System.out.printf("Count of %s : %s%n", 3, binarySearch.count(11));
    }

    public static class BinarySearchInLinear {
        private final int[] source;

        public BinarySearchInLinear(int[] input) {
            this(input, false);
        }

        public BinarySearchInLinear(int[] input, boolean clone) {
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

        private int rankRecursive(int key, int left, int right) {
            if (left > right) {
                return -1;
            }

            int middle = (left + right) / 2;
            if (source[middle] == key) {
                return findLeftMost(key, middle);
            } else {
                if (key > source[middle]) {
                    return rankRecursive(key, middle + 1, right);
                } else {
                    return rankRecursive(key, left, middle - 1);
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

    public static class BinarySearch {
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
            if (rankWithLeft(key) == -1) {
                return false;
            }

            return true;
        }

        public int rankWithLeft(int key) {
            return rankWithLeft(key, 0, source.length - 1);
        }

        private int rankWithLeft(int key, int left, int right) {
            if (left > right) {
                return -1;
            }

            int middle = (left + right) / 2;
            if (source[middle] == key) {
                if (left == right) {
                    return middle;
                } else {
                    return rankWithLeft(key, left, middle);
                }
            } else {
                if (key > source[middle]) {
                    return rankWithLeft(key, middle + 1, right);
                } else {
                    return rankWithLeft(key, left, middle - 1);
                }
            }
        }

        public int rankWithRight(int key) {
            return rankWithRight(key, 0, source.length - 1);
        }

        private int rankWithRight(int key, int left, int right) {
            if (left > right) {
                return -1;
            }

            int middle = (left + right + 1) / 2;
            if (source[middle] == key) {
                if (left == right) {
                    return middle;
                } else {
                    return rankWithRight(key, middle, right);
                }
            } else {
                if (key > source[middle]) {
                    return rankWithRight(key, middle + 1, right);
                } else {
                    return rankWithRight(key, left, middle - 1);
                }
            }
        }

        public int count(int key) {
            int leftMost = rankWithLeft(key);
            int rightMost = rankWithRight(key);
            return rightMost - leftMost + 1;
        }
    }
}
