package com.isa.section3.chapter1;

import java.util.Arrays;
import java.util.Iterator;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends OrderedST<Key, Value> {
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
		if (rank < size && keys[rank].compareTo(key) == 0) {
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
		if (rank < size && keys[rank].compareTo(key) == 0) {
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
		if (rank < size) {
			for (int i = rank; i < size - 1; i++) {
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
		if (size == 0) {
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

	private void resize() {
		keys = Arrays.copyOf(keys, keys.length * 2);
		values = Arrays.copyOf(values, keys.length * 2);
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println(i + ":" + keys[i]);
		}
	}

	@Override
	public Key min() {
		if (isEmpty()) {
			return null;
		}

		return keys[0];
	}

	@Override
	public Key max() {
		if (isEmpty()) {
			return null;
		}

		return keys[size - 1];
	}

	@Override
	public Key floor(Key key) {
		if (isEmpty()) {
			return null;
		}

		int rank = rank(key);
		if (rank - 1 > 0 && rank - 1 < keys.length) {
			return keys[rank - 1];
		}

		return null;
	}

	@Override
	public Key ceiling(Key key) {
		if (isEmpty()) {
			return null;
		}

		int rank = rank(key);
		if (rank < keys.length) {
			return keys[rank];
		}

		return null;
	}

	@Override
	public Key select(int k) {
		if (k < size) {
			return keys[k];
		}

		return null;
	}

	@Override
	public void deleteMin() {
		if (isEmpty()) {
			return;
		}

		delete(select(0));
	}

	@Override
	public void deleteMax() {
		if (isEmpty()) {
			return;
		}

		delete(select(size - 1));
	}

	@Override
	public int size(Key lo, Key hi) {
		int low = rank(lo);
		int high = rank(hi);
		if (low < size && high < size) {
			return high - low;
		}

		return 0;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		return null;
	}
}
