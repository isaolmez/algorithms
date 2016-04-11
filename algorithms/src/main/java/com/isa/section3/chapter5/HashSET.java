package com.isa.section3.chapter5;

/**
 * Hashing with linear probing
 * 
 */
public class HashSET<Key> implements ISET<Key> {

	private Key[] keys;
	private int size;

	public HashSET(int cap) {
		keys = (Key[]) new Object[cap];
	}

	@Override
	public void add(Key key) {
		if (key == null) {
			return;
		}
		
		if(isHalfFull()){
			resize(2);
		}
		
		int index = modularHash(key);
		while (index < keys.length || (index = index % keys.length) < keys.length) {
			if (keys[index] == null) {
				keys[index] = key;
				size++;
				break;
			} else if (keys[index].equals(key)) {
				break;
			}

			index++;
		}
	}

	@Override
	public void delete(Key key) {
		
	}

	@Override
	public boolean contains(Key key) {
		if (key == null) {
			return false;
		}

		int index = modularHash(key);
		while (index < keys.length || (index = index % keys.length) < keys.length) {
			if (keys[index] == null) {
				return false;
			} else if (keys[index].equals(key)) {
				return true;
			}

			index++;
		}

		return false;
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
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(Key key:keys){
			buffer.append(key.toString()).append(", ");
		}
		
		buffer.delete(buffer.length()-2, buffer.length());
		return buffer.toString();
	}

	private boolean isHalfFull() {
		return size >= keys.length / 2;
	}

	private int modularHash(Key key) {
		return (key.hashCode() & 0x7fffffff) % keys.length;
	}

	private void resize(int rate){
		System.out.println("Resizing");
		Key[] tempKeys = keys;
		keys = (Key[]) new Object[(int)(rate*keys.length)];
		for(int i = 0; i<tempKeys.length; i++){
			Key loopKey = tempKeys[i]; 
			if(loopKey != null){
				add(loopKey);
			}
		}
	}
}
