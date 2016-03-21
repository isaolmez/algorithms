package com.isa.section1.chapter3.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.isa.section1.chapter3.linkedlist.BasicLinkedList;
import com.isa.section1.chapter3.linkedlist.Node;

public class BasicQueueWithLinkedList<Item> implements Iterable<Item> {
	private BasicLinkedList<Item> linkedList;

	public BasicQueueWithLinkedList() {

	}

	public void enqueue(Item item) {
		linkedList.insertToEnd(new Node<Item>(item));
	}

	public Item dequeue() {
		Node<Item> node = linkedList.removeFromStart();
		if (node != null) {
			return node.getItem();
		}

		return null;
	}

	public int size() {
		return linkedList.size();
	}

	public boolean isEmpty() {
		return linkedList.size() == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return null;
	}

	private class LinkedListQueueIterator implements Iterator<Item> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		BasicQueue<String> stack = new BasicQueue<>(1);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter the string: ");
			String input = reader.readLine();
			String[] parts = input.split(" ");
			for (String part : parts) {
				if (part.equals("-")) {
					System.out.println(stack.dequeue());
				} else {
					stack.enqueue(part);
				}
			}

			for (String s : stack) {
				System.out.print(s);
			}
		}
	}
}
