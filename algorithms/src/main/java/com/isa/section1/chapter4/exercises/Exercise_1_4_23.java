package com.isa.section1.chapter4.exercises;

import com.isa.section1.chapter1.exercises.Exercise_1_1_29;
import com.sedgewick.stdlib.Stopwatch;

public class Exercise_1_4_23 {
    public static void main(String[] args) {
        int[] floors = new int[]{1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1};
        Exercise_1_4_20.BitonicSearchFast bitonicSearchFast = new Exercise_1_4_20.BitonicSearchFast(floors);
        System.out.println(bitonicSearchFast.findTurningIndex());
        System.out.println(ThrowingEggs.findFloow(floors, -1));

        floors = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        Exercise_1_1_29.BinarySearch binarySearch = new Exercise_1_1_29.BinarySearch(floors);
        System.out.println(binarySearch.rankWithLeft(2));
        System.out.println(ThrowingEggs.findFloow(floors, 2));
        System.out.println(ThrowingEggs.findFloow(floors, 1));


        // Compare with traditional binary search
        int[] values = new int[10000];
        for (int i = 0; i < 10000; i++) {
            values[i] = i;
        }

        Stopwatch stopwatch = new Stopwatch();
        for (int value : values) {
            ThrowingEggs.rankSearch(values, value);
        }
        System.out.println(stopwatch.elapsedTime());

        stopwatch = new Stopwatch();
        for (int value : values) {
            ThrowingEggs.rankSearchClassic(values, value);
        }
        System.out.println(stopwatch.elapsedTime());
    }

    public static class ThrowingEggs {

        public static int findFloow(int[] values, int key) {
            int power = -1;
            int low = 0;
            int high = values.length - 1;
            int increment = (int) Math.pow(2, power);
            while (low + increment <= high) {
                if (values[low + increment] == key) {
                    if (increment == 0) {
                        return low;
                    }

                    high = low + increment;
                    low = low + increment / 2 + 1;
                    power = -1;
                } else {
                    power++;
                }

                increment = (int) Math.pow(2, power);
                if (low + increment > high) {
                    low = low + increment / 2;
                    power = -1;
                    increment = (int) Math.pow(2, power);
                }
            }

            return -1;
        }

        public static int rankSearch(int[] values, int key) {
            int power = -1;
            int low = 0;
            int high = values.length - 1;
            int increment = (int) Math.pow(2, power);
            while (low + increment <= high) {
                if (values[low + increment] >= key) {
                    if (increment == 0) {
                        return low;
                    }

                    high = low + increment;
                    low = low + increment / 2 + 1;
                    power = -1;
                } else {
                    power++;
                }

                increment = (int) Math.pow(2, power);
                if (low + increment > high) {
                    low = low + increment / 2;
                    power = -1;
                    increment = (int) Math.pow(2, power);
                }
            }

            return -1;
        }

        public static int rankSearchClassic(int[] values, int key) {
            int low = 0;
            int high = values.length - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (values[middle] == key) {
                    return middle;
                } else if (key < values[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }

            return -1;
        }
    }
}
