package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.isa.section1.chapter3.bag.Bag;
import com.sedgewick.stdlib.StdOut;

public class ConnectedComponents implements IConnectedComponents {
	private boolean[] marked;
	private int[] components;
	private int count;

	public ConnectedComponents(Graph g) {
		marked = new boolean[g.V()];
		components = new int[g.V()];
		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				dfs(g, i);
				count++;
			}
		}
	}

	private void dfs(Graph g, int s) {
		marked[s] = true;
		components[s] = count;
		for (int a : g.adj(s)) {
			if (!marked[a]) {
				dfs(g, a);
			}
		}
	}

	@Override
	public boolean connected(int v, int w) {
		return components[v] == components[w];
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int id(int v) {
		return components[v];
	}

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "tinyG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph G = new Graph(new FileInputStream(filePath));
		ConnectedComponents cc = new ConnectedComponents(G);
		int M = cc.count();
		System.out.println(M + " components");
		Bag<Integer>[] components;
		components = (Bag<Integer>[]) new Bag[M];
		for (int i = 0; i < M; i++)
			components[i] = new Bag<Integer>();
		for (int v = 0; v < G.V(); v++)
			components[cc.id(v)].add(v);
		for (int i = 0; i < M; i++) {
			for (int v : components[i])
				StdOut.print(v + " ");
			System.out.println();
		}
	}

}
