package com.isa.section1.chapter4;

import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.StdRandom;
import com.sedgewick.stdlib.Stopwatch;

public class DoublingRatio {
	public static double timeTrial(int N) { // Time ThreeSum.count() for N random 6-digit ints.
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-MAX, MAX);
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}

	// same as for DoublingTest (page 177)
	public static void main(String[] args) {
		double prev = timeTrial(125);
		for (int N = 250; true; N += N) {
			double time = timeTrial(N);
			StdOut.printf("%6d %7.1f ", N, time);
			StdOut.printf("%5.1f\n", time / prev);
			prev = time;
		}
	}
}