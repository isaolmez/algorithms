package com.isa.section1.chapter4.exercises;

public class Exercise_1_4_2 {
	public static void main(String[] args) {
		int[] numbers = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE - 1, Integer.MIN_VALUE + 2, 2, 3, -5 };
		ThreeSum.count(numbers);
	}
}

class ThreeSum {

	public static int count(int[] numbers) {
		int count = 0;
		// Combination of 3s
		for (int i = 0; i < numbers.length; i++) {
			for (int k = i + 1; k < numbers.length; k++) {
				/**
				 *  Prevent Overflow
				 *  Owerflow occurs when i + k > Integer.MAX_VALUE (or i + k < Integer.MIN_VALUE)
				 */
				if (numbers[k] < 0) {
					if (numbers[i] < Integer.MIN_VALUE - numbers[k]) {
						System.out.printf("Overflow prevented for: %d and %d%n", numbers[i], numbers[k]);
						continue;
					}
				} else {
					if (numbers[i] > Integer.MAX_VALUE - numbers[k]) {
						System.out.printf("Overflow prevented for: %d and %d%n", numbers[i], numbers[k]);
						continue;
					}
				}

				for (int m = k + 1; m < numbers.length; m++) {
					if (numbers[i] + numbers[k] + numbers[m] == 0) {
						System.out.println("Numbers: " + numbers[i] + " " + numbers[k] + " " + numbers[m]);
						count++;
					}
				}
			}
		}

		return count;
	}
}
