package com.isa.section1.chapter2;

public class SandField {

	public static void main(String[] args) {
		
		
		String s = "isa";
		Integer i = 2;
		
		Object stringObject = s;
		Object integerObject = i;
		
//		System.out.println(s == i);
		System.out.println(stringObject == integerObject);
		
//		System.out.println(s instanceof Integer);
		System.out.println(stringObject instanceof Integer);
		
	}
}
