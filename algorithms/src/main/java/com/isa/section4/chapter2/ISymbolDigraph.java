package com.isa.section4.chapter2;

public interface ISymbolDigraph {
	boolean contains(String key);

	int index(String key);

	String name(int v);

	Digraph G();
}
