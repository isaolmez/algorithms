package com.isa.section4.chapter2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.isa.section1.chapter3.bag.Bag;

public class Digraph implements IDigraph {
	private Bag<Integer>[] adjList;
	private int verticeCount = 0;
	private int edgeCount = 0;

	public Digraph(int V) {
		this.adjList = (Bag<Integer>[]) new Bag[V];
		this.verticeCount = V;
		for (int i = 0; i < V; i++) {
			adjList[i] = new Bag<Integer>();
		}
	}

	public Digraph(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		scanner.useDelimiter("\\s+");
		/** Read vertice and edge count */
		this.verticeCount = scanner.nextInt();
		scanner.nextInt(); // read edge count

		/** Initialize the adjacency list and individual bags */
		this.adjList = (Bag<Integer>[]) new Bag[verticeCount];
		for (int i = 0; i < verticeCount; i++) {
			adjList[i] = new Bag<Integer>();
		}

		/** Read edges from input stream and add to the directed graph */
		while (scanner.hasNext()) {
			int firstVertex = scanner.nextInt();
			int secondVertex = scanner.nextInt();
			this.addEdge(firstVertex, secondVertex);
		}

		scanner.close();
	}

	public Digraph(InputStream stream, String delimiter) {
		Scanner scanner = new Scanner(stream);
		scanner.useDelimiter(delimiter);
		/** Read vertice and edge count */
		this.verticeCount = scanner.nextInt();
		scanner.nextInt(); // read edge count

		/** Initialize the adjacency list and individual bags */
		this.adjList = (Bag<Integer>[]) new Bag[verticeCount];
		for (int i = 0; i < verticeCount; i++) {
			adjList[i] = new Bag<Integer>();
		}

		/** Read edges from input stream and add to the directed graph */
		while (scanner.hasNext()) {
			int firstVertex = scanner.nextInt();
			int secondVertex = scanner.nextInt();
			this.addEdge(firstVertex, secondVertex);
		}

		scanner.close();
	}
	
	@Override
	public int V() {
		return this.verticeCount;
	}

	@Override
	public int E() {
		return this.edgeCount;
	}

	@Override
	public void addEdge(int v, int w) {
		adjList[v].add(w);
		edgeCount++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adjList[v];
	}

	@Override
	public IDigraph reverse() {
		Digraph reverse = new Digraph(this.verticeCount);
		for (int i = 0; i < verticeCount; i++) {
			for (int temp : adj(i)) {
				reverse.addEdge(temp, i);
			}
		}

		return reverse;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Number of vertices: ").append(verticeCount).append(". Number of edges: ").append(edgeCount).append("\n");
		for (int i = 0; i < verticeCount; i++) {
			buffer.append(i).append(": ");
			for (Integer integer : adjList[i]) {
				buffer.append(integer).append(", ");
			}

			buffer.delete(buffer.length() - 2, buffer.length()).append("\n");
		}

		return buffer.toString();
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyDG.txt";
		String fullPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Digraph digraph = new Digraph(new FileInputStream(fullPath));
		System.out.println(digraph.toString());
	}

}
