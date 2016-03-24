package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sedgewick.stdlib.Stopwatch;

public class UFWeigthedQuickUnionWithPathCompression extends UF2 {
	private int[] siteToAdjacentSite;
	private int[] componentSizes;

	public UFWeigthedQuickUnionWithPathCompression(int length) {
		this.siteToAdjacentSite = new int[length];
		this.componentSizes = new int[length];
		this.componentCount = length;
		initialize();
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			int rootP = findRoot(p);
			int rootQ = findRoot(q);
			if(componentSizes[rootP] > componentSizes[rootQ]){
				siteToAdjacentSite[rootQ] = rootP;
				componentSizes[rootP] += componentSizes[rootQ];
				componentSizes[rootQ] = 0;
			}else{
				siteToAdjacentSite[rootP] = rootQ;
				componentSizes[rootQ] += componentSizes[rootP];
				componentSizes[rootP] = 0;
			}

			componentCount--;
		}
	}

	public int find(int p) {
		return findRoot(p);
	}

	private void initialize() {
		for (int i = 0; i < siteToAdjacentSite.length; i++) {
			siteToAdjacentSite[i] = i;
			componentSizes[i] = 1;
		}
	}

	private int findRoot(int p) {
		int root = -1;
		int traverser = p;
		while (true) {
			if (traverser == siteToAdjacentSite[traverser]) {
				root = traverser;
				break;
			}

			traverser = siteToAdjacentSite[traverser];
		}
		
		traverser = p;
		while (true) {
			if (traverser == siteToAdjacentSite[traverser]) {
				break;
			}

			int temp = siteToAdjacentSite[traverser];
			traverser = siteToAdjacentSite[traverser];
			siteToAdjacentSite[temp] = root;
		}
		
		return root;
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
		UFWeigthedQuickUnionWithPathCompression uf = new UFWeigthedQuickUnionWithPathCompression(10);
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
		UFWeigthedQuickUnionWithPathCompression uf = new UFWeigthedQuickUnionWithPathCompression(Integer.parseInt(line));
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
