package com.isa.section1.chapter4.exercises;

import java.util.Arrays;

import com.isa.section1.chapter4.DoublingTestTemplate;
import com.sedgewick.stdlib.In;
import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.Stopwatch;

public class Exercise_1_4_15 {
    public static void main(String[] args) {
        // TwoSumFaster twoSumFaster = new TwoSumFaster();
        // System.out.println(twoSumFaster.count(new int[] { 1, 0, -1, 2, -2, 3, 4, 5, -5 }));
        // twoSumFaster.ratio(100);
        ThreeSumFaster threeSumFaster = new ThreeSumFaster();
//		System.out.println(threeSumFaster.count(new int[] { 1, 0, -1, 2, -2 }));
        //threeSumFaster.ratio(100);

        System.out.println("1Kints.txt");
        String fileName = Thread.currentThread().getContextClassLoader().getResource("1Kints.txt").toString();
        int[] a = In.readInts(fileName);
        Stopwatch st = new Stopwatch();
        StdOut.println(threeSumFaster.count(a));
        System.out.println("Elapsed Time: " + st.elapsedTime());

        System.out.println("2Kints.txt");
        fileName = Thread.currentThread().getContextClassLoader().getResource("2Kints.txt").toString();
        a = In.readInts(fileName);
        st = new Stopwatch();
        StdOut.println(threeSumFaster.count(a));
        System.out.println("Elapsed Time: " + st.elapsedTime());

        System.out.println("4Kints.txt");
        fileName = Thread.currentThread().getContextClassLoader().getResource("4Kints.txt").toString();
        a = In.readInts(fileName);
        st = new Stopwatch();
        StdOut.println(threeSumFaster.count(a));
        System.out.println("Elapsed Time: " + st.elapsedTime());

        System.out.println("8Kints.txt");
        fileName = Thread.currentThread().getContextClassLoader().getResource("8Kints.txt").toString();
        a = In.readInts(fileName);
        st = new Stopwatch();
        StdOut.println(threeSumFaster.count(a));
        System.out.println("Elapsed Time: " + st.elapsedTime());
    }

    /**
     * Growth rate: N^2
     */
    private static class TwoSumFaster extends DoublingTestTemplate {
        public int count(int[] arr) {
            int count = 0;
            // Sort -> NlogN
            Arrays.sort(arr);

            // Linear time
            int leftIndex = 0;
            int rightIndex = arr.length - 1;
            while (leftIndex < rightIndex && arr[leftIndex] < 0 && arr[rightIndex] > 0) {
                if (-arr[leftIndex] == arr[rightIndex]) {
                    System.out.println("Numbers: " + arr[leftIndex]);
                    count++;
                    leftIndex++;
                    rightIndex--;
                } else if (-arr[leftIndex] > arr[rightIndex]) {
                    leftIndex++;
                } else if (-arr[leftIndex] < arr[rightIndex]) {
                    rightIndex--;
                }
            }

            return count;
        }

        @Override
        public void methodToBePerformed(int[] arr) {
            this.count(arr);
        }
    }

    /**
     * Growth rate is N^2
     */
    private static class ThreeSumFaster extends DoublingTestTemplate {
        public int count(int[] arr) {
            int count = 0;
            // Sort -> NlogN
            Arrays.sort(arr);

            // Linear time
            for (int i = 0; i < arr.length; i++) {
                int leftIndex = i + 1;
                int rightIndex = arr.length - 1;
                while (leftIndex < rightIndex && (arr[i] + arr[leftIndex]) < 0 && arr[rightIndex] > 0) {
                    if (-(arr[i] + arr[leftIndex]) == arr[rightIndex]) {
//					System.out.println("Numbers: " + arr[i] + " " + arr[negativeIndex] + " " + arr[positiveIndex]);
                        count++;
                        leftIndex++;
                        rightIndex--;
                    } else if (-(arr[i] + arr[leftIndex]) > arr[rightIndex]) {
                        leftIndex++;
                    } else if (-(arr[i] + arr[leftIndex]) < arr[rightIndex]) {
                        rightIndex--;
                    }
                }
            }

            return count;
        }

        @Override
        public void methodToBePerformed(int[] arr) {
            this.count(arr);
        }
    }
}