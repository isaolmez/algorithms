package com.isa.section3.chapter1;

import com.sedgewick.stdlib.Stopwatch;

/**
 * Although both are quadratic, constant time for sequential is larger.
 * 
 *
 */
public class TestClient2 {
	public static void main(String[] args) {
		ST<Integer, Integer> binarySearchST = new BinarySearchST<Integer, Integer>();
		SequentialSearchST<Integer, Integer> sequentialSearchST = new SequentialSearchST<Integer, Integer>();
		Stopwatch watch = new Stopwatch();
		for (int i = 20000; i > 0; i--) {
			sequentialSearchST.put(i, i);
		}
		System.out.println("SequentialSearch: " + watch.elapsedTime());

		watch = new Stopwatch();
		for (int i = 20000; i > 0; i--) {
			binarySearchST.put(i, i);
		}
		System.out.println("BinarySearch: " + watch.elapsedTime());

	}
}
