package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_15 {

	public static void main(String[] args) {
		int[] arr = { 0, 3, 0, 6, 2, 0, 1, 6, 5 };
		int m = 7;
		int count = 0;
		for (int i : histogram(arr, m)) {
			System.out.println(i);
			count += i;
		}

		System.out.println("Array length: " + count);
	}

	public static int[] histogramBasic(int[] arr, int m) {
		int[] histogram = new int[m];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < arr.length; k++) {
				if (arr[k] == i) {
					histogram[i]++;
				}
			}
		}

		return histogram;
	}

	public static int[] histogram(int[] arr, int m){
		int[] histogram = new int[m];
			for(int k = 0; k< arr.length; k++){
					histogram[arr[k]]++;
			}
		
		return histogram;
	}
}
