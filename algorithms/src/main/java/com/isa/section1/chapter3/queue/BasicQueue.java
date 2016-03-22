package com.isa.section1.chapter3.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

import com.isa.section1.chapter3.stack.ResizingArrayStackWithIterator;

public class BasicQueue<Item> implements Iterable<Item> {
	private int insertIndex;
	private int removeIndex;
	private Item[] values;

	public BasicQueue() {
		this(2);
	}

	public BasicQueue(int cap) {
		this.values = (Item[]) new Object[cap];
	}

	public void enqueue(Item item) {
		// Resizing check
		if (insertIndex == values.length) {
			// values = Arrays.copyOfRange(values, headIndex, tailIndex + 1);
			values = Arrays.copyOf(values, values.length * 2);
		}

		try {
			values[insertIndex++] = item;
		} catch (Exception e) {
			System.out.println(insertIndex + " " + values.length);
		}

	}

	public Item dequeue() {
		if (insertIndex == removeIndex) {
			return null;
		}

		Item result = values[removeIndex];
		values[removeIndex] = null;
		removeIndex++;
		int oldSize = values.length;
		if ((insertIndex - removeIndex + 1) < oldSize / 4) {
			values = Arrays.copyOfRange(values, removeIndex, insertIndex);
			values = Arrays.copyOf(values, oldSize / 2);
			insertIndex = insertIndex - removeIndex;
			removeIndex = 0;
		}

		return result;
	}

	public int size() {
		return insertIndex - removeIndex;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {

		private int iteratorIndex = removeIndex;

		@Override
		public boolean hasNext() {
			return insertIndex - iteratorIndex > 0;
		}

		@Override
		public Item next() {
			return values[iteratorIndex++];
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
