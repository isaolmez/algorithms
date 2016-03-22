package com.isa.section1.chapter3.exercises;

import java.util.Stack;

public class Exercise_1_3_2 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		String input = "it was - the best - of times - - - it  was - the - -";
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
