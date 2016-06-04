package com.isa.section4.chapter2;

import java.io.IOException;

import com.isa.section1.chapter3.queue.Queue;
import com.isa.section1.chapter3.stack.Stack;

public class DepthFirstOrder {

	private boolean[] marked;
	private Queue<Integer> pre = new Queue<>();
	private Queue<Integer> post = new Queue<>();
	private Stack<Integer> postReverse = new Stack<>();

	public DepthFirstOrder(Digraph g) {
		marked = new boolean[g.V()];
		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				dfs(g, i);
			}
		}
	}

	private void dfs(Digraph g, int s) {
		marked[s] = true;
		pre.enqueue(s);

		for (int a : g.adj(s)) {
			if (!marked[a]) {
				dfs(g, a);
			}
		}

		post.enqueue(s);
		postReverse.push(s);
	}

	public Iterable<Integer> pre() {
		return pre;
	}

	public Iterable<Integer> post() {
		return post;
	}

	public Iterable<Integer> postReverse() {
		return postReverse;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "jobs.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		SymbolDigraph digraph = new SymbolDigraph(fullPath, "/");
		DepthFirstOrder dfs = new DepthFirstOrder(digraph.G());
		for(int i : dfs.pre){
			System.out.print(i + ", ");
		}
		
		System.out.println();
		for(int i : dfs.post){
			System.out.print(i + ", ");
		}
		
		System.out.println();
		for(int i : dfs.postReverse){
			System.out.print(i + ", ");
		}
	}
}
