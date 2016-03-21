package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_20 {
	public static void main(String[] args) {
		System.out.println(lnFactorial(4));
	}

	public static double lnFactorial(int n) {
		if (n == 0) {
			return 0;
		}

		return Math.log(n) + lnFactorial(n - 1);
	}
}
