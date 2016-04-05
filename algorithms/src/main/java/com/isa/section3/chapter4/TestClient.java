package com.isa.section3.chapter4;

import com.isa.section3.chapter1.ST;
import com.sedgewick.stdlib.StdOut;

public class TestClient {
	public static void main(String[] args) {
		ST<String, Integer> st;
		st = new SeperateChainingHashST<String, Integer>(17);
//		String[] input = "SEARCHEXAMPLE".split("");
		String[] input = "EASYQUESTION".split("");
		for (int i = 0; i < input.length; i++) {
			System.out.println("Putting: " + input[i]);
			st.put(input[i], i);
		}

		System.out.println(st.contains("X"));
		System.out.println(st.size());
		for (String s : st.keys()) {
			StdOut.println(s + " " + st.get(s));
		}
	}
}
