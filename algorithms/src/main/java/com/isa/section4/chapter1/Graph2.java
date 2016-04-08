package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import com.isa.section1.chapter3.bag.Bag;

/**
 * In this API, all vertices are integers. Because of this, our data representation is vertice-indexed array of bags.
 *
 */
public class Graph2 extends IGraph {
	private Bag<Integer>[] bagArray;
	private final int vertexCount;
	private int edgeCount;

	public Graph2(int V) {
		bagArray = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			bagArray[i] = new Bag();
		}

		vertexCount = V;
	}

	public Graph2(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		scanner.useDelimiter("\\s+");
		vertexCount = scanner.nextInt();
		scanner.nextInt(); // read edge count
		bagArray = (Bag<Integer>[]) new Bag[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			bagArray[i] = new Bag();
		}

		while (scanner.hasNext()) {
			int first = scanner.nextInt();
			int second = scanner.nextInt();
			this.addEdge(first, second);
		}

		scanner.close();
	}

	@Override
	public int V() {
		return vertexCount;
	}

	@Override
	public int E() {
		return edgeCount;
	}

	@Override
	public void addEdge(int v, int w) {
		bagArray[v].add(w);
		bagArray[w].add(v);
		edgeCount++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return bagArray[v];
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Number of vertices: ").append(vertexCount).append(". Number of edges: ").append(edgeCount).append("\n");
		for (int i = 0; i < vertexCount; i++) {
			buffer.append(i).append(": ");
			for (Integer integer : bagArray[i]) {
				buffer.append(integer).append(", ");
			}

			buffer.delete(buffer.length() - 2, buffer.length()).append("\n");
		}

		return buffer.toString();
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph2 g = new Graph2(new FileInputStream(filePath));
		System.out.println(g);
	}

}
