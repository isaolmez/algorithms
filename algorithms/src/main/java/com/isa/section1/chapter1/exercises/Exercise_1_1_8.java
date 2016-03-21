package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_8 {

	public static void main(String[] args) {
		System.out.println('b'); // prints the char literal.
		System.out.println(('b' + 'c')); // this expression has become an arithmetic operation and prints the integer literal.
		System.out.println((char) ('a' + 4)); // integer is casted back to the char literal.
		System.out.println((char) 300); // integer value is casted to the char literal.
	}
}
