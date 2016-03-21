package com.isa.section1.chapter3.questions;

import com.isa.section1.chapter3.stack.BasicStackWithIterator;

public class Q1_3_5 {
	public static void main(String[] args) {
		System.out.println(toBinaryBasic(6));
		System.out.println(toBinaryPrefixed(6));
		toBinaryWithStack(6);
	}

	public static void toBinaryWithStack(int number) {
		BasicStackWithIterator<String> stack = new BasicStackWithIterator<String>(2);
		for(int i = number; i > 0; i = i / 2){
			stack.push(String.valueOf(i%2));
		}
		
		System.out.println();
		for(String s : stack){
			System.out.print(s);
		}
	}

	public static String toBinaryBasic(int number) {
		String binaryRepresentation = "";
		for (int i = number; i > 0; i = i / 2) {
			binaryRepresentation = (i % 2) + binaryRepresentation;
		}

		return binaryRepresentation;
	}

	public static String toBinaryPrefixed(int number) {
		String binaryRepresentation = "0";
		for (int i = 30; i >= 0; i--) {
			binaryRepresentation = binaryRepresentation + (number / (int)Math.pow(2, i));
			System.out.println(binaryRepresentation);
			if(number / (int)Math.pow(2, i) > 0){
				number = number - (int) Math.pow(2, i);	
			}
		}

		return binaryRepresentation;
	}
}
