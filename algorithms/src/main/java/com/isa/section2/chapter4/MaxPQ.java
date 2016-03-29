package com.isa.section2.chapter4;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {
	// Both the counter and insert pointer
	private int size = 0;
	private Key[] keys;

	public MaxPQ() {
		keys = (Key[]) new Comparable[10];
	}

	public MaxPQ(int max) {
		keys = (Key[]) new Comparable[max];
	}

	public MaxPQ(Key[] a) {
		keys = (Key[]) new Comparable[a.length + 1];
		constructSwim(a);
	}

	public void insert(Key v) {
		if (isFull()) {
			resize();
		}

		keys[++size] = v;
		swim(size);
	}

	public Key max() {
		if (isEmpty()) {
			return null;
		}

		return keys[1];
	}

	public Key delMax() {
		if (isEmpty()) {
			return null;
		}

		Key max = keys[1];
		exch(1, size);
		keys[size] = null;
		size--;
		sink(1);
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
		return size + 1 == keys.length;
	}

	public int size() {
		return size;
	}

	// TODO must find not null values and new array size must be => size * 2
	private void resize() {
		keys = Arrays.copyOf(keys, keys.length * 2);
	}

	private void constructSwim(Key[] arr) {
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
	}

	private void constructSink(Key[] arr) {
		// TODO
	}

	private void sink(int index) {
		sinkIterative(index);
	}

	private void sinkRecursive(int index) {
		int largerChild = findLargerChild(index);
		if (largerChild != -1 && less(index, largerChild)) {
			exch(index, largerChild);
			sink(largerChild);
		}
	}

	private void sinkIterative(int index) {
		int largerChild = -1;
		while ((largerChild = findLargerChild(index)) != -1 && less(index, largerChild)) {
			exch(index, largerChild);
			index = largerChild;
		}
	}

	private void swim(int index) {
		swimIterative(index);
	}

	private void swimRecursive(int index) {
		if (index > 1 && less(index / 2, index)) {
			exch(index / 2, index);
			swim(index / 2);
		}
	}

	private void swimIterative(int index) {
		while (index > 1 && less(index / 2, index)) {
			exch(index / 2, index);
			index = index / 2;
		}
	}

	private int findLargerChild(int index) {
		int first = -1;
		int second = -1;
		if (index * 2 <= size) {
			first = index * 2;
		}

		if (index * 2 + 1 <= size) {
			second = index * 2 + 1;
		}

		if (second > first && less(first, second)) {
			return second;
		} else {
			return first;
		}
	}

	public static void main(String[] args) {
//		 MaxPQ<String> maxPQ = new MaxPQ<String>(new String[] { "i", "n", "g", "h", "e", "a", "p", "s", "o", "r", "t" });
//		MaxPQ<String> maxPQ = new MaxPQ<String>(new String[] { "i", "s", "a", "o", "l", "m", "e", "z" });
		MaxPQ<String> maxPQ = new MaxPQ<String>(2);
		String[] source = new String[] { "i", "n", "g", "h", "e", "a", "p", "s", "o", "r", "t" };
		for(String s: source){
			maxPQ.insert(s);
		}
		
		while (maxPQ.size() > 0) {
			System.out.println(maxPQ.delMax());
		}
	}
}
