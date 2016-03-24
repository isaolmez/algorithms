package com.isa.section2.chapter1.exercises;

import com.isa.section2.chapter1.Insertion;
import com.isa.section2.chapter1.Selection;
import com.sedgewick.stdlib.Stopwatch;

public class Exercise_2_1_6 {
	public static void main(String[] args) {
		Stopwatch st = new Stopwatch();
		String[] a = new String[10000];
		for(int i = 0; i < 10000; i++){
			a[i] = "a";
		}
		
		Insertion.sort(a);
		System.out.println("Insertion sort: " + st.elapsedTime());
		st = new Stopwatch();
		Selection.sort(a);
		System.out.println("Selection sort: " + st.elapsedTime());
		/***
		 * Insertion sort is faster when all keys are identical
		 */
	}
}
