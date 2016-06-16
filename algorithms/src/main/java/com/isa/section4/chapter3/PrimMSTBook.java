package com.isa.section4.chapter3;

import java.util.LinkedList;

import com.isa.section2.chapter4.IndexMinPQ;
import com.sedgewick.stdlib.Stopwatch;

public class PrimMSTBook implements IMST {
	private Edge[] edgeTo; // shortest edge from tree vertex
	private double[] distTo; // distTo[w] = edgeTo[w].weight()
	private boolean[] marked; // true if v on tree
	private IndexMinPQ<Double> pq; // eligible crossing edges
	private double weight;

	public PrimMSTBook(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		distTo[0] = 0.0;
		pq.insert(0, 0.0); // Initialize pq with 0, weight 0.
		while (!pq.isEmpty())
			visit(G, pq.delMin()); // Add closest vertex to tree.
	}

	private void visit(EdgeWeightedGraph G, int v) { // Add v to tree; update data structures.
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (marked[w])
				continue; // v-w is ineligible.
			if (e.weight() < distTo[w]) { // Edge e is new best connection from tree to w.
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
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
		double sum = 0;
		for (int i = 0; i < distTo.length; i++) {
			sum += distTo[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		String fileName = "largeEWG.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		EdgeWeightedGraph G = new EdgeWeightedGraph(fullPath, " ");
		Stopwatch watch = new Stopwatch();
		PrimMSTBook mst = new PrimMSTBook(G);
		System.out.println("Elapsed Time: " + watch.elapsedTime());
		// for (Edge e : mst.edges())
		// System.out.println(e);
		System.out.println(mst.weight());
	}
}
