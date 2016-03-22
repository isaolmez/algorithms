package com.isa.section1.chapter2.exercises;

public class Exercise_1_2_8 {
	public static void main(String[] args) {
		int a[] = new int[] {1,2,3};
		int b[] = new int[] {7,8,9};
		int[] t = a;
		a = b;
		b = t;
		
		System.out.print("a: ");
		for(int i : a){
			System.out.print(i);
		}
		
		System.out.print("\nb: ");
		for(int i : b){
			System.out.print(i);
		}
	}
}
