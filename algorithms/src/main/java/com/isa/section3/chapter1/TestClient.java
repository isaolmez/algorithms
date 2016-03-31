package com.isa.section3.chapter1;

import com.sedgewick.stdlib.StdOut;

public class TestClient {
	public static void main(String[] args) {
		ST<String, Integer> st;
		st = new BinarySearchST<String, Integer>();
		String[] input = "S  E  A  R  C  H  E  X  A  M  P  L  E".split("  ");
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
