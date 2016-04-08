package com.isa.section3.chapter4;

import java.util.Arrays;
import java.util.Iterator;

import com.isa.section3.chapter1.ST;
import com.isa.section3.chapter1.SequentialSearchST;

public class SeperateChainingHashST<Key, Value> extends ST<Key, Value> {
	private SequentialSearchST<Key, Value>[] hashArray;
	private int size;

	public SeperateChainingHashST(int cap) {
		hashArray = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[cap];
		// This our internal representation.
		// But if value is a list, this must be controlled in client-side
		for (int i = 0; i < hashArray.length; i++) {
			hashArray[i] = new SequentialSearchST<Key, Value>();  
		}
	}

	@Override
	public void put(Key key, Value value) {
		int index = modularHash(key);
		hashArray[index].put(key, value);
	}

	@Override
	public Value get(Key key) {
		int index = modularHash(key);
		return hashArray[index].get(key);
	}

	@Override
	public void delete(Key key) {
		int index = modularHash(key);
		hashArray[index].delete(key);
	}

	@Override
	public boolean contains(Key key) {
		int index = modularHash(key);
		return hashArray[index].contains(key);
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		int totalSize = 0;
		for (int i = 0; i < hashArray.length; i++) {
			totalSize += hashArray[i].size();
		}

		return totalSize;
	}

	@Override
	public Iterable<Key> keys() {
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				return new Iterator<Key>() {
					int index = 0;
					Iterator<Key> iter = hashArray[index].keys().iterator();

					@Override
					public boolean hasNext() {
						if (iter.hasNext()) {
							return true;
						} else {
							while (++index < hashArray.length) {
								iter = hashArray[index].keys().iterator();
								if (iter.hasNext()) {
									return true;
								}
							}

							return false;
						}
					}

					@Override
					public Key next() {
						Key key = iter.next();
						return key;
					}
				};
			}
		};
	}

	private void resize(double rate) {
		hashArray = Arrays.copyOf(hashArray, (int) (hashArray.length * rate));
	}

	private int modularHash(Key key) {
		return (key.hashCode() & 0x7fffffff) % hashArray.length;
	}
}
