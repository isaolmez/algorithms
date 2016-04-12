package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import com.isa.section1.chapter3.stack.Stack;

public class Paths implements IPaths {
	private Graph graph;
	private int source;
	private boolean[] marked;
	private int[] edges;

	public Paths(Graph g, int s) {
		this.graph = g;
		this.source = s;
		this.edges = new int[g.V()];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = -1;
		}

		this.marked = new boolean[g.V()];
		search(s);
	}

	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}

		final Stack<Integer> stack = new Stack<>();
		stack.push(v);
		while(edges[v] != -1){
			stack.push(edges[v]);
			v = edges[v];
		}
		
		return new Iterable<Integer>() {
			
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {

					@Override
					public boolean hasNext() {
						return !stack.isEmpty();
					}

					@Override
					public Integer next() {
						return stack.pop();
					}
				};
			}
		};
	}

	private void search(int vertex) {
		marked[vertex] = true;
		for (int traverser : graph.adj(vertex)) {
			if (!marked[traverser]) {
				edges[traverser] = vertex;
				search(traverser);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph G = new Graph(new FileInputStream(filePath));
		int s = 0;
		Paths search = new Paths(G, s);
		for (int v = 0; v < G.V(); v++) {
			System.out.print(s + " to " + v + ": ");
			if (search.hasPathTo(v))
				for (int x : search.pathTo(v))
					if (x == s)
						System.out.print(x);
					else
						System.out.print("-" + x);
			System.out.println();
		}
	}
}
