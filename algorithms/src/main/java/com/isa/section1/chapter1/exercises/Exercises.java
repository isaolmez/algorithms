package com.isa.section1.chapter1.exercises;

public class Exercises {

	public static void main(String[] args) {
		// Exercise 1.1.1
		System.out.println((0 + 15) / 2);
		System.out.println(2.0e-6 * 100000000.12);
		System.out.println(true && false || true && true);

		// Exercise 1.1.2
		System.out.println((1 + 2.236) / 2);
		System.out.println(1 + 2 + 3 + 4.0);
		System.out.println(4.1 >= 4);
		System.out.println(1 + 2 + "3");

		int a = 0, b = 0, c = 0;
		if (a > b)
			c = 0;

		fibonacci();

		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > .001)
			t = (9.0 / t + t) / 2.0;
		System.out.printf("%.5f\n", t);

		int sum = 0;
		for (int i = 1; i < 1000; i++)
			for (int j = 0; j < i; j++)
				sum++;
		System.out.println(sum);

		sum = 0;
		for (int i = 1; i < 1000; i *= 2)
			for (int j = 0; j < i; j++)
				sum++;
		System.out.println(sum);

		System.out.println('b');
		System.out.println(('b' + 'c'));
		System.out.println((char) ('a' + 4));
		System.out.println((char) 300);

		int source = 10054886;
		System.out.println(toBinary(source));
		System.out.println(toBinaryFast(source));

		// Truncates extra decimal points
		float f = 1.000000123456F;
		System.out.println("float:" + f);

		// Truncation 2
		int m = Integer.MAX_VALUE;
		System.out.println("Integer max: " + (m));
		System.out.println("Integer max +1: " + (m + 1));

		int min = Integer.MIN_VALUE;
		System.out.println("Integer min: " + (min));
		System.out.println("Integer min - 1: " + (min - 1));

		swapWeird();
		swapHalf();
		swap();
	}

	public boolean betweenZeroAndOne(double x, double y) {
		if ((x > 0 && x < 1) && (y > 0 && y < 1)) {
			return true;
		}

		return false;
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

	public static String toBinary(int n) {
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
		while (n > 0) {
			s = (n % 2) + s;
			n /= 2;
		}// end for

		return s;
	}// end method

	public static String toBinaryRecursive(int n) {
		if (n <= 0) {
			return "";
		}

		return toBinaryRecursive(n / 2) + (n % 2);
	}

	public static void swapWeird() {
		System.out.println();
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = 9 - i;

		for (int i = 0; i < 10; i++)
			a[i] = a[a[i]];

		for (int i = 0; i < 10; i++)
			System.out.print(a[i]);
	}

	public static void swap() {
		System.out.println();
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = 9 - i;

		for (int i = 0; i < 10 / 2; i++) {
			int temp = a[i];
			a[i] = a[9 - i];
			a[9 - i] = temp;
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(a[i]);
		}
	}

	public static void swapHalf() {
		System.out.println();
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = 9 - i;

		for (int i = 0; i < 10 / 2; i++) {
			int temp = a[i];
			a[i] = a[9 - i];
			// a[9-i] = temp;
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(a[i]);
		}
	}
}
