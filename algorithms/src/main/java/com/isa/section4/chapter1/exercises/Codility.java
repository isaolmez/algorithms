package com.isa.section4.chapter1.exercises;

public class Codility {

	public int solution(int A[]) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int length = A.length;
		long[] totals = new long[length];
		long runningTotal = 0;
		for (int i = 0; i < length; i++) {
			runningTotal += A[i];
			totals[i] = runningTotal;
		}

		if (totals[length - 1] - totals[0] == 0) {
			return 0;
		}

		for (int k = 1; k < length; k++) {
			long leftSum = totals[k - 1];
			long rightSum = totals[length - 1] - totals[k];
			if (leftSum == rightSum) {
				return k;
			}
		}

		return -1;
	}

	public int solutionTweaked(int A[]) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int length = A.length;
		for (int i = 1; i < length; i++) {
			A[i] += A[i - 1];
		}

		if (A[length - 1] - A[0] == 0) {
			return 0;
		}

		for (int k = 1; k < length; k++) {
			int leftSum = A[k - 1];
			int rightSum = A[length - 1] - A[k];
			if (leftSum == rightSum) {
				return k;
			}
		}

		return -1;
	}

	public int solutionInPlace(int A[]) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int length = A.length;
		for (int i = 1; i < length; i++) {
			A[i] += A[i - 1];
		}

		for (int k = 0; k < length; k++) {
			int leftSum = k == 0 ? 0 : A[k - 1];
			int rightSum = k == length - 1 ? 0 : A[length - 1] - A[k];
			if (leftSum == rightSum) {
				return k;
			}
		}

		return -1;
	}

	public int solutionSimple(int A[]) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int[] totals = new int[A.length];
		int runningTotal = 0;
		for (int i = 0; i < A.length; i++) {
			runningTotal += A[i];
			totals[i] = runningTotal;
		}

		for (int i = 0; i < totals.length; i++) {
			System.out.println("index" + i + ": " + totals[i]);
		}

		for (int k = 0; k < A.length; k++) {
			int leftSum = k - 1 < 0 ? 0 : totals[k - 1];
			int rightSum = k + 1 == A.length ? 0 : totals[A.length - 1] - totals[k];
			if (leftSum == rightSum) {
				return k;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] A = new int[8];
		A[0] = -1;
		A[1] = 3;
		A[2] = -4;
		A[3] = 5;
		A[4] = 1;
		A[5] = -6;
		A[6] = 2;
		A[7] = 1;

		Codility c = new Codility();
		System.out.println(c.solution(A));
	}
}
