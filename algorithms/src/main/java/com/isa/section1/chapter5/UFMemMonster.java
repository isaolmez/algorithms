package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sedgewick.stdlib.Stopwatch;

public class UFMemMonster extends UF2 {
	private int[] siteToComponentMap;
	private int[][] components;

	public UFMemMonster(int length) {
		components = new int[length][length];
		siteToComponentMap = new int[length];
		componentCount = length;
		initialize();
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			// printArray(components[siteToComponentMap[secondSite]]);
			// Merge second and first component
			for (int i = 0; i < components[siteToComponentMap[q]].length; i++) {
				if (components[siteToComponentMap[q]][i] != -1) {
					components[siteToComponentMap[p]][i] = components[siteToComponentMap[q]][i];
				}
			}

			for (int k = 0; k < components[siteToComponentMap[p]].length; k++) {
				if (components[siteToComponentMap[p]][k] != -1) {
					siteToComponentMap[k] = siteToComponentMap[p];
				}
			}

			// printSiteMap();
			components[q] = null;
			componentCount--;
		}
	}

	public int find(int p) {
		return siteToComponentMap[p];
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
		for (int i = 0, k = 2; i++ < 4; k += k) {
			Stopwatch stopWatch = new Stopwatch();
			readFromFile(k + "kUF.txt");
			System.out.println(stopWatch.elapsedTime());
		}
	}

	public static void readFromConsole() throws IOException {
		UFMemMonster uf = new UFMemMonster(10);
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
		UFMemMonster uf = new UFMemMonster(Integer.parseInt(line));
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			int firstSite = Integer.parseInt(parts[0]);
			int secondSite = Integer.parseInt(parts[1]);
			uf.union(firstSite, secondSite);
		}
		
		System.out.println("Component Count: " + uf.count());
	}
}
