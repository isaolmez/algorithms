package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UF2 {
	private int[][] components;
	private int[] siteToComponentMap;

	public UF2(int length) {
		components = new int[length][length];
		siteToComponentMap = new int[length];
		initialize();
	}

	public void union(int p, int q) {
		if (conntected(p, q)) {
			System.out.println("Already connected");
		} else {
			mergeTwoArrays(p, q);
			System.out.println("New component and connection created");
		}
	}

	public int find(int p) {
		return siteToComponentMap[p];
	}

	public boolean conntected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		int size = 0;
		for (int i = 0; i < components.length; i++) {
			if (components[i] != null) {
				size++;
			}
		}

		return size;
	}

	private void initialize() {
		for (int i = 0; i < components.length; i++) {
			for (int k = 0; k < components[i].length; k++) {
				components[i][k] = -1;
			}

			components[i][i] = i;
		}

		for (int m = 0; m < siteToComponentMap.length; m++) {
			siteToComponentMap[m] = m;
		}
	}

	private void mergeTwoArrays(int firstSite, int secondSite) {
		// update the first site
		printArray(components[siteToComponentMap[secondSite]]);
		for (int i = 0; i < components[siteToComponentMap[secondSite]].length; i++) {
			if (components[siteToComponentMap[secondSite]][i] != -1) {
				components[siteToComponentMap[firstSite]][i] = components[siteToComponentMap[secondSite]][i];
			}
		}

		for (int k = 0; k < components[siteToComponentMap[firstSite]].length; k++) {
			if (components[siteToComponentMap[firstSite]][k] != -1) {
				siteToComponentMap[k] = siteToComponentMap[firstSite];
			}
		}

		printSiteMap();
		components[secondSite] = null;
	}

	public void printSiteMap() {
		System.out.println("Site to component map: ");
		for (int i : siteToComponentMap) {
			System.out.print(i);
		}
		System.out.println();
	}

	public void printArray(int[] arr) {
		System.out.println("Printing array: ");
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		readFromFile();
	}

	public static void readFromConsole() throws IOException {
		UF2 uf = new UF2(10);
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

	public static void readFromFile() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(Thread.currentThread().getContextClassLoader().getResource("mediumUF.txt").getPath())));
		String line = reader.readLine();
		UF uf2 = new UF(Integer.parseInt(line));
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			int firstSite = Integer.parseInt(parts[0]);
			int secondSite = Integer.parseInt(parts[1]);
			uf2.union(firstSite, secondSite);
		}
	}
}
