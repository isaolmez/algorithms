package com.isa.section1.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UF {
	private int[][] sites;

	public UF(int length) {
		sites = new int[length][length];
		initialize();
	}

	public void union(int p, int q){
		if(sites[p][q] != -1){
			System.out.println("Already connected");
		}else{
			mergeTwoArrays(p, q);
			System.out.println("New component and connection created");
		}
	}

	public int find(int p) {
		return p;
	}

	public boolean conntected(int p, int q) {
		if(sites[p][q] != -1){
			return true;
		}
		
		return false;
	}

	public int count() {
		return sites.length;
	}

	private void initialize() {
		for (int i = 0; i < sites.length; i++) {
			for(int k = 0; k<sites[i].length; k++){
				sites[i][k] = -1;
			}
			
			sites[i][i] = i;
		}
	}
	
	private void mergeTwoArrays(int firstSite, int secondSite){
		// update the first site
		for(int i=0; i<sites[firstSite].length; i++){
			if(sites[firstSite][i] != sites[secondSite][i]){
				if(sites[secondSite][i] != -1){
					sites[firstSite][i] = sites[secondSite][i];
				}
			}
		}
		
		// propogate the knowledge to other sites
		for(int k = 0; k<sites[firstSite].length; k++){
			if(sites[firstSite][k] != -1){
				sites[k] = sites[firstSite];
			}
			
		}
	}

	public void printArray(int[] arr) {
		System.out.println("Printing array: ");
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException{
		UF uf = new UF(50);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("Enter a pair: ");
			String line = reader.readLine();
			String[] parts = line.split(" ");
			int firstSite = Integer.parseInt(parts[0]);
			int secondSite = Integer.parseInt(parts[1]);
			uf.union(firstSite, secondSite);
		}
	}
}
