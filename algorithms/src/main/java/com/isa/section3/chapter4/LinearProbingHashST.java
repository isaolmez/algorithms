package com.isa.section3.chapter4;

import java.util.Iterator;

import com.isa.section3.chapter1.ST;

public class LinearProbingHashST<Key, Value> extends ST<Key, Value> {
	Key[] keys;
	private Value[] values;
	private int size;

	public LinearProbingHashST(int cap) {
		keys = (Key[]) new Object[cap];
		values = (Value[]) new Object[cap];
	}

	@Override
	public void put(Key key, Value value) {
		if (isHalfFull()) {
			resize(2);
		}

		int index = modularHash(key);
		while (index < keys.length || (index = index % keys.length) < keys.length) {
			if (keys[index] == null) {
				keys[index] = key;
				values[index] = value;
				size++;
				break;
			} else if (keys[index].equals(key)) {
				values[index] = value;
				break;
			}

			index++;
			index = index % keys.length;
		}

		// if (keys[index] != null) {
		// if (keys[index].equals(key)) {
		// values[index] = value;
		// } else {
		// while (++index < keys.length || (index = index % keys.length) < keys.length) {
		// if (keys[index] == null) {
		// keys[index] = key;
		// values[index] = value;
		// size++;
		// break;
		// } else if (keys[index].equals(key)) {
		// values[index] = value;
		// break;
		// }
		// }
		// }
		// } else {
		// keys[index] = key;
		// values[index] = value;
		// size++;
		// }
	}

	@Override
	public Value get(Key key) {
		int index = modularHash(key);

		while (index < keys.length || (index = index % keys.length) < keys.length) {
			if (keys[index] == null) {
				return null;
			} else if (key.equals(keys[index])) {
				return values[index];
			}
			
			index++;
		}
		
		return null;
		// if (keys[index] == null) {
		// return null;
		// } else {
		// if (key.equals(keys[index])) {
		// return values[index];
		// } else {
		// while (++index < keys.length || (index = index % keys.length) < keys.length) {
		// if (keys[index] == null) {
		// return null;
		// } else if (key.equals(keys[index])) {
		// return values[index];
		// }
		// }
		//
		// return null;
		// }
		// }
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
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
					int i = -1;

					@Override
					public boolean hasNext() {
						while (++i < keys.length) {
							if (keys[i] != null) {
								return true;
							}
						}

						return false;
					}

					@Override
					public Key next() {
						return keys[i];
					}
				};
			}
		};
	}

	private int modularHash(Key key) {
		return (key.hashCode() & 0x7fffffff) % keys.length;
	}

	private void resize(double rate) {
		Key[] keysTemp = keys;
		Value[] valuesTemp = values;
		keys = (Key[]) new Object[(int) (rate * keysTemp.length)];
		values = (Value[]) new Object[(int) (rate * keysTemp.length)];
		size = 0;
		for (int i = 0; i < keysTemp.length; i++) {
			Key loopKey = keysTemp[i];
			if (loopKey != null) {
				put(loopKey, valuesTemp[i]);
			}
		}
	}

	private boolean isHalfFull() {
		return size >= keys.length / 2;
	}
}
