package com.isa.section1.chapter3.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FixedCapacityStack<Item> {
	private int cap;
	private Item[] backingArray;
	private int currentSize;

	public FixedCapacityStack(int cap) {
		this.cap = cap;
		backingArray = ((Item[])new Object[this.cap]);
	}

	public void push(Item item) {
		backingArray[currentSize++] = item;
	}

	public Item pop() {
		if (!isEmpty()) {
			return backingArray[--currentSize];
		}

		return null;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean isFull(){
		return  currentSize == backingArray.length; 
	}
	
	public int size() {
		return currentSize;
	}

	public static void main(String[] args) throws IOException {
		FixedCapacityStack<String> stack = new FixedCapacityStack<>(10);
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
