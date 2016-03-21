package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_12 {

	public static void main(String[] args) {
		swapWeird();
	}

	public static void swapWeird() {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++){
			a[i] = 9 - i;
		}
		// initial print
		for (int i = 0; i < 10; i++){
			System.out.print(a[i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < 10; i++)
			a[i] = a[a[i]];
		// final print
		for (int i = 0; i < 10; i++){
			System.out.print(a[i]);
		}	
	}
}
