package com.isa.section4.chapter3;

public interface IEdgeWeightedGraph {
	int V();

	int E();

	void addEdge(Edge e);

	Iterable<Edge> adj(int v);

	Iterable<Edge> edges();

	String toString();
}
