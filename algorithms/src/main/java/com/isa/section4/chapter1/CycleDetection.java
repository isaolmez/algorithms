package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;

public class CycleDetection {
	private boolean[] marked;
	private boolean isCyclic = false;

	public CycleDetection(Graph g) {
		marked = new boolean[g.V()];
		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				dfs(g, i, i);
			}
		}
	}

	public boolean isCyclic() {
		return isCyclic;
	}

	private void dfs(Graph g, int s, int p) {
		marked[s] = true;
		for (int a : g.adj(s)) {
			if (!marked[a]) {
				dfs(g, a, s);
			} else if (a != p) {
				isCyclic = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyCG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph G = new Graph(new FileInputStream(filePath));
		CycleDetection c = new CycleDetection(G);
		System.out.println(c.isCyclic());
	}
}
