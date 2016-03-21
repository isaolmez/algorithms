package com.isa.section1.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
	private int[] source;

	public BinarySearch(int[] input) {
		this.source = Arrays.copyOf(input, input.length);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < source.length; i++) {
			list.add(source[i]);
		}

		System.out.println(list);

		Arrays.sort(this.source);
	}

	public boolean contains(int key) {
		if (rankIterative(key) == -1) {
			return false;
		}

		return true;
	}

	public int rankRecursive(int key, int min, int max) {
		if (min > max) {
			return -1;
		}

		int middle = (min + max) / 2;
		if (source[middle] == key) {
			return middle;
		} else {
			if (key > source[middle]) {
				System.out.println("Continuing up with min: " + (middle + 1) + " max: " + (max));
				return rankRecursive(key, middle + 1, max);
			} else {
				System.out.println("Continuing down with min: " + (min) + " max: " + (middle - 1));
				return rankRecursive(key, min, middle - 1);
			}
		}
	}

	public int rankIterative(int key) {
		int min = 0;
		int max = source.length - 1;

		while (min <= max) {
			int middle = (min + max) / 2;
			if (source[middle] == key) {
				return middle;
			} else if (key > source[middle]) {
				min = middle + 1;
			} else if (key < source[middle]) {
				max = middle - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch(new int[] { 3, 5, 7, 9, 11 });
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
