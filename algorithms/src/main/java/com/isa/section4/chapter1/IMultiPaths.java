package com.isa.section4.chapter1;

public interface IMultiPaths {

	boolean hasPathTo(int v, int w);

	Iterable<Integer> pathTo(int v, int w);
}
