package com.isa.section1.chapter4.exercises;

import java.util.Arrays;

public class Exercise_1_4_16 {

    public static void main(String[] args) {
        double[] values = {1, 2, 3, 4, -1, -5, -5.5};
        System.out.println(ClosestPair.findClosestPair(values));
    }

    private static class ClosestPair {
        public static double findClosestPair(double[] values) {
            Arrays.sort(values);
            double minDistance = Integer.MAX_VALUE;
            for (int i = 1; i < values.length; i++) {
                double distance = values[i] - values[i - 1];
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }

            return minDistance;
        }
    }
}
