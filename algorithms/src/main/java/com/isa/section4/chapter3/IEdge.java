package com.isa.section4.chapter3;

public interface IEdge extends Comparable<Edge>{

	double weigth();
	
	int either();
	
	int other();
	
	int compareTo(Edge that);
}
