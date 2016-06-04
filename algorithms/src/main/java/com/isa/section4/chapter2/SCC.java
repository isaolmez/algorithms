package com.isa.section4.chapter2;

public class SCC implements ISCC {
	private int[] components;
	private int component;
	private boolean[] marked;

	public SCC(Digraph g){
		marked = new boolean[g.V()];
		components = new int[g.V()];
	}
	
	@Override
	public boolean stronglyConnected(int v, int w) {
		return false;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public int id(int v) {
		return 0;
	}

}
