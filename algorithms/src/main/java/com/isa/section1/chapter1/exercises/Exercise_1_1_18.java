package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_18 {

	// Harezmi's method
	public static void main(String[] args) {
		System.out.println(mystery(2, 25));
		System.out.println(mystery(3, 11));
		System.out.println(mysteryString(25));
		System.out.println(mysteryMutated(2, 5));
	}

	public static int mystery(int a, int b) {
		if (b == 0)
			return 0;
		if (b % 2 == 0)
			return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}
	
	public static int mysteryMutated(int a, int b) {
		if (b == 0)
			return 0;
		if (b % 2 == 0)
			return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) * a;
	}

	public static String mysteryString(int b) {
		if (b == 0)
			return "0";
		if (b % 2 == 0)
			return mysteryString(b / 2) + "0";
		return mysteryString(b / 2) + "1";
	}
}
