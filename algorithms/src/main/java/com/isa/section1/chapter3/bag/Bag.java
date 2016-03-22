package com.isa.section1.chapter3.bag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.isa.section1.chapter3.linkedlist.BasicLinkedList;

public class Bag<Item> implements Iterable<Item> {
	private BasicLinkedList<Item> backingList = new BasicLinkedList<>();

	public void add(Item item) {
		backingList.insertToEnd(item);
	}

	public boolean isEmpty() {
		return backingList.size() == 0;
	}

	public int size() {
		return backingList.size();
	}

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}

	private class BagIterator implements Iterator<Item> {
		private Iterator<Item> iterator = backingList.iterator();

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public Item next() {
			return iterator.next();
		}
	}

	public static void main(String[] args) throws IOException {
		Bag<String> bag = new Bag<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter the string: ");
			String input = reader.readLine();
			String[] parts = input.split(" ");
			for (String part : parts) {
				bag.add(part);
			}

			for (String s : bag) {
				System.out.print(s);
			}
			
			System.out.println();
		}
	}
}
