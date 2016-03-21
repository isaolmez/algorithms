package com.isa.section1.chapter1;

public class Exercises {

	public static void main(String[] args) {
		System.out.println((0 + 15) / 2);
		System.out.println(2.0e-6 * 100000000.12);
		System.out.println(true && false || true && true);

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
		System.out.println(toBinary2(source));

		// Truncates extra decimal points
		float f = 1.000000123456F;
		System.out.println("float:" + f);
		
		// Truncation 2
		int m = Integer.MAX_VALUE;
		System.out.println("Integer max: " + (m));
		System.out.println("Integer max +1: " + (m+1));
		
		int min = Integer.MIN_VALUE;
		System.out.println("Integer min: " + (min));
		System.out.println("Integer min - 1: " + (min-1));
		
		swap();
		swap2();
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

	public static String toBinary2(int n) {
		String s = "";
		for (int i = n; n > 0; n /= 2) {
			s = (n % 2) + s;
		}// end for

		return s;
	}// end method
	
	public static void swap(){
		System.out.println();
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
		a[i] = 9 - i;
		
		for (int i = 0; i < 10; i++)
		a[i] = a[a[i]];
		
		for (int i = 0; i < 10; i++)
		System.out.print(a[i]);	
	}
	
	public static void swap2(){
		System.out.println();
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
		a[i] = 9 - i;
		
		for (int i = 0; i < 10/2; i++)
		{
			int temp = a[i];
			a[i] = a[a[i]];
			a[temp] = temp;
		}
		
		for (int i = 0; i < 10; i++)
			System.out.print(a[i]);	
	}
}
