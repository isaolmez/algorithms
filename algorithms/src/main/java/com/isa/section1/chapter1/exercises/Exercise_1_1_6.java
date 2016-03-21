package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_6 {
	public static void main(String[] args) {
		fibonacci();
	}

	public static void fibonacci() {
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			System.out.println(f);
			f = f + g;
			g = f - g;
		}
	}
}
