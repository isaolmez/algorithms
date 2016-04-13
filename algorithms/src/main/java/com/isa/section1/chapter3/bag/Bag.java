package com.isa.section1.chapter3.bag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	private Node head;
	private int size;

	private class Node {
		public Item item;
		public Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	public void add(Item item) {
		Node added = new Node(item);
		added.next = head;
		head = added;
		size++;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}

	private class BagIterator implements Iterator<Item> {
		private Node traverser = head;
		@Override
		public boolean hasNext() {
			return traverser != null;
		}

		@Override
		public Item next() {
			Item result = traverser.item;
			traverser = traverser.next;
			return result;
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
