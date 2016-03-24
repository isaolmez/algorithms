package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sedgewick.stdlib.Stopwatch;

public class UFQuickUnion extends UF2 {
	private int[] siteToAdjacentSite;

	public UFQuickUnion(int length) {
		this.siteToAdjacentSite = new int[length];
		this.componentCount = length;
		initialize();
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			int rootP = findRoot(p);
			int rootQ = findRoot(q);
			siteToAdjacentSite[rootP] = rootQ;
			componentCount--;
		}
	}

	public int find(int p) {
		return findRoot(p);
	}

	private void initialize() {
		for (int i = 0; i < siteToAdjacentSite.length; i++) {
			siteToAdjacentSite[i] = i;
		}
	}

	private int findRoot(int p) {
		while (true) {
			if (p == siteToAdjacentSite[p]) {
				return p;
			}

			p = siteToAdjacentSite[p];
		}
	}

	public static void main(String[] args) throws IOException {
		for (int i = 0, k = 2; i++ < 6; k *= 2) {
			Stopwatch stopWatch = new Stopwatch();
			readFromFile(k + "kUF.txt");
			System.out.println("Complete elapsed time: " + stopWatch.elapsedTime());
		}
		
		Stopwatch stopWatch = new Stopwatch();
		readFromFile("largeUF.txt");
		System.out.println("Complete elapsed time: " + stopWatch.elapsedTime());
	}

	public static void readFromConsole() throws IOException {
		UFQuickUnion uf = new UFQuickUnion(10);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter a pair: ");
			String line = reader.readLine();
			String[] parts = line.split(" ");
			int firstSite = Integer.parseInt(parts[0]);
			int secondSite = Integer.parseInt(parts[1]);
			uf.union(firstSite, secondSite);
		}
	}

	public static void readFromFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath())));
		String line = reader.readLine();
		UFQuickUnion uf = new UFQuickUnion(Integer.parseInt(line));
		Stopwatch st = new Stopwatch();
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			int firstSite = Integer.parseInt(parts[0]);
			int secondSite = Integer.parseInt(parts[1]);
			uf.union(firstSite, secondSite);
		}

		System.out.println("Component Count: " + uf.count());
		System.out.println("Elapsed Time After initialization: " + st.elapsedTime());
	}
}
