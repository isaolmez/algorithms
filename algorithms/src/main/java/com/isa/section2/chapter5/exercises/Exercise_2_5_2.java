package com.isa.section2.chapter5.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.isa.section1.chapter1.BinarySearchGeneric;
import com.sedgewick.stdlib.StdRandom;
import com.sedgewick.stdlib.Stopwatch;

public class Exercise_2_5_2 {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] words = line.split(" ");
			Stopwatch st = new Stopwatch();
			detectCompoundWordsFast(words);
			System.out.println(st.elapsedTime());

			st = new Stopwatch();
			detectCompoundWords(words);
			System.out.println(st.elapsedTime());
		}

		// Needs more testing with distint values, random is not effective
		// String[] words = new String[100];
		// for (int i = 0; i < 100; i++) {
		// int length = StdRandom.uniform(10);
		// words[i] = randomString(length);
		// }
		//
		// Stopwatch st = new Stopwatch();
		// detectCompoundWordsFast(words);
		// System.out.println(st.elapsedTime());
		//
		// st = new Stopwatch();
		// detectCompoundWords(words);
		// System.out.println(st.elapsedTime());

	}

	/***
	 * N^2*LogN
	 */
	public static void detectCompoundWords(String[] arr) {
		// Sorts the array for searching. NlogN
		BinarySearchGeneric bs = new BinarySearchGeneric(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length; k++) {
				if (k == i) {
					continue;
				}

				String temp = arr[i] + arr[k];
				if (bs.contains(temp)) {
					count++;
					// System.out.println(temp);
				}
			}
		}

		System.out.println("Count: " + count);
	}

	/***
	 * ~N*LogN
	 */
	public static void detectCompoundWordsFast(String[] arr) {
		// Sorts the array for searching. NlogN
		BinarySearchGeneric bs = new BinarySearchGeneric(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			String first = arr[i];
			for (int k = i + 1; k < arr.length; k++) {
				String compoundCandidate = arr[k];
				int startingIndex = compoundCandidate.indexOf(first);
				if (startingIndex > -1) {
					String second = compoundCandidate.substring(startingIndex + first.length());
					if (bs.contains(second)) {
						count++;
						// System.out.println(compoundCandidate);
					}
				} else {
					break;
				}
			}
		}

		System.out.println("Count: " + count);
	}

	private static String randomString(int length) {
		char[] str = new char[length];
		for (int i = 0; i < length; i++) {
			str[i] = (char) (StdRandom.uniform(26) + 97);
		}

		return String.valueOf(str);
	}
}
