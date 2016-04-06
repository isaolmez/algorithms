package com.isa.section3.chapter5;

import com.sedgewick.stdlib.StdIn;
import com.sedgewick.stdlib.StdOut;

public class WhiteFilter {
	public static void main(String[] args) {
		HashSET<String> set;
		set = new HashSET<String>(20);
		// In in = new In(args[0]);
		while (!StdIn.isEmpty())
			set.add(StdIn.readString());
		while (!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if (set.contains(word))
				StdOut.println(word);
		}
	}
}