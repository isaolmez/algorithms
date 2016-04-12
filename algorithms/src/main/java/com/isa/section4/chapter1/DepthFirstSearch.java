package com.isa.section4.chapter1;

public class DepthFirstSearch implements ISearch {

	private Graph graph;
	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph g, int s) {
		this.graph = g;
		marked = new boolean[g.V()];
		search(s);
	}

	@Override
	public boolean marked(int v) {
		return marked[v];
	}

	@Override
	public int count() {
		// int count = 0;
		// for (boolean isMarked : marked) {
		// if (isMarked) {
		// count++;
		// }
		// }
		return count;
	}

	public void search(int vertex) {
		marked[vertex] = true;
		count++;
		for (int traverser : graph.adj(vertex)) {
			if (!marked[traverser]) {
				search(traverser);
			}
		}
	}
}
