package com.isa.section3.chapter5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.sedgewick.stdlib.StdOut;

public class DeDup {
	public static void main(String[] args) throws IOException {
		HashSET<String> set = new HashSET<String>(10);
		String fileName = "tinyTale.txt";
		Scanner scanner = new Scanner(new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath()));
		scanner.useDelimiter("\\s+");
		while (scanner.hasNext()) {
			String key = scanner.next();
			if (!set.contains(key)) {
				set.add(key);
				StdOut.println(key);
			}
		}
	}
}