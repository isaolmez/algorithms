package com.isa.section1.chapter3.exercises;

import com.isa.section1.chapter3.queue.Queue;

public class Exercise_1_3_37 {
	public static void main(String[] args) {
		Josephus j = new Josephus();

		System.out.println(j.solution(35, 2));
		System.out.println(j.solution2(35, 2));
	}
}

class Josephus {
	public int solution(int n, int m) {
		boolean[] marked = new boolean[n];
		int traverser = -1;
		for (int i = 0; i < n - 1; i++) {
			for (int k = 0; k < m;) {
				traverser = ++traverser % n;
				if (!marked[traverser]) {
					k++;
				}
			}

			// System.out.println(traverser);
			marked[traverser] = true;
		}

		for (int i = 0; i < marked.length; i++) {
			if (marked[i] == false) {
				return i;
			}
		}

		return -1;
	}

	public int solution2(int n, int m) {
		Queue<Integer> first = new Queue<Integer>();
		Queue<Integer> second = new Queue<Integer>();
		int order = 1;

		for (int i = 0; i < n; i++) {
			first.enqueue(i);
		}

		int count = 0;
		Queue<Integer> temp;
		while (count != n - 1) {
			for (int i = 0; i < m -1; i++) {
				second.enqueue(first.dequeue());
				if(first.isEmpty()){
					temp = first;
					first = second;
					second = temp;
				}
			}
			
			first.dequeue();
			if(first.isEmpty()){
				temp = first;
				first = second;
				second = temp;
			}
			
			// Increment counter
			count++;
		}

		return first.dequeue();
	}
}