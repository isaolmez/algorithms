package com.isa.section1.chapter4.exercises;

public class Exercise_1_4_6 {
	
	/**
	 * Outer loop:  logN
	 * Inner loop:  2N-1/logN (Average number of loop iterations)
	 * Order of growth: N
	 */
	public void a(int N) {
		int sum = 0;
		for (int n = N; n > 0; n /= 2)
			for (int i = 0; i < n; i++)
				sum++;
	}

	/**
	 * Outer loop:  logN
	 * Inner loop:  2N-1/logN (Average number of loop iterations)
	 * Order of growth: N 
	 */
	public void b(int N) {
		int sum = 0;
		for (int i = 1; i < N; i *= 2)
			for (int j = 0; j < i; j++)
				sum++;
	}

	/**
	 * Outer loop:  logN
	 * Inner loop:  N (Number of loop iterations)
	 * Order of growth: NlogN 
	 */
	public void c(int N) {
		int sum = 0;
		for (int i = 1; i < N; i *= 2)
			for (int j = 0; j < N; j++)
				sum++;
	}

}
