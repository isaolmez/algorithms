package com.isa.section1.chapter3.questions;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Q1_3_6 {
	public static void main(String[] args) {
		System.out.println(reverse("isa olmez"));

	}

	public static String reverse(String input) {
		Stack<String> stack = new Stack<String>();
		Queue<String> queue = new ArrayBlockingQueue<>(10);
		for (int i = 0; i < input.length(); i++) {
			queue.add(input.substring(i, i + 1));
		}

		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		StringBuffer result = new StringBuffer();
		for (String s : queue) {
			result.append(s);
		}
		
		return result.toString();
	}
}
