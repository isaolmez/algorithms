package com.isa.section1.chapter2;

import com.sedgewick.stdlib.In;
import com.sedgewick.stdlib.StdIn;
import com.sedgewick.stdlib.StdOut;

public class Whitelist {
	public static void main(String[] args) {
		int[] w = In.readInts(args[0]);
		StaticSETofInts set = new StaticSETofInts(w);
		while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
			int key = StdIn.readInt();
			if (!set.contains(key))
				StdOut.println(key);
		}
	}
}