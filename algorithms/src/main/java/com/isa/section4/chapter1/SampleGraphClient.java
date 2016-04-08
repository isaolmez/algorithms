package com.isa.section4.chapter1;

public class SampleGraphClient {
	public static int degree(Graph2 g, int v) {
		int count = 0;
		for (Integer i : g.adj(v)) {
			count++;
		}

		return count;
	}

	public static int maxDegree(Graph2 g) {
		int maxDegree = 0;
		for (int i = 0; i < g.V(); i++) {
			int degree = degree(g, i);
			if (degree > maxDegree) {
				maxDegree = degree;
			}
		}

		return maxDegree;
	}

	public static int avgDegree(Graph2 g) {
		int sum = 0;
		for (int i = 0; i < g.V(); i++) {
			sum += degree(g, i);
		}

		return sum / g.V();
	}

	public static int avgDegree2(Graph2 g) {
		return 2 * g.E() / g.V();
	}

	public static int numberOfSelfLoops(Graph2 g) {
		int count = 0;
		for (int i = 0; i < g.V(); i++) {
			for (Integer adjecent : g.adj(i)) {
				if (adjecent == i) {
					count++;
				}
			}
		}
		
		return count/2;
	}
}
