package com.isa.section4.chapter3;

import com.isa.section2.chapter4.IndexMinPQ;

public class EagerPrimMST implements IMST{
	// IndexMinPQ
	private IndexMinPQ<Edge> crossing;
	// edgeTo[v] is the shortest edge connecting v to the tree,
	private Edge[] edgeTo;
	// distTo[v] is the	weight of that edge
	private int[] distTo;
	private double weight;

	public EagerPrimMST(EdgeWeightedGraph g) {
		
	}

	@Override
	public Iterable<Edge> edges() {
		return null;
	}

	@Override
	public double weight() {
		return 0;
	}

}
