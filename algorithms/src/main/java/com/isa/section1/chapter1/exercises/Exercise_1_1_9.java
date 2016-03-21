package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_9 {

	public static void main(String[] args) {
		int source = 10054886;
		System.out.println(toBinaryPadded(source));
		System.out.println(toBinaryFast(source));
	}

	public static String toBinaryPadded(int n) {
		if (n < 0) {
			return "not supported";
		}

		char[] binary = new char[32];
		binary[0] = '0';

		for (int i = 31; i >= 0; i--) {
			if (n >= Math.pow(2, i)) {
				binary[31 - i] = '1';
				n = n % (int) Math.pow(2, i);
			} else {
				binary[31 - i] = '0';
			}
		}// end for

		return new String(binary);
	}// end method

	public static String toBinaryFast(int n) {
		String s = "";
		for (int i = n; n > 0; n /= 2) {
			s = (n % 2) + s;
		}// end for

		return s;
	}// end method
}
