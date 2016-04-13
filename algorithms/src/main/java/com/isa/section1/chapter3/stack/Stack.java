package com.isa.section1.chapter3.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node head;
	private int size;

	private class Node {
		public Item item;
		public Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	public void push(Item item) {
		Node added = new Node(item);
		added.next = head;
		head = added;
		size++;
	}

	public Item pop() {
		if(isEmpty()){
			return null;
		}
		
		Node result = head;
		head = head.next;
		return result.item;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public Item peek() {
		return head != null ? head.item : null;
	}

	private class StackIterator implements Iterator<Item> {
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

	@Override
	public java.util.Iterator<Item> iterator() {
		return new StackIterator();
	}

	public static void main(String[] args) throws IOException {
		Stack<String> stack = new Stack<>();
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
			System.out.println();
		}
	}
}