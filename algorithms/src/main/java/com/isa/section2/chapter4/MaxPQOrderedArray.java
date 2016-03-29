package com.isa.section2.chapter4;

import java.util.Arrays;

public class MaxPQOrderedArray<Key extends Comparable<Key>> {
	private int size = 0;
	private Key[] keys;

	public MaxPQOrderedArray() {
		keys = (Key[]) new Comparable[10];
	}

	public MaxPQOrderedArray(int max) {
		if (max < 1) {
			keys = (Key[]) new Comparable[1];
		} else {
			keys = (Key[]) new Comparable[max];
		}
	}

	public MaxPQOrderedArray(Key[] a) {
		keys = (Key[]) new Comparable[a.length];
		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}
	}

	public void insert(Key v) {
		if (isFull()) {
			resize();
		}

		keys[size++] = v;
		for (int i = size - 1; i > 0; i--) {
			if (less(i, i - 1)) {
				exch(i, i - 1);
			}
		}
	}

	public Key max() {
		if (isEmpty()) {
			return null;
		}

		return keys[size - 1];

	}

	public Key delMax() {
		if (isEmpty()) {
			return null;
		}

		Key max = keys[--size];
		keys[size] = null;
		return max;
	}

	private boolean less(int first, int second) {
		return keys[first].compareTo(keys[second]) < 0;
	}

	private void exch(int first, int second) {
		Key temp = keys[first];
		keys[first] = keys[second];
		keys[second] = temp;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == keys.length;
	}

	public int size() {
		return size;
	}

	// TODO must find not null values and new array size must be => size * 2
	private void resize() {
		keys = Arrays.copyOf(keys, keys.length * 2);
	}

	public static void main(String[] args) {
		MaxPQOrderedArray<String> maxPQ = new MaxPQOrderedArray<String>(new String[] { "i", "s", "a", "o", "l", "m", "e", "z" });
		while (maxPQ.size() > 0) {
			System.out.println(maxPQ.delMax());
		}
	}
}
