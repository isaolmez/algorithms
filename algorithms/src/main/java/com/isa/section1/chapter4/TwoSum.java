package com.isa.section1.chapter4;

public class TwoSum extends DoublingTestTemplate {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		twoSum.ratio(10);
	}

	public int count(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] == -arr[k]) {
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
