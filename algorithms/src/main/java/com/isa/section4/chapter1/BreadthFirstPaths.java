package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;

import com.isa.section1.chapter3.queue.Queue;
import com.isa.section1.chapter3.stack.Stack;

public class BreadthFirstPaths implements IPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int source;

	public BreadthFirstPaths(Graph g, int source) {
		this.source = source;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		bfs(g, source);
	}

	private void bfs(Graph g, int source) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[source] = true;
		queue.enqueue(source);
		while (!queue.isEmpty()) {
			int current = queue.dequeue();
			for (int a : g.adj(current)) {
				if (!marked[a]) {
					marked[a] = true;
					edgeTo[a] = current;
					queue.enqueue(a);
				}
			}
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		Stack<Integer> stack = new Stack<>();
		
		int current;
		for (current = v; current != source; current = edgeTo[current]) {
			stack.push(current);
		}

		stack.push(source);
		return stack;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyCG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph G = new Graph(new FileInputStream(filePath));
		int s = 0;
		BreadthFirstPaths paths = new BreadthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			System.out.print(s + " to " + v + ": ");
			if (paths.hasPathTo(v))
				for (int x : paths.pathTo(v))
					if (x == s)
						System.out.print(x);
					else
						System.out.print("-" + x);
			System.out.println();
		}
	}
}
