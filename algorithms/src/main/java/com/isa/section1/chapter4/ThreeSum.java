package com.isa.section1.chapter4;

import com.sedgewick.stdlib.In;
import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.Stopwatch;

public class ThreeSum {

	public static int count(int[] numbers) {
		int count = 0;
		// Combination of 3s
		for (int i = 0; i < numbers.length; i++) {
			for (int k = i + 1; k < numbers.length; k++) {
				for (int m = k + 1; m < numbers.length; m++) {
					if (numbers[i] + numbers[k] + numbers[m] == 0) {
						System.out.println("Numbers: " + numbers[i] + " " + numbers[k] + " " + numbers[m]);
						count++;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 0, -1, 2, -2 };
		System.out.println(count(numbers));

		System.exit(1);
		String fileName = Thread.currentThread().getContextClassLoader().getResource("1Kints.txt").toString();
		int[] a = In.readInts(fileName);
		Stopwatch st = new Stopwatch();
		StdOut.println(count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());

		fileName = Thread.currentThread().getContextClassLoader().getResource("2Kints.txt").toString();
		a = In.readInts(fileName);
		st = new Stopwatch();
		StdOut.println(count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());

		fileName = Thread.currentThread().getContextClassLoader().getResource("4Kints.txt").toString();
		a = In.readInts(fileName);
		st = new Stopwatch();
		StdOut.println(count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());

		fileName = Thread.currentThread().getContextClassLoader().getResource("8Kints.txt").toString();
		a = In.readInts(fileName);
		st = new Stopwatch();
		StdOut.println(count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());

	}
}
