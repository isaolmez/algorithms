package com.isa.section1.chapter3.exercises;

import com.isa.section1.chapter3.stack.Stack;

public class Exercise_1_3_12 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		stack.push("s");
		stack.push("d");
		stack.push("f");
		Stack<String> copiedStack = copy(stack);
		for (String s : copiedStack) {
			System.out.print(s + " ");
		}
	}

	public static Stack<String> copy(Stack<String> stack) {
		Stack<String> copiedStack = new Stack<>();
		for (String s : stack) {
			copiedStack.push(s);
		}

		return copiedStack;
	}

}
