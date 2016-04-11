package com.isa.section3.chapter5.exercises;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.isa.section3.chapter2.BST;
import com.isa.section3.chapter4.LinearProbingHashST;
import com.isa.section3.chapter5.ISET;
import com.sedgewick.stdlib.StdOut;

public class Exercise_3_5_1 {
	public static void main(String[] args) throws IOException {
		SET<String> set = new SET<String>();
		String fileName = "tinyTale.txt";
		Scanner scanner = new Scanner(new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath()));
		scanner.useDelimiter("\\s+");
		while (scanner.hasNext()) {
			String key = scanner.next();
			if (!set.contains(key)) {
				set.add(key);
				StdOut.println(key);
			}
		}
	}
}

class HashSET<Key> implements ISET<Key> {
	private LinearProbingHashST<Key, String> backingST;

	public HashSET(int cap) {
		backingST = new LinearProbingHashST<Key, String>(cap);
	}

	@Override
	public void add(Key key) {
		backingST.put(key, "");
	}

	@Override
	public void delete(Key key) {
		backingST.delete(key);
	}

	@Override
	public boolean contains(Key key) {
		return backingST.contains(key);
	}

	@Override
	public boolean isEmpty() {
		return backingST.isEmpty();
	}

	@Override
	public int size() {
		return backingST.size();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Key key : backingST.keys()) {
			buffer.append(key.toString()).append(", ");
		}

		return buffer.delete(buffer.length() - 2, buffer.length()).toString();
	}
}

class SET<Key extends Comparable<Key>> implements ISET<Key> {
	private BST<Key, String> backingTree = new BST<Key, String>();

	@Override
	public void add(Key key) {
		backingTree.put(key, "");
	}

	@Override
	public void delete(Key key) {
		backingTree.delete(key);
	}

	@Override
	public boolean contains(Key key) {
		return backingTree.contains(key);
	}

	@Override
	public boolean isEmpty() {
		return backingTree.isEmpty();
	}

	@Override
	public int size() {
		return backingTree.size();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Key key : backingTree.keys()) {
			buffer.append(key.toString()).append(", ");
		}

		return buffer.delete(buffer.length() - 2, buffer.length()).toString();
	}

}