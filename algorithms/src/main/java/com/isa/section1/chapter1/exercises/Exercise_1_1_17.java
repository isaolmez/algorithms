package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_17 {

	public static void main(String[] args) {
		System.out.println(exR2(6));
	}

	public static String exR2(int n) {
		String s = exR2(n - 3) + n + exR2(n - 2) + n;
		if (n <= 0)
			return "";
		return s;
	}
}
