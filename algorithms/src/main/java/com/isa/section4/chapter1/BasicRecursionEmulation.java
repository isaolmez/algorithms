package com.isa.section4.chapter1;

import com.isa.section1.chapter3.queue.Queue;
import com.isa.section1.chapter3.stack.Stack;

public class BasicRecursionEmulation {
	public static void recursiveIndependent(int n) {
		if (n <= 0) {
			return;
		}

		doJob(n);
		recursiveIndependent(n - 1);
	}

	public static void recursiveDependent(int n) {
		if (n <= 0) {
			return;
		}

		recursiveDependent(n - 1);
		doJob(n);
	}

	public static void recursizeDependentEmulate(int n) {
		Stack<Integer> stack = new Stack<>();
		while (n > 0) {
			stack.push(n--);
		}

		while (stack.size() != 0) {
			int item = stack.pop();
			doJob(item);
		}
	}

	public static void recursizeIndependentEmulate(int n) {
		Queue<Integer> queue = new Queue<>();
		while (n > 0) {
			queue.enqueue(n--);
		}

		while (queue.size() != 0) {
			int item = queue.dequeue();
			doJob(item);
		}
	}

	private static void doJob(int n) {
		System.out.print(n);
	}

	public static void main(String[] args) {
		recursiveIndependent(9);
		System.out.println();
		recursiveDependent(9);
		System.out.println();
		recursizeIndependentEmulate(9);
		System.out.println();
		recursizeDependentEmulate(9);
	}
}
