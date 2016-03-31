package com.isa.section3.chapter1;

import java.util.Arrays;
import java.util.Iterator;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
	private int size = 0;
	private Key[] keys;
	private Value[] values;

	public BinarySearchST() {
		keys = (Key[]) new Comparable[20];
		values = (Value[]) new Object[20];
	}

	@Override
	public void put(Key key, Value value) {
		if (isFull()) {
			resize();
		}

		int rank = rank(key);
		if (keys[rank] != null && keys[rank].equals(key)) {
			values[rank] = value;
		} else {
			for (int i = size - 1; i >= rank; i--) {
				keys[i + 1] = keys[i];
				values[i + 1] = values[i];
			}

			keys[rank] = key;
			values[rank] = value;
			size++;
		}
	}

	@Override
	public Value get(Key key) {
		int rank = rank(key);
		if (keys[rank] != null && keys[rank].equals(key)) {
			return values[rank];
		}

		return null;
	}

	@Override
	public void delete(Key key) {
		if (isEmpty()) {
			return;
		}

		int rank = rank(key);
		if (keys[rank] != null) {
			for (int i = rank; i < size; i++) {
				keys[i] = keys[i + 1];
				values[i] = values[i + 1];
			}

			size--;
		}
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == keys.length;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterable<Key> keys() {
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				return new Iterator<Key>() {
					int traverser = 0;

					@Override
					public boolean hasNext() {
						return traverser < size;
					}

					@Override
					public Key next() {
						Key key = keys[traverser];
						traverser++;
						return key;
					}
				};
			}
		};
	}

	public int rank(Key key) {
		if(size == 0){
			return 0;
		}
		
		return rankIterative(key, 0, size - 1);
	}

	private int rankRecursive(Key key, int low, int high) {
		if (low > high) {
			return -1;
		}

		int middle = (low + high) / 2;
		if (key.compareTo(keys[middle]) == 0) {
			return middle;
		} else if (key.compareTo(keys[middle]) < 0) {
			return rankRecursive(key, low, middle - 1);
		} else {
			return rankRecursive(key, middle + 1, high);
		}
	}

	public int rankIterative(Key key, int low, int high) {
		while (low <= high) {
			int middle = (low + high) / 2;
			if (key.compareTo(keys[middle]) == 0) {
				return middle;
			} else if (key.compareTo(keys[middle]) < 0) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		return low;
	}

	private void exch(int first, int second) {
		Value temp = values[first];
		values[first] = values[second];
		values[second] = temp;

		Key tempKey = keys[first];
		keys[first] = keys[second];
		keys[second] = tempKey;
	}

	private boolean less(int first, int second) {
		if (keys[first].compareTo(keys[second]) < 0) {
			return true;
		}

		return false;
	}

	private void resize() {
		keys = Arrays.copyOf(keys, keys.length * 2);
		values = Arrays.copyOf(values, keys.length * 2);
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println(i + ":" + keys[i]);
		}
	}
}
