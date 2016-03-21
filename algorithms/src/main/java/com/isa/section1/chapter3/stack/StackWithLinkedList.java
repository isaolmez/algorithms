package com.isa.section1.chapter3.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.isa.section1.chapter3.linkedlist.BasicLinkedList;
import com.isa.section1.chapter3.linkedlist.Node;

public class StackWithLinkedList<Item> implements Iterable<Item> {
	private BasicLinkedList<Item> linkedList;

	public StackWithLinkedList() {
		linkedList = new BasicLinkedList<Item>();
	}

	public void push(Item item) {
		linkedList.insertToStart(new Node<Item>(item));
	}

	public Item pop() {
		Node<Item> result = linkedList.removeFromStart();
		return result.getItem();
	}

	public boolean isEmpty() {
		return linkedList.size() == 0;
	}

	public int size() {
		return linkedList.size();
	}

	private class LinkedListStackIterator implements Iterator<Item> {
		Iterator<Item> iter = linkedList.iterator();

		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}

		@Override
		public Item next() {
			return iter.next();
		}
	}

	@Override
	public java.util.Iterator<Item> iterator() {
		return new LinkedListStackIterator();
	}

	public static void main(String[] args) throws IOException {
		BasicStackWithIterator<String> stack = new BasicStackWithIterator<>(1);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter the string: ");
			String input = reader.readLine();
			String[] parts = input.split(" ");
			for (String part : parts) {
				if (part.equals("-")) {
					System.out.println(stack.pop());
				} else {
					stack.push(part);
				}
			}

			for (String s : stack) {
				System.out.print(s);
			}
		}
	}
}