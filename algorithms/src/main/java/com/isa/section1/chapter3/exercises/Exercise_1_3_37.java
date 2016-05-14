package com.isa.section1.chapter3.exercises;

public class Exercise_1_3_37 {
	public static void main(String[] args) {
		Josephus j = new Josephus();
		j.solution(7, 2);
	}
}

class Josephus {
	public void solution(int n, int m) {
		boolean[] marked = new boolean[n];
		int traverser = -1;
		for (int i = 0; i < n - 1; i++) {
			for (int k = 0; k < m;) {
				traverser = ++traverser % n;
				if (!marked[traverser]) {
					k++;
				}
			}
			System.out.println(traverser);
			marked[traverser] = true;
		}

		for (boolean b : marked) {
			System.out.printf("%b, ", b);
		}
	}
}