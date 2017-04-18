package com.isa.section1.chapter1.exercises;

import java.util.Arrays;
import java.util.Random;

public class Exercise_1_1_35 {
    private static Random random = new Random();

    public static void main(String[] args) {
        int SIDES = 6;
        double[] distributions = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                distributions[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            distributions[k] /= 36.0;

        int experimentCount = 36000000;
        int[] counts = new int[2 * SIDES + 1];
        for (int i = 0; i < experimentCount; i++) {
            counts[throwTwoDices()]++;
        }

        Arrays.stream(distributions).forEach(distribution-> System.out.printf("%.3f, ", distribution));
        System.out.println();
        Arrays.stream(counts).forEach(count -> System.out.printf("%.3f, ", count / (double) experimentCount));


    }

    private static int throwDice() {
        return random.nextInt(6) + 1;
    }

    private static int throwTwoDices() {
        return throwDice() + throwDice();
    }
}
