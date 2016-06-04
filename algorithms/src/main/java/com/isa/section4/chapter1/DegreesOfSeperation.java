package com.isa.section4.chapter1;

import java.io.IOException;

import com.sedgewick.stdlib.StdIn;
import com.sedgewick.stdlib.StdOut;

public class DegreesOfSeperation {
	public static void main(String[] args) throws IOException {
		String fileName = "routes.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		SymbolGraph sg = new SymbolGraph(filePath, " ");
		Graph G = sg.G();
		String source = "JFK";
		if (!sg.contains(source)) {
			System.out.println(source + " not in database.");
			return;
		}
		int s = sg.index(source);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
		while (!StdIn.isEmpty()) {
			String sink = StdIn.readLine();
			if (sg.contains(sink)) {
				int t = sg.index(sink);
				if (bfs.hasPathTo(t))
					for (int v : bfs.pathTo(t))
						StdOut.println("   " + sg.name(v));
				else
					StdOut.println("Not connected");
			} else
				StdOut.println("Not in database.");
		}
	}
}
