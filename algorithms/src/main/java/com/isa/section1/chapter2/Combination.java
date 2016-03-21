package com.isa.section1.chapter2;

public class Combination {

	public static void combination(int number) {
		int count = 0;
		for (int i = 0; i < number; i++) {
			for (int k = i + 1; k < number; k++) {
				count++;
				System.out.println("Combination " + count + ": " + i + " " + k);
			}
		}
	}

	public static void main(String[] args) {
		combination(6);
	}
}
