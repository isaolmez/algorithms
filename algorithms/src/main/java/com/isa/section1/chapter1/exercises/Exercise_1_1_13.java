package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_13 {
	public static void main(String[] args) {
		int[][] arr = {{0,3,2},{9,3,5},{2,4,7}};
		printMatrix(arr);
		transposition(arr);
		printMatrix(arr);
		
	}

	public static void transposition(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int k = i; arr[i] != null && k < arr[i].length; k++) {
				int temp = arr[i][k];
				arr[i][k] = arr[k][i];
				arr[k][i] = temp;
			}
		}
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; arr[0] != null && k < arr[0].length; k++) {
				System.out.print(arr[i][k]);
				System.out.print(" ");
			}

			System.out.println();
		}
	}
}
