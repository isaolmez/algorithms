package com.isa.section1.chapter3.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.isa.section1.chapter3.linkedlist.BasicLinkedList;

public class BasicQueueWithLinkedList<Item> implements Iterable<Item> {
	private BasicLinkedList<Item> backingList;

	public BasicQueueWithLinkedList() {
		backingList = new BasicLinkedList<Item>();
	}

	public void enqueue(Item item) {
		backingList.insertToEnd(item);
	}

	public Item dequeue() {
		if (isEmpty()) {
			return null;
		}

		return backingList.removeFromStart();
	}

	public int size() {
		return backingList.size();
	}

	public boolean isEmpty() {
		return backingList.size() == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
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
		BasicQueueWithLinkedList<String> queue = new BasicQueueWithLinkedList<>();
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
