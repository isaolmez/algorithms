package com.isa.section1.chapter4;

import com.isa.section1.chapter1.BinarySearch;

public class TwoSumFast extends DoublingTestTemplate {

	public static void main(String[] args) {
		TwoSumFast twoSumFast = new TwoSumFast();
		twoSumFast.ratio(100);
	}

	/** Growth rate: NlogN */
	public int count(int[] arr) {
		int count = 0;
		// Sort -> NlogN
		BinarySearch bs = new BinarySearch(arr);

		// Loop * binary search -> NlogN 
		for (int i = 0; i < arr.length; i++) {
			if (bs.rank(-arr[i]) > i) {
				count++;
			}
		}

		return count;
	}

	@Override
	public void methodToBePerformed(int[] arr) {
		this.count(arr);
	}
}
