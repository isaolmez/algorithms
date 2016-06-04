package com.isa.section4.chapter2;

public interface ITopological {
	boolean isDAG();

	Iterable<Integer> order();
}
