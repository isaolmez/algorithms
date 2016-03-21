package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_26 {

	public static void main(String[] args) {
		sort(4, 7, 1);
		sortAnaloguos(4, 7, 1);
	}

	public static void sort(int a, int b, int c) {
		int t = 0;
		if (a > b) {
			t = a;
			a = b;
			b = t;
		}
		
		if (a > c) {
			t = a;
			a = c;
			c = t;
		}
		
		if (b > c) {
			t = b;
			b = c;
			c = t;
		}
		
		System.out.println(a + " " + b + " " + c);
	}

	public static void sortAnaloguos(int a, int b, int c) {
		// Construct an array from variables and sort this variables
		// it follows the same logic, finds the minimum for subsequent subarrays
		int[] arr = { a, b, c }; 
		// Find minimum for subarrays of length 3,2
		for (int i = 0; i < 3; i++) {
			int minIndex = i;
			for(int k = i+1; k<3; k++){
				if(arr[k]<arr[minIndex]){
					minIndex = k;
				}
			}
			// move the minimum at index minIndex to starting position of current (sub)array.
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		for(int i : arr){
			System.out.print(i+" ");
		}
	}
}
