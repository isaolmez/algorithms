package com.isa.section2.chapter1.exercises;

import com.isa.section2.chapter1.Insertion;
import com.sedgewick.stdlib.StdRandom;
import com.sedgewick.stdlib.Stopwatch;

public class Exercise_2_1_8 {
	public static void main(String[] args) {
		/***
		 * Running time is quadratic
		 * 
		 * 
		 */
		for (int i = 0, n = 1000; i < 10; i++) {
			calculate(n);
			n += n;
		}
	}

	public static void calculate(int n) {
		Stopwatch st = new Stopwatch();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = String.valueOf(StdRandom.uniform(3));
		}

		Insertion.sort(a);
		System.out.println("Insertion sort: " + st.elapsedTime());

	}
}
