package com.isa.section4.chapter1;

import java.io.InputStream;

public abstract class Graph {
	public Graph(int V) {
	}

	public Graph(InputStream stream) {
	}

	public abstract int V();

	public abstract int E();

	public abstract void addEdge(int v, int w);

	public abstract Iterable<Integer> adj(int v);

	public abstract String toString();
}
