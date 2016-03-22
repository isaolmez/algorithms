package com.isa.section1.chapter3.exercises;

import com.isa.section1.chapter3.stack.ResizingArrayStackWithIterator;

public class Exercise_1_3_8 {
	public static void main(String[] args) {
		ResizingArrayStackWithIterator<String> stack = new ResizingArrayStackWithIterator<String>(8);
		String input = "it was - the best - of times - - - it  was - the - -";
		String[] parts = input.split(" ");
		for (String part : parts) {
			if (part.equals("-")) {
				System.out.println(stack.pop());
			} else {
				stack.push(part);
			}
		}
		
		System.out.println("Size: " + stack.size());
		for(String s: stack){
			System.out.println(s + " ");
		}
	}
}
