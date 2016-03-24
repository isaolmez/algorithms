package com.isa.section1.chapter5;


public abstract class UF2 {
	protected int componentCount;

	public abstract void union(int p, int q);
	
	public abstract int find(int p);

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int count() {
		return componentCount;
	}
}
