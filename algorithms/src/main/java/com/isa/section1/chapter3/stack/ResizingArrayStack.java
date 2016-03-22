package com.isa.section1.chapter3.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ResizingArrayStack<Item> {
	private int cap;
	private Item[] backingArray;
	private int currentSize;

	public ResizingArrayStack(int cap) {
		this.cap = cap;
		backingArray = ((Item[]) new Object[this.cap]);
	}

	public void push(Item item) {
		if (cap == currentSize) {
			cap = cap * 2;
			backingArray = Arrays.copyOf(backingArray, cap);
			System.out.println("New stack size:" + cap);
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
			System.out.println("New stack size:" + cap);
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

	public static void main(String[] args) throws IOException {
		ResizingArrayStack<String> stack = new ResizingArrayStack<>(1);
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
		}
	}
}
