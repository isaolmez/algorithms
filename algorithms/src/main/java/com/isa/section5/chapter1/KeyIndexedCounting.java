package com.isa.section5.chapter1;

import java.util.Random;

import com.isa.section2.chapter3.Quick;
import com.sedgewick.stdlib.Stopwatch;

public class KeyIndexedCounting {

	public static void sort(Item[] items) {
		int[] count = new int[101];
		for (int i = 0; i < items.length; i++) {
			count[items[i].key + 1]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		Item<String>[] aux = (Item<String>[]) new Item[items.length];
		for (int i = 0; i < items.length; i++) {
			aux[count[items[i].key]++] = items[i];
		}

		for (int i = 0; i < aux.length; i++) {
			items[i] = aux[i];
		}
	}

	private static class Item<Value> implements Comparable<Item<Value>> {
		int key;
		Value value;

		public Item(int key, Value value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return key + ":" + value.toString();
		}

		@Override
		public int compareTo(Item<Value> o) {
			if (key < o.key) {
				return -1;
			} else if (key > o.key) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		Item<String>[] items = generateItems(100);
		System.out.println("Size: " + items.length);
		Stopwatch watch = new Stopwatch();
		KeyIndexedCounting.sort(items);
		System.out.println("Elapsed: " + watch.elapsedTime());

		items = generateItems(100);
		watch = new Stopwatch();
		Quick.sort(items); // TODO Sort can be tuned to use primitive, not wrapper types
		System.out.println("Elapsed: " + watch.elapsedTime());

		System.out.println(isSorted(items));
	}

	public static boolean isSorted(Item[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (a[i].key < a[i - 1].key)
				return false;

		return true;
	}

	private static Item<String>[] generateItems(int limit) {
		Item<String>[] items = (Item<String>[]) new Item[100000];
		Random random = new Random();
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item<String>(random.nextInt(limit), "");
		}

		return items;
	}
}
