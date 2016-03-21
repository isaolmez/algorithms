package com.isa.section1.chapter2;

import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.StdRandom;

public class Counter {
	private final String name;
	private int count;

	public Counter(String id) {
		name = id;
	}

	public void increment() {
		count++;
	}

	public int tally() {
		return count;
	}

	public String toString() {
		return count + " " + name;
	}

	public static void main(String[] args) {
		int T = 100000;
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		for (int t = 0; t < T; t++)
			if (StdRandom.bernoulli(0.5))
				heads.increment();
			else
				tails.increment();
		StdOut.println(heads);
		StdOut.println(tails);
		int d = heads.tally() - tails.tally();
		StdOut.println("delta: " + Math.abs(d));
	}
}