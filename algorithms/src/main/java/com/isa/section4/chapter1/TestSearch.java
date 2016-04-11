package com.isa.section4.chapter1;

import java.io.FileInputStream;
import java.io.IOException;

import com.sedgewick.stdlib.StdOut;

public class TestSearch {
	public static void main(String[] args) throws IOException {
		String fileName = "tinyG.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		Graph G = new Graph(new FileInputStream(filePath));
		int s = Integer.parseInt(args[1]);
		Search search = new Search(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (search.marked(v)) {
				System.out.print(v + " ");
			}
		}

		StdOut.println();

		if (search.count() != G.V())
			System.out.print("NOT ");
		System.out.println("connected");
	}
}
