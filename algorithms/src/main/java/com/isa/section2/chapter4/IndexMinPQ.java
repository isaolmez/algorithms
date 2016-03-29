package com.isa.section2.chapter4;

import java.util.Arrays;

import com.sedgewick.stdlib.In;
import com.sedgewick.stdlib.StdOut;

public class IndexMinPQ<Key extends Comparable<Key>> {
	// Both the counter and insert pointer
	private int size = 0;
	private Key[] keys;
	private int[] indexes;

	public IndexMinPQ(int max) {
		keys = (Key[]) new Comparable[max + 1];
		indexes = new int[max + 1];
	}

	public void change(int k, Key key) {
		// if (key.compareTo(temp) < 0) {
		// sink(k);
		// } else {
		// swim(k);
		// }
	}

	public boolean contains(int k) {
		return keys[k] != null;
	}

	public void delete(int k) {
		// TODO
	}

	public void insert(int k, Key v) {
		if (isFull()) {
			resize();
		}

		keys[++size] = v;
		indexes[size] = k;
		swim(size);
	}

	public Key min() {
		if (isEmpty()) {
			return null;
		}

		return keys[1];
	}

	public int delMin() {
		if (isEmpty()) {
			return 0;
		}

		Key max = keys[1];
		int t = indexes[1];
		exch(1, size);
		keys[size] = null;
		indexes[size] = 0;
		size--;
		sink(1);
		return t;
	}

	private boolean less(int first, int second) {
		return keys[second].compareTo(keys[first]) < 0;
	}

	private void exch(int first, int second) {
		Key temp = keys[first];
		keys[first] = keys[second];
		keys[second] = temp;
		int t = indexes[first];
		indexes[first] = indexes[second];
		indexes[second] = t;
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

	public static void merge(In[] streams) {
		int N = streams.length;
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
		for (int i = 0; i < N; i++)
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		while (!pq.isEmpty()) {
			StdOut.println(pq.min());
			int i = pq.delMin();
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		}
	}

	public static void main(String[] args) {
		int N = args.length;
		In[] streams = new In[N];
		for (int i = 0; i < N; i++)
			streams[i] = new In(Thread.currentThread().getContextClassLoader().getResource(args[i]).toString());
		merge(streams);
	}
}
