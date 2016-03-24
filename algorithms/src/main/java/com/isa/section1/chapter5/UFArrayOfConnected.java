package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.isa.section1.chapter3.linkedlist.BasicLinkedList;
import com.sedgewick.stdlib.Stopwatch;

public class UFArrayOfConnected extends UF {
	private int[] siteToComponent;
	private BasicLinkedList<Integer>[] components;

	public UFArrayOfConnected(int length) {
		siteToComponent = new int[length];
		components = (BasicLinkedList<Integer>[]) new BasicLinkedList[length];
		componentCount = length;
		initialize();
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			int firstComponent = find(p);
			int secondComponent = find(q);
			components[firstComponent].addAll(components[secondComponent]);
			BasicLinkedList<Integer> secondList = components[secondComponent];
			for (Integer site : secondList) {
				siteToComponent[site] = firstComponent;
			}

			components[secondComponent] = null;
			componentCount--;
		}
	}

	public int find(int p) {
		return siteToComponent[p];
	}

	private void initialize() {
		for (int m = 0; m < components.length; m++) {
			components[m] = new BasicLinkedList<Integer>();
			components[m].insertToEnd(m);
			siteToComponent[m] = m;
		}
	}

	public void printSiteMap() {
		System.out.println("Site to component map: ");
		for (int i : siteToComponent) {
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

	public static void main(String[] args) throws IOException, InterruptedException {
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
		UFArrayOfConnected uf = new UFArrayOfConnected(10);
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
		UFArrayOfConnected uf = new UFArrayOfConnected(Integer.parseInt(line));
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
