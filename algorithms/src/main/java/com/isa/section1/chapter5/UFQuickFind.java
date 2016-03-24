package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sedgewick.stdlib.Stopwatch;

public class UFQuickFind extends UF {
	private int[] siteToComponentMap;

	public UFQuickFind(int length) {
		siteToComponentMap = new int[length];
		componentCount = length;
		initialize();
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			int firstComponent = find(p);
			int secondComponent = find(q);
			if (firstComponent == secondComponent) {
				return;
			}

			for (int i = 0; i < siteToComponentMap.length; i++) {
				if (siteToComponentMap[i] == secondComponent) {
					siteToComponentMap[i] = firstComponent;
				}
			}
			
			componentCount--;
		}
	}

	public int find(int p) {
		return siteToComponentMap[p];
	}

	private void initialize() {
		for (int m = 0; m < siteToComponentMap.length; m++) {
			siteToComponentMap[m] = m;
		}
	}

	private void printSiteMap() {
		System.out.println("Site to component map: ");
		for (int i : siteToComponentMap) {
			System.out.print(i);
		}
		System.out.println();
	}

	private void printArray(int[] arr) {
		System.out.println("Printing array: ");
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		for (int i = 0, k = 2; i++ < 6; k *= 2) {
			Stopwatch stopWatch = new Stopwatch();
			readFromFile(k + "kUF.txt");
			System.out.println("Complete elapsed time: " + stopWatch.elapsedTime());
		}
	}

	public static void readFromConsole() throws IOException {
		UFQuickFind uf = new UFQuickFind(10);
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
		UFQuickFind uf = new UFQuickFind(Integer.parseInt(line));
		Stopwatch st = new Stopwatch();
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			int firstSite = Integer.parseInt(parts[0]);
			int secondSite = Integer.parseInt(parts[1]);
			uf.union(firstSite, secondSite);
		}
		
//		System.out.println("Component Count: " + uf.count());
		System.out.println("Elapsed Time After initialization: " + st.elapsedTime());
	}
}
