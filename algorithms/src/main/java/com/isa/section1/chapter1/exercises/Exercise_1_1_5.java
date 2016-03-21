package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_5 {
	public static void main(String[] args) {
		System.out.println(betweenZeroAndOne(0.1, 0.1));
	}

	public static boolean betweenZeroAndOne(double x, double y) {
		if ((x > 0 && x < 1) && (y > 0 && y < 1)) {
			return true;
		}

		return false;
	}
}
