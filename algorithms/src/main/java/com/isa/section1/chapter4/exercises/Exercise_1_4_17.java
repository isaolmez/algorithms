package com.isa.section1.chapter4.exercises;

import java.util.Arrays;

public class Exercise_1_4_17 {

    public static void main(String[] args) {
        double[] values = {1, 2, 3, 4, -1, -5, -5.5, -4, 1, 5};
        System.out.println(IncreasingFarthestPair.findIncreasingFarthestPairSum(values));
        System.out.println(Arrays.toString(IncreasingFarthestPair.findIncreasingFarthestPair(values)));

        System.out.println(IncreasingFarthestPair.findIncreasingFarthestPairSumWithoutPreprocess(values));
        System.out.println(Arrays.toString(IncreasingFarthestPair.findIncreasingFarthestPairWithoutPreprocess(values)));

        System.out.println(Arrays.toString(IncreasingFarthestPair.findIncreasingFarthestPairSumWithLocalMin(values)));
        System.out.println(Arrays.toString(IncreasingFarthestPair.findIncreasingFarthestPairWithLocalMin(values)));

        System.out.println(Arrays.toString(GlobalFarthestPair.findGlobalFarthestPair(values)));
    }

    private static class IncreasingFarthestPair {
        public static void preProcess(double[] values) {
            for (int i = values.length - 1; i > 0; i--) {
                values[i] = values[i] - values[i - 1];
            }

            values[0] = 0;
        }

        public static double findIncreasingFarthestPairSum(double[] inputValues) {
            if (inputValues == null || inputValues.length < 2) {
                throw new IllegalArgumentException();
            }

            double[] values = Arrays.copyOf(inputValues, inputValues.length);
            System.out.println(Arrays.toString(values));
            preProcess(values);

            double localMaxSum = 0;
            double localSum = 0;
            for (int i = 1; i < values.length; i++) {
                localSum += values[i];
                if (localSum > 0) {
                    if (localSum > localMaxSum) {
                        localMaxSum = localSum;
                    }
                } else {
                    localSum = 0;
                }
            }

            return localMaxSum;
        }

        public static int[] findIncreasingFarthestPair(double[] inputValues) {
            if (inputValues == null || inputValues.length < 2) {
                throw new IllegalArgumentException();
            }

            double[] values = Arrays.copyOf(inputValues, inputValues.length);
            System.out.println(Arrays.toString(values));
            preProcess(values);

            double globalMaxSum = 0;
            double localSum = 0;
            int localStart = 0;
            int finalLocalStart = 0;
            int finalLocalFinish = 0;
            for (int i = 1; i < values.length; i++) {
                localSum += values[i];
                if (localSum > 0) {
                    if (localSum > globalMaxSum) {
                        globalMaxSum = localSum;
                        finalLocalFinish = i;
                        finalLocalStart = localStart;
                    }
                } else {
                    localSum = 0;
                    localStart = i;
                }
            }

            return new int[]{finalLocalStart, finalLocalFinish};
        }

        public static double findIncreasingFarthestPairSumWithoutPreprocess(double[] inputValues) {
            if (inputValues == null || inputValues.length < 2) {
                throw new IllegalArgumentException();
            }

            double[] values = Arrays.copyOf(inputValues, inputValues.length);
            System.out.println(Arrays.toString(values));

            double globalMaxDifference = 0;
            double localDifference;
            int localStart = 0;
            for (int i = 1; i < values.length; i++) {
                localDifference = values[i] - values[localStart];
                if (localDifference > 0) {
                    if (localDifference > globalMaxDifference) {
                        globalMaxDifference = localDifference;
                    }
                } else {
                    localStart = i;
                }
            }

            return globalMaxDifference;
        }

        public static int[] findIncreasingFarthestPairWithoutPreprocess(double[] inputValues) {
            if (inputValues == null || inputValues.length < 2) {
                throw new IllegalArgumentException();
            }

            double[] values = Arrays.copyOf(inputValues, inputValues.length);
            System.out.println(Arrays.toString(values));

            double globalMaxDifference = 0;
            double localDifference;
            int localStart = 0;
            int finalLocalStart = 0;
            int finalLocalFinish = 0;
            for (int i = 1; i < values.length; i++) {
                localDifference = values[i] - values[localStart];
                if (localDifference > 0) {
                    if (localDifference > globalMaxDifference) {
                        globalMaxDifference = localDifference;
                        finalLocalFinish = i;
                        finalLocalStart = localStart;
                    }
                } else {
                    localStart = i;
                }
            }

            return new int[]{finalLocalStart, finalLocalFinish};
        }

        public static double[] findIncreasingFarthestPairSumWithLocalMin(double[] inputValues) {
            if (inputValues == null || inputValues.length < 2) {
                throw new IllegalArgumentException();
            }

            double[] values = Arrays.copyOf(inputValues, inputValues.length);
            System.out.println(Arrays.toString(values));
            preProcess(values);

            double globalMaxSum = 0;
            double runningSum = 0;
            double localMin = 0;
            double finalLocalMin = 0;

            for (int i = 1; i < values.length; i++) {
                runningSum += values[i];
                double tempSum = runningSum - localMin;
                if (tempSum > 0) {
                    if (tempSum > globalMaxSum) {
                        globalMaxSum = tempSum;
                        finalLocalMin = localMin;
                    }
                } else {
                    localMin = runningSum;
                }
            }

            return new double[]{globalMaxSum, finalLocalMin};
        }

        public static double[] findIncreasingFarthestPairWithLocalMin(double[] inputValues) {
            if (inputValues == null || inputValues.length < 2) {
                throw new IllegalArgumentException();
            }

            double[] values = Arrays.copyOf(inputValues, inputValues.length);
            System.out.println(Arrays.toString(values));
            preProcess(values);

            double globalMaxSum = 0;
            double runningSum = 0;
            double localMin = 0;
            double finalLocalMin = 0;
            int localStart = 0;
            int finalLocalStart = 0;
            int finalLocalFinish = 0;
            for (int i = 1; i < values.length; i++) {
                runningSum += values[i];
                double tempSum = runningSum - localMin;
                if (tempSum > 0) {
                    if (tempSum > globalMaxSum) {
                        globalMaxSum = tempSum;
                        finalLocalFinish = i;
                        finalLocalStart = localStart;
                        finalLocalMin = localMin;
                    }
                } else {
                    localMin = runningSum;
                    localStart = i;
                }
            }

            return new double[]{finalLocalStart, finalLocalFinish, finalLocalMin};
        }
    }

    private static class GlobalFarthestPair {
        public static int[] findGlobalFarthestPair(double[] inputValues) {
            if (inputValues == null || inputValues.length < 2) {
                throw new IllegalArgumentException();
            }

            double[] values = Arrays.copyOf(inputValues, inputValues.length);
            System.out.println(Arrays.toString(values));

            double max = 0;
            double min = 0;
            int maxIndex = 0;
            int minIndex = 0;
            double runningDifference;
            for (int i = 1; i < values.length; i++) {
                runningDifference = values[i] - values[0];
                if(runningDifference > max){
                    max = runningDifference;
                    maxIndex = i;
                }

                if(runningDifference < min){
                    min = runningDifference;
                    minIndex = i;
                }
            }

            return new int[]{minIndex, maxIndex};
        }
    }
}
