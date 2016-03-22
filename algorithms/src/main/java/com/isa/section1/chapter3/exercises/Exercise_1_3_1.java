package com.isa.section1.chapter3.exercises;

public class Exercise_1_3_1 {
}

class FixedCapacityStackOfStrings {
	private int cap;
	private String[] backingArray;
	private int currentSize;

	public FixedCapacityStackOfStrings(int cap) {
		this.cap = cap;
		backingArray = new String[this.cap];
	}

	public void push(String item) {
		backingArray[currentSize++] = item;
	}

	public String pop() {
		if (!isEmpty()) {
			return backingArray[--currentSize];
		}

		return null;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	// Checks whether the backing array is full
	public boolean isFull() {
		return currentSize == backingArray.length;
	}

	public int size() {
		return currentSize;
	}
}
