package com.isa.section2.chapter3;

import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.StdRandom;
import com.sedgewick.stdlib.Stopwatch;

public class Quick {

	public static void sort(Comparable[] arr) {
//		show(arr);
		innerSort(arr, 0, arr.length - 1);
	}

	private static void innerSort(Comparable[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int partition = partition(arr, low, high);
		innerSort(arr, low, partition - 1);
		innerSort(arr, partition + 1, high);
	}

	public static int partition(Comparable[] arr, int low, int high) {
		Comparable partitionKey = arr[low];
		int headPointer = low;
		int tailPointer = high + 1;

		while (true) {
			while (less(arr[++headPointer], partitionKey)) {
				if (headPointer == high)
					break;
			}

			while (less(partitionKey, arr[--tailPointer])) {
				if (tailPointer == low) {
					break;
				}
			}

			if (headPointer >= tailPointer) {
				break;
			}

			exch(arr, headPointer, tailPointer);
		}

		// Final exchange
		exch(arr, low, tailPointer);
		return tailPointer;
	}

	public static int partitionCustom(Comparable[] arr, int low, int high) {
		Comparable partitionKey = arr[low];
		int headPointer = low + 1;
		int tailPointer = high;
		boolean leftStopped = false;
		boolean rightStopped = false;
		while (headPointer <= tailPointer) {
			if (!leftStopped) {
				if (!less(arr[headPointer], partitionKey)) {
					leftStopped = true;
				} else {
					headPointer++;
				}
			}

			if (!rightStopped) {
				if (less(arr[tailPointer], partitionKey)) {
					rightStopped = true;
				} else {
					tailPointer--;
				}
			}

			if (leftStopped && rightStopped) {
				exch(arr, headPointer, tailPointer);
				leftStopped = rightStopped = false;
				headPointer++;
				tailPointer--;
			}
		}

		// Final exchange
		exch(arr, low, tailPointer);
		return tailPointer;
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
//		String[] a = { "A", "E", "I", "C", "K", "S", "O", "R", "T", "E", "X", "U", "M", "P", "L", "Q" };
		Double[] a = new Double[100000];
		for (int i = 0; i < 100000; i++) {
			a[i] = (double) StdRandom.uniform(10000);
		}

		Stopwatch st = new Stopwatch();
		sort(a);
		assert isSorted(a);
//		show(a);
		System.out.println(st.elapsedTime());
		
		Integer[] arr2 = {4,2,3,4};
		sort(arr2);
		for(int i : arr2){
			System.out.print(i + " ");
		}
		assert isSorted(arr2);
	}
}
