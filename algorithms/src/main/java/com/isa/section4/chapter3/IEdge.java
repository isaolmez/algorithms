package com.isa.section4.chapter3;

public interface IEdge extends Comparable<IEdge>{

	double weight();
	
	int either();
	
	int other(int v);
	
	int compareTo(IEdge that);
}
