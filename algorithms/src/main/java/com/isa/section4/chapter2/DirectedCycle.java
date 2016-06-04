package com.isa.section4.chapter2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class DirectedCycle implements IDirectedCycle {
	private boolean[] marked;
	private boolean[] onStack;
	private boolean hasCycle;
	private int[] edgeTo;
	private Stack<Integer> stack;

	public DirectedCycle(Digraph g) {
		marked = new boolean[g.V()];
		onStack = new boolean[g.V()];
		edgeTo = new int[g.V()];
		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				dfs(g, i);
			}
		}
	}

	private void dfs(Digraph g, int s) {
		marked[s] = true;
		onStack[s] = true;

		for (int a : g.adj(s)) {
			if (!marked[a]) {
				edgeTo[a] = s;
				dfs(g, a);
			} else {
				if (onStack[a]) {
					hasCycle = true;
					stack = new Stack<>();
					stack.push(a);
					for(int i = s; i != a; i = edgeTo[i]){
						stack.push(i);
					}

					stack.push(a);
				}
			}
		}

		onStack[s] = false;
	}

	@Override
	public boolean hasCycle() {
		return hasCycle;
	}

	@Override
	public Iterable<Integer> cycle() {
		return stack;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyDG.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Digraph digraph = new Digraph(new FileInputStream(fullPath));
		DirectedCycle directedCycle = new DirectedCycle(digraph);
		if (directedCycle.hasCycle()) {
			System.out.println(directedCycle.cycle());
		}
	}
}
