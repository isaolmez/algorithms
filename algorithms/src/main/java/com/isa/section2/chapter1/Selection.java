package com.isa.section2.chapter1;

import com.sedgewick.stdlib.StdOut;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Selection {

	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int k = i + 1; k < a.length; k++) {
				if (less(a[k], a[minIndex])) {
					minIndex = k;
				}
			}

			exch(a, i, minIndex);
		}
	}

	/**
	 * 1. Find max
	 * 2. Swap with front 
	 * 
	 * Descending Order
	 */
	public static void sortMaxFront(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int maxIndex = i;
			for (int k = i + 1; k < a.length; k++) {
				if (less(a[maxIndex], a[k])) {
					maxIndex = k;
				}
			}

			exch(a, i, maxIndex);
		}
	}

	/**
	 *  1. Find max
	 *  2. Swap with end 
	 * 
	 *	Ascending Order
	 * 
	 */
	public static void sortMaxEnd(Comparable[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			int maxIndex = i;
			for (int k = i - 1; k >= 0; k--) {
				if (less(a[maxIndex], a[k])) {
					maxIndex = k;
				}
			}

			exch(a, i, maxIndex);
		}
	}

	/**
	 *  1. Find min
	 *  2. Swap with end
	 * 
	 *  Descending Order
	 */
	public static void sortMinEnd(Comparable[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			int minIndex = i;
			for (int k = i - 1; k >= 0; k--) {
				if (less(a[k], a[minIndex])) {
					minIndex = k;
				}
			}

			exch(a, i, minIndex);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) { // Print the array, on a single line.
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		// String[] a = In.readStrings();
		String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
		
		sortMaxEnd(a);
		assert isSorted(a);
		show(a);
		
		sortMaxFront(a);
		assert isSorted(a);
		show(a);
		
		sortMinEnd(a);
		assert isSorted(a);
		show(a);
		
	}
}
