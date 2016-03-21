package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.isa.section1.chapter3.stack.StopWatch;

public class UF3 {
	private int[] siteToComponentMap;
	private int size;

	public UF3(int length) {
		siteToComponentMap = new int[length];
		size = length;
		initialize();
	}

	public void union(int p, int q) {
		if (conntected(p, q)) {
//			System.out.println("Already connected");
		} else {
			mergeTwoArrays(p, q);
//			System.out.println("New component and connection created");
//			printSiteMap();
		}
	}

	public int find(int p) {
		return siteToComponentMap[p];
	}

	public boolean conntected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return size;
	}

	private void initialize() {
		for (int m = 0; m < siteToComponentMap.length; m++) {
			siteToComponentMap[m] = m;
		}
	}

	private void mergeTwoArrays(int firstSite, int secondSite) {
		int firstComponent = find(firstSite);
		int secondComponent = find(secondSite);
		
		if(firstComponent == secondComponent){
			return;
		}
		
		for(int i = 0; i< siteToComponentMap.length; i++){
			if(siteToComponentMap[i] == secondComponent){
				siteToComponentMap[i] = firstComponent;
			}
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
		StopWatch stopWatch = new StopWatch();
		readFromFile();
		stopWatch.stop();
	}

	public static void readFromConsole() throws IOException {
		UF3 uf = new UF3(10);
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
		UF3 uf = new UF3(Integer.parseInt(line));
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			int firstSite = Integer.parseInt(parts[0]);
			int secondSite = Integer.parseInt(parts[1]);
			uf.union(firstSite, secondSite);
		}
	}
}
