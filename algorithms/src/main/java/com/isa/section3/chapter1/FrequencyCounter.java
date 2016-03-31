package com.isa.section3.chapter1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.Stopwatch;

public class FrequencyCounter {
	public static void main(String[] args) throws IOException {
		int minlen = 10; // key-length cutoff
		String fileName = "tale100k.txt";
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath());
		BufferedReader reader = new BufferedReader(new FileReader(new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath())));
		String line = null;
		ST<String, Integer> st = new SequentialSearchST<String, Integer>();
		Stopwatch watch = new Stopwatch();
		while ((line = reader.readLine()) != null) { // Build symbol table and count frequencies.
			String[] words = line.split(" ");
			for (String word : words) {
				if (word.length() < minlen)
					continue; // Ignore short keys.
				if (!st.contains(word))
					st.put(word, 1);
				else
					st.put(word, st.get(word) + 1);
			}
		}
		
		//Print distinct keys
		System.out.println("Size (distinct keys): " + st.size());
		
		// Find a key with the highest frequency count.
		String max = "";
		st.put(max, 0);
		for (String word : st.keys())
			if (st.get(word) > st.get(max))
				max = word;
		StdOut.println(max + " " + st.get(max));
		System.out.println("Elapsed time: " + watch.elapsedTime());
	}
}