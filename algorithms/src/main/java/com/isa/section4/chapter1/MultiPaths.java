package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class MultiPaths implements IMultiPaths, IConnectedComponents {
	private boolean[] marked;
	private int[] components;
	private int component;
	private int[] edgeTo;

	public MultiPaths(Graph g) {
		marked = new boolean[g.V()];
		components = new int[g.V()];
		edgeTo = new int[g.V()];
		for (int i = 0; i < edgeTo.length; i++) {
			edgeTo[i] = -1;
		}

		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				dfs(g, i);
				component++;
			}
		}
	}

	private void dfs(Graph g, int s) {
		marked[s] = true;
		components[s] = component;

		for (int a : g.adj(s)) {
			if (!marked[a]) {
				edgeTo[a] = s;
				dfs(g, a);
			}
		}
	}

	@Override
	public boolean hasPathTo(int v, int w) {
		return components[v] == components[w];
	}

	@Override
	public Iterable<Integer> pathTo(int v, int w) {
		
		//TODO This is not correct. Merge two paths until the intersection, in the worst case until the root of component. 
		Stack<Integer> stack = new Stack<>();
		if (!hasPathTo(v, w)) {
			return stack;
		}

		int i;
		for (i = w; i != v; i = edgeTo[i]) {
			if(i==-1){
				break;
			}
			
			stack.push(i);
		}
		
		if(i != -1){
			stack.push(v);
		}else{
			stack.clear();
			for (i = v; i != w; i = edgeTo[i]) {
				if(i==-1){
					break;
				}
				
				stack.push(i);
			}
			
			stack.push(w);
		}
		
		return stack;
	}

	@Override
	public boolean connected(int v, int w) {
		return hasPathTo(v, w);
	}

	@Override
	public int count() {
		return component;
	}

	@Override
	public int id(int v) {
		return components[v];
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyCG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph G = new Graph(new FileInputStream(filePath));
		MultiPaths paths = new MultiPaths(G);
		for (int v = 0; v < G.V(); v++) {
			for (int w = 0; w < G.V(); w++) {
				System.out.print(v + " to " + w + ": ");
				if (paths.hasPathTo(v, w)) {
					if(v == 5 && w == 4 ){
						System.out.println();
					}
					Iterable<Integer> pathTo = paths.pathTo(v, w);
					for (int x : pathTo)
//						if (x == v)
//							System.out.print(x);
//						else
							System.out.print(" " + x);
					System.out.println();
				}
			}
		}
	}
}
