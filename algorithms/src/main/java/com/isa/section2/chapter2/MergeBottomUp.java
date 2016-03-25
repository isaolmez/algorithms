package com.isa.section2.chapter2;

import com.sedgewick.stdlib.StdOut;

public class MergeBottomUp {
	private static Comparable[] aux;

	public static void sort(Comparable[] arr) {
		aux = new Comparable[arr.length];
		innerSort(arr, 0, arr.length - 1);
	}

	private static void innerSort(Comparable[] arr, int low, int high) {
		for (int sz = 1; sz < arr.length; sz *= 2) {
			for (int k = 0; k < arr.length; k += 2 * sz) {
				merge(arr, k, k + sz - 1, Math.min(k + 2 * sz - 1, arr.length - 1));
			}
		}

		// for (int i = 2; i < arr.length * 2; i *= 2) {
		// for (int k = 0; k < arr.length; k += i) {
		// int highLimit = k + i - 1 > arr.length - 1 ? arr.length - 1 : k + i - 1;
		// merge(arr, k, k + (i / 2) - 1, highLimit);
		// }
		// }
	}

	public static void merge(Comparable[] arr, int low, int mid, int high) {
		int firstPointer = low;
		int secondPointer = mid + 1;
		for (int auxPointer = low; auxPointer <= high; auxPointer++) {
			if (firstPointer > mid) {
				aux[auxPointer] = arr[secondPointer++];
			} else if (secondPointer > high) {
				aux[auxPointer] = arr[firstPointer++];
			} else if (less(arr[firstPointer], arr[secondPointer])) {
				aux[auxPointer] = arr[firstPointer++];
			} else {
				aux[auxPointer] = arr[secondPointer++];
			}
		}

		for (int i = low; i <= high; i++) {
			arr[i] = aux[i];
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
	}
}
