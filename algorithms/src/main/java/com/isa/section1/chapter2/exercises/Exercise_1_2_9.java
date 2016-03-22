package com.isa.section1.chapter2.exercises;

import java.util.Arrays;

import com.isa.section1.chapter2.Counter;

public class Exercise_1_2_9 {
	public static void main(String[] args) {
		Counter c = new Counter("Comparisons");
		BinarySearch<String> bs = new BinarySearch<>(new String[] { "z", "f", "d", "e", "a" }, c);
		System.out.println(bs.contains("d"));
		System.out.println(c);

	}
}

class BinarySearch<Item extends Comparable<Item>> {
	private Item[] source;
	private Counter counter;

	public BinarySearch(Item[] arr, Counter counter) {
		this.source = arr;
		this.counter = counter;
		Arrays.sort(this.source);
	}

	public Item[] source() {
		return source;
	}

	public boolean contains(Item item) {
		if (rank(item, 0, source.length) != -1) {
			return true;
		}

		return false;
	}

	public int rank(Item item, int min, int max) {
		if (min > max) {
			return -1;
		}

		counter.increment();
		int middleIndex = (min + max) / 2;
		if (source[middleIndex].equals(item)) {
			return middleIndex;
		}

		if (item.compareTo(source[middleIndex]) > 0) {
			return rank(item, middleIndex + 1, max);
		} else {
			return rank(item, min, middleIndex - 1);
		}
	}
}
