package com.isa.section4.chapter1;


public abstract class IGraph {
	public abstract int V();

	public abstract int E();

	public abstract void addEdge(int v, int w);

	public abstract Iterable<Integer> adj(int v);

	public abstract String toString();
}
