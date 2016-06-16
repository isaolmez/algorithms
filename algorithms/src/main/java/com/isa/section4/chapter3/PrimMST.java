package com.isa.section4.chapter3;

import java.util.LinkedList;

import com.isa.section2.chapter4.IndexMinPQ;
import com.sedgewick.stdlib.Stopwatch;

public class PrimMST implements IMST {
	// IndexMinPQ
	private IndexMinPQ<Edge> crossing;
	// edgeTo[v] is the shortest edge connecting v to the tree,
	private Edge[] edgeTo;
	private boolean[] marked;
	private double weight;

	public PrimMST(EdgeWeightedGraph g) {
		crossing = new IndexMinPQ<>(g.V());
		edgeTo = new Edge[g.V()];
		marked = new boolean[g.V()];

		visit(g, 0);
		while (!crossing.isEmpty()) {
			int chosenVertex = crossing.minIndex();
			Edge chosenEdge = crossing.keyOf(chosenVertex);
			crossing.delMin();

			edgeTo[chosenVertex] = chosenEdge;
			weight += chosenEdge.weight();
			visit(g, chosenVertex);
		}
	}

	private void visit(EdgeWeightedGraph g, int s) {
		marked[s] = true;
		for (Edge e : g.adj(s)) {
			int t = e.other(s);
			// If not marked
			if (!marked[t]) {
				if (!crossing.contains(t)) {
					crossing.insert(t, e);
				} else {
					Edge existent = crossing.keyOf(t);
					if (existent.compareTo(e) > 0) {
						crossing.changeKey(t, e);
					}
				}
			}
		}
	}

	@Override
	public Iterable<Edge> edges() {
		LinkedList<Edge> mst = new LinkedList<>();
		for (int i = 0; i < edgeTo.length; i++) {
			mst.add(edgeTo[i]);
		}

		return mst;
	}

	@Override
	public double weight() {
		return weight;
	}

	public static void main(String[] args) {
		String fileName = "largeEWG.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		EdgeWeightedGraph G = new EdgeWeightedGraph(fullPath, " ");
		Stopwatch watch = new Stopwatch();
		PrimMST mst = new PrimMST(G);
		System.out.println("Elapsed Time: " + watch.elapsedTime());
//		for (Edge e : mst.edges())
//			System.out.println(e);
		System.out.println(mst.weight());
	}

}
