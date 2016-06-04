package com.isa.section4.chapter1;

public interface ISymbolGraph {
	boolean contains(String key);

	int index(String key);

	String name(int v);

	Graph G();
}
