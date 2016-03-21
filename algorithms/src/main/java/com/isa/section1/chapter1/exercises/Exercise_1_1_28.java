package com.isa.section1.chapter1.exercises;

import java.util.Arrays;

public class Exercise_1_1_28 {
	public static void main(String[] args) {
		BinarySearchNoDuplicates bs = new BinarySearchNoDuplicates(new int[] { 1, 3, 5, 6, 6, 2, 3 });
	}
}

class BinarySearchNoDuplicates {
	private int[] source;

	public BinarySearchNoDuplicates(int[] input) {
		this.source = Arrays.copyOf(input, input.length);
		for (int i : source) {
			System.out.print(i);
		}

		System.out.println("\nSorted array: ");
		Arrays.sort(this.source);
		for (int i : source) {
			System.out.print(i);
		}
		
		System.out.println("\nSorted unique array: ");
		removeDuplicatesBasic();
		for (int i : source) {
			System.out.print(i);
		}
	}

	/**
	 * 
	 * */
	private void removeDuplicatesBasic() {
		if (source.length <= 1) {
			return;
		}

		// Find the duplicate count and size of the array
		int last = source[0];
		int duplicateCount = 0;
		for (int i = 1; i < source.length; i++) {
			if (source[i] == last) {
				duplicateCount++;
			} else {
				last = source[i];
			}
		}

		// Construct new array
		int[] newSource = new int[source.length - duplicateCount];
		int newIndex = 0;
		newSource[newIndex++] = source[0];
		last = source[0];
		for (int i = 1; i < source.length; i++) {
			if (source[i] != last) {
				last = source[i];
				newSource[newIndex++] = source[i];
			}
		}
		
		// Assign
		source = newSource;
		
	}

	public boolean contains(int key) {
		if (rankRecursive(key, 0, source.length - 1, 0) == -1) {
			return false;
		}

		return true;
	}

	public int rankRecursive(int key, int min, int max, int degree) {
		int justify = 50 + degree;
		System.out.printf("%" + justify + "s%n", "Continuing up with min: " + (min) + " max: " + (max));

		if (min > max) {
			return -1;
		}

		int middle = (min + max) / 2;
		if (source[middle] == key) {
			return middle;
		} else {
			if (key > source[middle]) {

				return rankRecursive(key, middle + 1, max, degree + 1);
			} else {
				return rankRecursive(key, min, middle - 1, degree + 1);
			}
		}
	}
}