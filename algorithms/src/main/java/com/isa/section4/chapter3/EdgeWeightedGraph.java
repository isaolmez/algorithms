package com.isa.section4.chapter3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class EdgeWeightedGraph implements IEdgeWeightedGraph {
	private int V;
	private int E;
	private LinkedList<Edge>[] adjList;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		adjList = (LinkedList<Edge>[]) new LinkedList[V];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Edge>();
		}
	}

	public EdgeWeightedGraph(String filePath, String delimiter) {
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = null;
			/** Setup adjacency list and fundemental data structures */
			this.V = Integer.parseInt(reader.readLine());
			adjList = (LinkedList<Edge>[]) new LinkedList[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new LinkedList<Edge>();
			}
			
			this.E = Integer.parseInt(reader.readLine());
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(delimiter);
				int v = Integer.parseInt(parts[0]);
				int w = Integer.parseInt(parts[1]);
				double weight = Double.parseDouble(parts[2]);
				this.addEdge(new Edge(v, w, weight));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public void addEdge(Edge e) {
		this.E++;
		int vertex = e.either();
		adjList[vertex].add(e);
		adjList[e.other(vertex)].add(e);
	}

	@Override
	public Iterable<Edge> adj(int v) {
		return adjList[v];
	}

	@Override
	public Iterable<Edge> edges() {
		LinkedList<Edge> result = new LinkedList<Edge>();
		for (int i = 0; i < adjList.length; i++) {
			for (Edge e : adj(i)) {
				if (e.other(i) > i) {
					result.add(e);
				}
			}
		}

		return result;
	}

}
