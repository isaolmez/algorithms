package com.isa.section2.chapter2.exercises;

public class Exercise_2_2_21 {
    public static void main(String[] args) {
        int[] first = {1, 2, 3, 4, 9};
        int[] second = {5, 6, 7, 8, 9};
        int[] third = {1, 2, 3, 6, 9};

        System.out.println(Triplicates.findFirstCommon(first, second, third));
    }

    public static class Triplicates {
        public static int findFirstCommon(int[] first, int[] second, int[] third) {
            int firstPointer = 0;
            int secondPointer = 0;
            int thirdPointer = 0;
            while (firstPointer < first.length && secondPointer < second.length && thirdPointer < third.length) {
                int firstVal = first[firstPointer];
                int secondVal = second[secondPointer];
                int thirdVal = third[thirdPointer];
                if (firstVal == secondVal && firstVal == thirdVal) {
                    return firstVal;
                } else {
                    int max = Math.max(Math.max(firstVal, secondVal), thirdVal);
                    if (firstVal < max) {
                        firstPointer++;
                    }
                    if (secondVal < max) {
                        secondPointer++;
                    }
                    if (thirdVal < max) {
                        thirdPointer++;
                    }
                }
            }

            return -1;
        }
    }
}
