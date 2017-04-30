package com.isa.section1.chapter4.exercises;

import com.isa.section1.chapter1.BinarySearch;
import com.isa.section1.chapter4.DoublingTestTemplate;

public class Exercise_1_4_14 {
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        fourSum.ratio(10);

    }

    /**
     * Growth rate: N^4
     */
    private static class FourSum extends DoublingTestTemplate {
        public int countBasic(int[] arr) {
            int count = 0;
            BinarySearch bs = new BinarySearch(arr);
            for (int i = 0; i < arr.length; i++) {
                for (int k = i + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        if (bs.rank(-(arr[i] + arr[k] + arr[l])) > l) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }

        @Override
        public void methodToBePerformed(int[] arr) {
            this.countBasic(arr);
        }
    }
}