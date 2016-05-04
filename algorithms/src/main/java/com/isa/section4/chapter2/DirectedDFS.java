package com.isa.section4.chapter2;

import java.io.FileInputStream;
import java.io.IOException;

import com.isa.section1.chapter3.queue.Queue;
import com.isa.section1.chapter3.stack.Stack;

public class DirectedDFS {

	boolean[] marked;

	public DirectedDFS(Digraph g, int s) {
		marked = new boolean[g.V()];
		dfs(g, s);
	}

	public DirectedDFS(Digraph g, Iterable<Integer> sources) {
		marked = new boolean[g.V()];
		for (int source : sources) {
			dfs(g, source);
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	private void dfs(Digraph g, int s) {
		marked[s] = true;
		System.out.println(s + " is marked");
		for (int adj : g.adj(s)) {
			if (!marked[adj]) {
				dfs(g, adj);
			}
		}
	}

	private void dfsIterative(Digraph g, int s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while (stack.size() != 0) {
			int current = stack.pop();
			/** second check is necessary, because it can be marked after it is pushed into the stack */
			if (!marked[current]) {
				marked[current] = true;
			} else {
				continue;
			}

			System.out.println(current + " is marked");
			for (int i : g.adj(current)) {
				if (!marked[i]) {
					stack.push(i);
				}
			}
		}
	}

	private void dfsIterativeOrderPreserved(Digraph g, int s) {
		Stack<Queue<Integer>> stack = new Stack<>();
		Queue<Integer> levelQueue = new Queue<>();
		levelQueue.enqueue(s);
		stack.push(levelQueue);
		while (stack.size() != 0) {
			Queue<Integer> poppedQueue = stack.pop();
			if (poppedQueue.size() == 0) {
				continue;
			}

			int current = poppedQueue.dequeue();
			stack.push(poppedQueue);
			/** second check is necessary, because it can be marked after it is pushed into the stack */
			if (!marked[current]) {
				marked[current] = true;
			} else {
				continue;
			}

			System.out.println(current + " is marked");
			levelQueue = new Queue<>();
			for (int i : g.adj(current)) {
				if (!marked[i]) {
					levelQueue.enqueue(i);
				}
			}

			/** Preserve the order */
			stack.push(levelQueue);
		}
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyDG.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Digraph digraph = new Digraph(new FileInputStream(fullPath));
		DirectedDFS directedDFS = new DirectedDFS(digraph, 6);
		for (int v = 0; v < digraph.V(); v++) {
			if (directedDFS.marked(v)) {
				System.out.print(v + " ");
			}
		}
	}
}
