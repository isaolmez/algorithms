package com.isa.section3.chapter4;

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
		Scanner scanner = new Scanner(new FileReader(new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath())));
		scanner.useDelimiter("\\s+");
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>(997);
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
		int keyCount = 0;
		for (Object o : st.keys()) {
			if (o == null)
				continue;
			String word = (String) o;
			keyCount++;
			// System.out.println("Word: " + word + " - " + st.get(word));
			if (st.get(word) > st.get(max)) {
				max = word;
			}
		}
		System.out.println("Key Count : " + keyCount);
		StdOut.println(max + " " + st.get(max));
		System.out.println("Elapsed time: " + watch.elapsedTime());
	}
}