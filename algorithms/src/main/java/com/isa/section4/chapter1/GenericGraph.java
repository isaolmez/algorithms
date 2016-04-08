package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.isa.section1.chapter3.bag.Bag;
import com.isa.section3.chapter4.SeperateChainingHashST;

/**
 * In this ADT API, vertex names can be anything not just integers. To support this, we will use symbol table, seperate chaining hashing symbol table to be specific. Key will be
 * vertex name, and value will be bag of vertices.
 */
public class GenericGraph<Type> extends IGenericGraph<Type> {
	private SeperateChainingHashST<Type, Bag<Type>> backingHashST;
	private int vertexCount;
	private int edgeCount;

	public GenericGraph(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		scanner.useDelimiter("\\s+");
		vertexCount = scanner.nextInt();
		scanner.nextInt(); // read edge count;
		backingHashST = new SeperateChainingHashST<Type, Bag<Type>>(997);

		while (scanner.hasNext()) {
			Type first = (Type) scanner.next();
			Type second = (Type) scanner.next();
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
	public void addEdge(Type v, Type w) {
		if (!backingHashST.contains(v)) {
			backingHashST.put(v, new Bag<Type>());
		}

		backingHashST.get(v).add(w);

		if (!backingHashST.contains(w)) {
			backingHashST.put(w, new Bag<Type>());
		}

		backingHashST.get(w).add(v);
		edgeCount++;
	}

	@Override
	public Iterable<Type> adj(Type v) {
		return backingHashST.get(v);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Number of vertices: ").append(vertexCount).append(". Number of edges: ").append(edgeCount).append("\n");
		for (Type v : backingHashST.keys()) {
			buffer.append(v).append(": ");
			for (Type adj : backingHashST.get(v)) {
				buffer.append(adj).append(", ");
			}

			buffer.delete(buffer.length() - 2, buffer.length()).append("\n");
		}

		return buffer.toString();
	}

	public static void main(String[] args) throws IOException {
		String fileName = "tinyStringG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		GenericGraph<String> g = new GenericGraph<String>(new FileInputStream(filePath));
		System.out.println(g);
	}

}
