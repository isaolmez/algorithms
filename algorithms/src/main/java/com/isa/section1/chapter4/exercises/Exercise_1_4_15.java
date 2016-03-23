package com.isa.section1.chapter4.exercises;

import java.util.Arrays;

import com.isa.section1.chapter4.DoublingTestTemplate;

public class Exercise_1_4_15 {
	public static void main(String[] args) {
		// TwoSumFaster twoSumFaster = new TwoSumFaster();
		// System.out.println(twoSumFaster.count(new int[] { 1, 0, -1, 2, -2, 3, 4, 5, -5 }));
		// twoSumFaster.ratio(100);
		ThreeSumFaster threeSumFaster = new ThreeSumFaster();
		System.out.println(threeSumFaster.count(new int[] { 1, 0, -1, 2, -2 }));
		threeSumFaster.ratio(100);
	}
}

class TwoSumFaster extends DoublingTestTemplate {
	public int count(int[] arr) {
		int count = 0;
		// Sort -> NlogN
		Arrays.sort(arr);

		// Linear time
		int negativeIndex = 0;
		int positiveIndex = arr.length - 1;
		while (negativeIndex < positiveIndex && arr[negativeIndex] < 0 && arr[positiveIndex] > 0) {
			if (-arr[negativeIndex] == arr[positiveIndex]) {
				System.out.println("Numbers: " + arr[negativeIndex]);
				count++;
				negativeIndex++;
				positiveIndex--;
			} else if (-arr[negativeIndex] > arr[positiveIndex]) {
				negativeIndex++;
			} else if (-arr[negativeIndex] < arr[positiveIndex]) {
				positiveIndex--;
			}
		}

		return count;
	}

	@Override
	public void methodToBePerformed(int[] arr) {
		this.count(arr);
	}
}

class ThreeSumFaster extends DoublingTestTemplate {
	public int count(int[] arr) {
		int count = 0;
		// Sort -> NlogN
		Arrays.sort(arr);

		// Linear time
		for (int i = 0; i < arr.length; i++) {
			int negativeIndex = i + 1;
			int positiveIndex = arr.length - 1;
			while (negativeIndex < positiveIndex && (arr[i] + arr[negativeIndex]) < 0 && arr[positiveIndex] > 0) {
				if (-(arr[i] + arr[negativeIndex]) == arr[positiveIndex]) {
//					System.out.println("Numbers: " + arr[i] + " " + arr[negativeIndex] + " " + arr[positiveIndex]);
					count++;
					negativeIndex++;
					positiveIndex--;
				} else if (-(arr[i] + arr[negativeIndex]) > arr[positiveIndex]) {
					negativeIndex++;
				} else if (-(arr[i] + arr[negativeIndex]) < arr[positiveIndex]) {
					positiveIndex--;
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