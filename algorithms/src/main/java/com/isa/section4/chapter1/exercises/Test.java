package com.isa.section4.chapter1.exercises;

public class Test {

	public static boolean startsWithUpper(String input) {
		if (input == null || input.length() == 0) {
			return false;
		}

		char c = input.charAt(0);
		if (c >= 65 && c <= 90) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(startsWithUpper("zdfasdas"));
		// Identity and Inheritance test operators
		String s1 = "";
		System.out.println(s1 instanceof String);
		System.out.println(s1 instanceof Object);
		// System.out.println(s1 instanceof Number); // Not in the same inheritance tree
		Object s2 = "";
		System.out.println(s2 instanceof Number);

		System.out.println(s1 == "");
		System.out.println(s1 == new Object());
		// System.out.println(s1 == new Integer(2)); // Not in the same inheritance tree
		System.out.println(s2 == new Integer(2));
		
		// Class Objects
		// Shows same behaviour with Python classes and design
		Integer i = new Integer(2);
		System.out.println(i.getClass());
		System.out.println(i.getClass().getClass());
		System.out.println(i.getClass().getClass().getClass());
		
	}
}
