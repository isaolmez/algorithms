package com.isa.section1.chapter2.exercises;

import com.sedgewick.stdlib.In;
import com.sedgewick.stdlib.StdIn;

public class Exercise_1_2_15 {

	public static int[] readInts(String name) {
		In in = new In(name);
		String input = StdIn.readAll();
		String[] words = input.split("\\s+");
		int[] ints = new int[words.length];
		for (int i = 0; i < words.length; i++)
			ints[i] = Integer.parseInt(words[i]);
		return ints;
	}
}
