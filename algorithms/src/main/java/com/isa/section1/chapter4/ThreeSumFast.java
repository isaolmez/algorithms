package com.isa.section1.chapter4;

import com.isa.section1.chapter1.BinarySearch;

public class ThreeSumFast extends DoublingTestTemplate {

	public static void main(String[] args) {
		ThreeSumFast threeSumFast = new ThreeSumFast();
		int[] numbers = { 1, 0, -1, 2, -2 };
		System.out.println(threeSumFast.count(numbers));

//		 threeSumFast.run();
		threeSumFast.ratio(100);
	}

	public int count(int[] arr) {
		int count = 0;
		// Sort -> NlogN
		BinarySearch bs = new BinarySearch(arr);

		// NlogN
		for (int i = 0; i < arr.length; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (bs.rank(-(arr[i] + arr[k])) > k) {
//					System.out.println("Numbers: " + arr[i] + " " + arr[k] + " " + arr[bs.rank(-(arr[i] + arr[k]))]);
					count++;
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
