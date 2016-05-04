package com.isa.section4.chapter2;

public interface IDigraph {
	int V();

	int E();

	void addEdge(int v, int w);

	Iterable<Integer> adj(int v);

	IDigraph reverse();

}
