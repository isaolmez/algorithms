package com.isa.section4.chapter2;

import java.io.IOException;

public class Topological implements ITopological {
	private Iterable<Integer> order;

	public Topological(Digraph g) {
		IDirectedCycle directedCycle = new DirectedCycle(g);
		if (!directedCycle.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(g);
			order = dfs.postReverse();
		}
	}

	@Override
	public boolean isDAG() {
		return order != null;
	}

	@Override
	public Iterable<Integer> order() {
		return order;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "jobs.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		SymbolDigraph sg = new SymbolDigraph(fullPath, "/");
		Topological top = new Topological(sg.G());
		for (int v : top.order())
			System.out.println(sg.name(v));
	}
}
