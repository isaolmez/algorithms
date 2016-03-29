package com.isa.section2.chapter4;

import java.util.Arrays;

public class MaxPQUnOrderedArray<Key extends Comparable<Key>> {
	private int size = 0;
	private int insertPointer = 0;
	private Key[] keys;

	public MaxPQUnOrderedArray() {
		keys = (Key[]) new Comparable[10];
	}

	public MaxPQUnOrderedArray(int max) {
		if (max < 1) {
			keys = (Key[]) new Comparable[10];
		} else {
			keys = (Key[]) new Comparable[max];
		}
	}

	public MaxPQUnOrderedArray(Key[] a) {
		keys = Arrays.copyOf(a, a.length);
		size = a.length;
		insertPointer = a.length;
	}

	public void insert(Key v) {
		if (isFull()) {
			resize();
		}

		keys[insertPointer++] = v;
		size++;
	}

	public Key max() {
		if (isEmpty()) {
			return null;
		}

		return keys[findMaxIndex()];

	}

	public Key delMax() {
		if (isEmpty()) {
			return null;
		}

		int maxIndex = findMaxIndex();
		Key max = keys[maxIndex];
		keys[maxIndex] = null;
		size--;
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
		return insertPointer == keys.length;
	}

	public int size() {
		return size;
	}

	// TODO must find not null values and new array size must be => size * 2
	private void resize() {
		keys = Arrays.copyOf(keys, keys.length * 2);
	}

	private int findMaxIndex() {
		int maxIndex = -1;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				if (maxIndex == -1 || less(maxIndex, i)) {
					maxIndex = i;
				}
			}
		}

		return maxIndex;
	}

	public static void main(String[] args) {
		MaxPQUnOrderedArray<String> maxPQ = new MaxPQUnOrderedArray<String>(new String[] { "i", "s", "a", "o", "l", "m", "e", "z" });
		while (maxPQ.size() > 0) {
			System.out.println(maxPQ.delMax());
		}
	}
}
