package com.isa.section2.chapter5;

import com.isa.section2.chapter3.Quick;

public class Distincts {
	public static void main(String[] args) {
		String[] arr = new String[] { "a", "z", "b", "t", "a", "t", "z", "x", "g" };

		// Search Backward
		distinctCountWithSort(arr);
		duplicateCountWithSort(arr);

		// Search Backward
		distinctCountWithoutSort(arr);
		duplicateCountWithoutSort(arr);

		// Search Forward
		distinctCountWithoutSort2(arr);
		duplicateCountWithoutSort2(arr);
	}

	/**
	 * NLogN => linearithmetic
	 */
	public static void distinctCountWithSort(Comparable[] arr) {
		Quick.sort(arr);
		int count = 1; // Assume a.length > 0.
		for (int i = 1; i < arr.length; i++)
			if (arr[i].compareTo(arr[i - 1]) != 0)
				count++;

		System.out.println(count);
	}

	/**
	 * NLogN => linearithmetic
	 */
	public static void duplicateCountWithSort(Comparable[] arr) {
		Quick.sort(arr);
		int count = 0; // Assume a.length > 0.
		for (int i = 1; i < arr.length; i++)
			if (arr[i].compareTo(arr[i - 1]) == 0)
				count++;

		System.out.println(count);
	}

	/**
	 * N^2/2 => Quadratic
	 */
	public static void distinctCountWithoutSort(Comparable[] arr) {
		int count = 0; // Assume a.length > 0.
		for (int i = 0; i < arr.length; i++) {
			count++;
			for (int k = i - 1; k >= 0; k--) {
				if (arr[i].compareTo(arr[k]) == 0) {
					count--;
					break;
				}
			}
		}

		System.out.println(count);
	}

	/**
	 * N^2/2 => Quadratic
	 */
	public static void distinctCountWithoutSort2(Comparable[] arr) {
		int count = 0; // Assume a.length > 0.
		for (int i = 0; i < arr.length; i++) {
			count++;
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i].compareTo(arr[k]) == 0) {
					count--;
					break;
				}
			}
		}

		System.out.println(count);
	}

	/**
	 * N^2/2 => Quadratic
	 */
	public static void duplicateCountWithoutSort(Comparable[] arr) {
		int count = 0; // Assume a.length > 0.
		for (int i = 0; i < arr.length; i++) {
			for (int k = i - 1; k >= 0; k--) {
				if (arr[i].compareTo(arr[k]) == 0) {
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}

	/**
	 * N^2/2 => Quadratic
	 */
	public static void duplicateCountWithoutSort2(Comparable[] arr) {
		int count = 0; // Assume a.length > 0.
		for (int i = 0; i < arr.length; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i].compareTo(arr[k]) == 0) {
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}
}
