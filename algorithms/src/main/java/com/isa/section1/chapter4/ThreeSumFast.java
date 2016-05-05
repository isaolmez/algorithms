package com.isa.section1.chapter4;

import com.isa.section1.chapter1.BinarySearch;
import com.sedgewick.stdlib.In;
import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.Stopwatch;

public class ThreeSumFast extends DoublingTestTemplate {

	public static void main(String[] args) {
		ThreeSumFast threeSumFast = new ThreeSumFast();
//		int[] numbers = { 1, 0, -1, 2, -2 };
//		System.out.println(threeSumFast.count(numbers));
//
////		 threeSumFast.run();
//		threeSumFast.ratio(100);
		
		System.out.println("1Kints.txt");
		String fileName = Thread.currentThread().getContextClassLoader().getResource("1Kints.txt").toString();
		int[] a = In.readInts(fileName);
		Stopwatch st = new Stopwatch();
		StdOut.println(threeSumFast.count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());

		System.out.println("2Kints.txt");
		fileName = Thread.currentThread().getContextClassLoader().getResource("2Kints.txt").toString();
		a = In.readInts(fileName);
		st = new Stopwatch();
		StdOut.println(threeSumFast.count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());

		System.out.println("4Kints.txt");
		fileName = Thread.currentThread().getContextClassLoader().getResource("4Kints.txt").toString();
		a = In.readInts(fileName);
		st = new Stopwatch();
		StdOut.println(threeSumFast.count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());

		System.out.println("8Kints.txt");
		fileName = Thread.currentThread().getContextClassLoader().getResource("8Kints.txt").toString();
		a = In.readInts(fileName);
		st = new Stopwatch();
		StdOut.println(threeSumFast.count(a));
		System.out.println("Elapsed Time: " + st.elapsedTime());
	}

	public int count(int[] arr) {
		int count = 0;
		// Sort -> NlogN
		BinarySearch bs = new BinarySearch(arr);

		/** N^2 logN */
		for (int i = 0; i < arr.length; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (bs.rank(-(arr[i] + arr[k])) > k) {
//					System.out.println("Numbers: " + arr[i] + " " + arr[k] + " " + arr[bs.rank(-(arr[i] + arr[k]))]);
					count++;
				}
			}
		}

		return count;
	}

	@Override
	public void methodToBePerformed(int[] arr) {
		this.count(arr);
	}
}
