package com.isa.section1.chapter4;

import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.StdRandom;
import com.sedgewick.stdlib.Stopwatch;

public abstract class DoublingTestTemplate {
	public double timeTrial(int N) { // Time ThreeSum.count() for N random 6-digit ints.
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-MAX, MAX);
		Stopwatch timer = new Stopwatch();
		methodToBePerformed(a);
		return timer.elapsedTime();
	}

	public void run(int n) { // Print table of running times.
		for (int N = 250; n-- > 0; N += N) { // Print time for problem size N.
			double time = timeTrial(N);
			StdOut.printf("%7d %5.1f\n", N, time);
		}
	}

	public void run() { // Print table of running times.
		for (int N = 250; true; N += N) { // Print time for problem size N.
			double time = timeTrial(N);
			StdOut.printf("%7d %5.1f\n", N, time);
		}
	}

	public void ratio(int n) {
		double prev = timeTrial(125);
		for (int N = 250; n-- > 0; N += N) {
			double time = timeTrial(N);
			StdOut.printf("%6d %7.1f ", N, time);
			StdOut.printf("%5.3f ", time / prev);
			StdOut.printf("%5.3f\n", Math.log(time / prev) / Math.log(2));
			prev = time;
		}
	}

	public void ratio() {
		double prev = timeTrial(125);
		for (int N = 250; true; N += N) {
			double time = timeTrial(N);
			StdOut.printf("%6d %7.1f ", N, time);
			StdOut.printf("%5.3f ", time / prev);
			StdOut.printf("%5.3f\n", Math.log(time / prev) / Math.log(2));
			prev = time;
		}
	}

	public abstract void methodToBePerformed(int[] arr);
	/***
	 * Can be overloaded for other types
	 */
	// public abstract void methodToBePerformed(int val);
	// public abstract void methodToBePerformed(String val);

}