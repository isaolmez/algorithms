package com.isa.section1.chapter3.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node head;
	private Node tail;
	private int size;

	private class Node {
		public Item item;
		public Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	public void enqueue(Item item) {
		if (isEmpty()) {
			head = new Node(item);
			tail = head;
			size++;
			return;
		}

		Node added = new Node(item);
		tail.next = added;
		tail = added;
		size++;
	}

	public Item dequeue() {
		if (isEmpty()) {
			return null;
		} else if (head == tail) {
			Node result = head;
			tail = head = head.next;
			return result.item;
		} else {
			Node result = head;
			head = head.next;
			return result.item;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
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
		Queue<String> queue = new Queue<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter the string: ");
			String input = reader.readLine();
			String[] parts = input.split(" ");
			for (String part : parts) {
				if (part.equals("-")) {
					System.out.println(queue.dequeue());
				} else {
					queue.enqueue(part);
				}
			}

			for (String s : queue) {
				System.out.print(s);
			}

			System.out.println();
		}
	}
}
