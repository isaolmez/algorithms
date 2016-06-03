package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;

public class TwoColorability {
	private static int WHITE = 0;
	private static int BLACK = 1;

	private boolean isBipartite = true;
	private boolean[] marked;
	private int[] colors;

	public TwoColorability(Graph g) {
		marked = new boolean[g.V()];
		colors = new int[g.V()];
		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				dfs(g, i, WHITE);
			}
		}
	}

	public boolean isBipartite() {
		return isBipartite;
	}
	
	private void dfs(Graph g, int s, int color) {
		marked[s] = true;
		colors[s] = color;
	
		for(int a: g.adj(s)){
			if(!marked[a]){
				dfs(g,a,revert(color));
			}else if(colors[a] == color){
				isBipartite = false;
			}
		}
	}

	private int revert(int color) {
		return (color + 1) % 2;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyCG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph G = new Graph(new FileInputStream(filePath));
		TwoColorability c = new TwoColorability(G);
		System.out.println(c.isBipartite());
	}
}
