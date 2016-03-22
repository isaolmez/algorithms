package com.isa.section1.chapter3.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class ResizingArrayStackWithIterator<Item> implements Iterable<Item> {
	private int cap;
	private Item[] backingArray;
	private int currentSize;

	public ResizingArrayStackWithIterator(int cap) {
		this.cap = cap;
		backingArray = ((Item[]) new Object[this.cap]);
	}

	public void push(Item item) {
		if (isFull()) {
			cap = cap * 2;
			backingArray = Arrays.copyOf(backingArray, cap);
		}

		backingArray[currentSize++] = item;
	}

	public Item pop() {
		if (isEmpty()) {
			return null;
		}
		
		Item result = backingArray[--currentSize];
		backingArray[currentSize] = null; // help garbage collection - avoid loitering
		if (currentSize < cap / 4) {
			cap = cap / 2;
			backingArray = Arrays.copyOf(backingArray, cap);
		}

		return result;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean isFull() {
		return currentSize == backingArray.length;
	}

	public int size() {
		return currentSize;
	}

	public Item peek() {
		return backingArray[currentSize - 1];
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = currentSize;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return backingArray[--i];
		}
	}

	@Override
	public java.util.Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	public static void main(String[] args) throws IOException {
		ResizingArrayStackWithIterator<String> stack = new ResizingArrayStackWithIterator<>(1);
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
