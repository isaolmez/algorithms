package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_27 {
	// TODO Have to look up binomial dist.
	public static void main(String[] args) {
		System.out.println(binomial(10, 50, 0.002));
	}

	public static double binomial(int N, int k, double p) {
		if ((N == 0) || (k < 0))
			return 1.0;
		return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
	}
}
