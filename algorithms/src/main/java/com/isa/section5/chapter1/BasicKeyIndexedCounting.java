package com.isa.section5.chapter1;

import java.util.Arrays;
import java.util.Random;

import com.sedgewick.stdlib.Stopwatch;

public class BasicKeyIndexedCounting {

	public static void sort(int[] items, int limit) {
		int[] count = new int[limit + 1];
		for (int i = 0; i < items.length; i++) {
			count[items[i] + 1]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		int[] aux = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			aux[count[items[i]]++] = items[i];
		}

		for (int i = 0; i < aux.length; i++) {
			items[i] = aux[i];
		}
	}

	public static void main(String[] args) {
		int limit = 100;
		int[] items = generateItems(limit);
		System.out.println("Size: " + items.length);
		Stopwatch watch = new Stopwatch();
		BasicKeyIndexedCounting.sort(items, limit);
		System.out.println("Elapsed: " + watch.elapsedTime());
		System.out.println("Is sorted:" + isSorted(items));

		items = generateItems(limit);
		watch = new Stopwatch();
		Arrays.sort(items);
		System.out.println("Elapsed: " + watch.elapsedTime());
		System.out.println("Is sorted:" + isSorted(items));
	}

	public static boolean isSorted(int[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i - 1])
				return false;

		return true;
	}

	private static int[] generateItems(int limit) {
		int[] items = new int[1000000];
		Random random = new Random();
		for (int i = 0; i < items.length; i++) {
			items[i] = random.nextInt(limit);
		}

		return items;
	}
}
