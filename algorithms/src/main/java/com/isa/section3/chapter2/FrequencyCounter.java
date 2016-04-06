package com.isa.section3.chapter2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.sedgewick.stdlib.StdOut;
import com.sedgewick.stdlib.Stopwatch;

public class FrequencyCounter {
	public static void main(String[] args) throws IOException {
		int minlen = 8; // key-length cutoff
		String fileName = "tale.txt";
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath());
		Scanner scanner = new Scanner(new FileReader(new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath())));
		BST<String, Integer> st = new BST<String, Integer>();
		Stopwatch watch = new Stopwatch();
		int count = 0;
		while (scanner.hasNext()) { // Build symbol table and count frequencies.
			String word = scanner.next();
			count++;
			if (word.length() < minlen)
				continue; // Ignore short keys.

			if (!st.contains(word))
				st.put(word, 1);
			else
				st.put(word, st.get(word) + 1);
		}

		// Print total keys
		System.out.println("Size (total keys): " + count);

		// Print distinct keys
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