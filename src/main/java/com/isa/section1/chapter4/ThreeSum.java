package com.isa.section1.chapter4;

public class ThreeSum {

	public static void count(int[] numbers) {
		int count = 0;
		// Combination of 3s
		for (int i = 0; i < numbers.length; i++) {
			for (int k = i + 1; k < numbers.length; k++) {
				for (int m = k + 1; m < numbers.length; m++) {
					System.out.println("Combination: " + numbers[i] + numbers[k] + numbers[m]);
					if (numbers[i] + numbers[k] + numbers[m] == 0) {
						count++;
					}
				}
			}
		}

		System.out.println("Count of triplets is: " + count);
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 0, -1, 2, 1 };
		count(numbers);
		
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		System.out.println(max+1);
		
		int min = Integer.MIN_VALUE;
		System.out.println(min);
		System.out.println(min -1);
		
		System.out.println(-1);
	}
}
