package com.isa.section1.chapter4.exercises;

import java.util.Arrays;

public class Exercise_1_4_20 {
    public static void main(String[] args) {
        int[] values = new int[100];
        for (int i = 0; i < 50; i++) {
            values[i] = i * 2;
        }

        for (int i = 50; i < 100; i++) {
            values[i] = (50 - 1) * 2 - ((i - 50) * 2) + 1;
        }

        System.out.println(Arrays.toString(values));

        BitonicSearch bitonicSearch = new BitonicSearch(values);
        long start = System.currentTimeMillis();
        for (int value : values) {
            bitonicSearch.find(value);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        BitonicSearchFast bitonicSearchFast = new BitonicSearchFast(values);
        start = System.currentTimeMillis();
        for (int value : values) {
            bitonicSearchFast.search(value);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        values = new int[]{9, 8, 7, 6};
        System.out.println(Arrays.toString(values));
        bitonicSearchFast = new BitonicSearchFast(values);
        System.out.println(bitonicSearchFast.findTurningIndex());
        values = new int[]{0, 1, 2, 3, 4, 9, 8, 7, 6};
        System.out.println(Arrays.toString(values));
        bitonicSearchFast = new BitonicSearchFast(values);
        System.out.println(bitonicSearchFast.findTurningIndex());
        values = new int[]{0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(values));
        bitonicSearchFast = new BitonicSearchFast(values);
        System.out.println(bitonicSearchFast.findTurningIndex());

    }

    public static class BitonicSearchFast {
        private final int[] values;
        private final int length;
        private int turningIndex = -1;

        public BitonicSearchFast(int[] values) {
            this.values = values;
            this.length = values.length;
        }

        public int rank(int key, int left, int right) {
            while (left <= right) {
                int middle = (left + right) / 2;
                if (values[middle] == key) {
                    return middle;
                } else if (key < values[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            return -1;
        }

        public int rankReversed(int key, int left, int right) {
            while (left <= right) {
                int middle = (left + right) / 2;
                if (values[middle] == key) {
                    return middle;
                } else if (key < values[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            return -1;
        }

        public int findTurningIndex() {
            int left = 0;
            int right = length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (middle == 0 || middle == length - 1) {
                    return middle;
                }

                if (values[middle - 1] < values[middle] && values[middle] < values[middle + 1]) {
                    left = middle + 1;
                } else if (values[middle - 1] > values[middle] && values[middle] > values[middle + 1]) {
                    right = middle - 1;
                } else {
                    return middle;
                }
            }

            return -1;
        }

        public int search(int target) {
            if (turningIndex < 0) {
                turningIndex = findTurningIndex();
            }

            int result = -1;
            if ((result = rank(target, 0, turningIndex)) != -1) {
                return result;
            }

            if ((result = rankReversed(target, turningIndex + 1, length - 1)) != -1) {
                return result;
            }

            return result;
        }
    }

    private static class BitonicSearch {
        private final int[] values;

        public BitonicSearch(int[] values) {
            this.values = values;
        }

        public int find(int key) {
            return find(key, 0, values.length - 1);
        }

        public int find(int key, int left, int right) {
            if (left > right) {
                return -1;
            }

            int middle = (left + right) / 2;
            if (values[middle] == key) {
                return middle;
            } else {
                if (key < values[middle]) {
                    int first = -1;
                    if (values[left] < values[middle]) {
                        first = find(key, left, middle - 1);
                        if (first != -1) {
                            return first;
                        }
                    }

                    int second = -1;
                    if (values[right] < values[middle]) {
                        second = find(key, middle + 1, right);
                        if (second != -1) {
                            return second;
                        }
                    }

                    return -1;
                } else {
                    boolean rightAscending = true;
                    boolean leftAscending = true;
                    if (middle + 1 <= right && values[middle] > values[middle + 1]) {
                        rightAscending = false;
                    }

                    if (middle - 1 >= left && values[middle - 1] > values[middle]) {
                        leftAscending = false;
                    }

                    if (leftAscending && rightAscending) {
                        return find(key, middle + 1, right);
                    } else if (!leftAscending && !rightAscending) {
                        return find(key, left, middle - 1);
                    }

                    return -1;
                }
            }
        }
    }
}
