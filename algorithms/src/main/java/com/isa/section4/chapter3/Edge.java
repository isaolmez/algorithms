package com.isa.section4.chapter3;

public class Edge implements IEdge {
	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	@Override
	public int compareTo(IEdge e) {
		if (weight < e.weight()) {
			return -1;
		} else if (weight == e.weight()) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public double weight() {
		return weight;
	}

	@Override
	public int either() {
		return v;
	}

	@Override
	public int other(int vertex) {
		if (vertex == v) {
			return w;
		} else if (vertex == w) {
			return v;
		} else {
			throw new RuntimeException("Inconsistent edge...");
		}
	}

	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}
}
