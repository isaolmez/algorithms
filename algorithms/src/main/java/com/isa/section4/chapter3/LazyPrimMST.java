package com.isa.section4.chapter3;

import java.util.LinkedList;

import com.isa.section2.chapter4.MinPQ;

public class LazyPrimMST implements IMST {
	private boolean[] marked;
	private LinkedList<Edge> mst;
	private double weight;
	private MinPQ<Edge> crossingEdges;

	public LazyPrimMST(EdgeWeightedGraph g) {
		marked = new boolean[g.V()];
		mst = new LinkedList<>();
		crossingEdges = new MinPQ<>();

		visit(g, 0);
		while (!crossingEdges.isEmpty()) {
			Edge e = crossingEdges.delMin();
			int t = e.either();
			if (!marked[t]) {
				mst.add(e);
				weight += e.weight();
				visit(g, t);
			} else if (!marked[e.other(t)]) {
				mst.add(e);
				weight += e.weight();
				visit(g, e.other(t));
			}
		}
	}

	private void visit(EdgeWeightedGraph g, int v) {
		// Add edge to the MST
		marked[v] = true;

		// Add its adjacent vertices to the PQ
		for (Edge e : g.adj(v)) {
			if (!marked[e.other(v)]) {
				crossingEdges.insert(e);
			}
		}
	}

	@Override
	public Iterable<Edge> edges() {
		return mst;
	}

	@Override
	public double weight() {
		return weight;
	}

	public static void main(String[] args) {
		String fileName = "mediumEWG.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		EdgeWeightedGraph G = new EdgeWeightedGraph(fullPath, " ");
		LazyPrimMST mst = new LazyPrimMST(G);
		for (Edge e : mst.edges())
			System.out.println(e);
		System.out.println(mst.weight());
	}
}
