package com.isa.section1.chapter1;

import java.util.Arrays;

public class BinarySearchGeneric<Item extends Comparable<Item>> {
	private Item[] source;

	public BinarySearchGeneric(Item[] input) {
		this(input, false);
	}

	public BinarySearchGeneric(Item[] input, boolean clone) {
		if (clone) {
			this.source = Arrays.copyOf(input, input.length);
		} else {
			this.source = input;
		}

		Arrays.sort(this.source);
	}

	public boolean contains(Item key) {
		if (rank(key) == -1) {
			return false;
		}

		return true;
	}

	public int rank(Item key) {
		return rankIterative(key);
	}

	public int rankRecursive(Item key, int min, int max) {
		if (min > max) {
			return -1;
		}

		int middle = (min + max) / 2;
		if (source[middle].compareTo(key) == 0) {
			return middle;
		} else {
			if (key.compareTo(source[middle]) > 0) {
				return rankRecursive(key, middle + 1, max);
			} else {
				return rankRecursive(key, min, middle - 1);
			}
		}
	}

	public int rankIterative(Item key) {
		int min = 0;
		int max = source.length - 1;

		while (min <= max) {
			int middle = (min + max) / 2;
			if (source[middle].compareTo(key) == 0) {
				return middle;
			}
			if (key.compareTo(source[middle]) > 0) {
				min = middle + 1;
			} else if (key.compareTo(source[middle]) < 0) {
				max = middle - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		BinarySearchGeneric binarySearch = new BinarySearchGeneric(new Integer[] { 3, 5, 7, 9, 11 });
		System.out.println(binarySearch.rankIterative(2));
		System.out.println(binarySearch.rankIterative(3));
		System.out.println(binarySearch.rankIterative(7));
		System.out.println(binarySearch.rankIterative(11));
		System.out.println(binarySearch.rankRecursive(2, 0, 4));
		System.out.println(binarySearch.rankRecursive(3, 0, 4));
		System.out.println(binarySearch.rankRecursive(7, 0, 4));
		System.out.println(binarySearch.rankRecursive(11, 0, 4));
	}
}
