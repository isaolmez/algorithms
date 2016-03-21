package com.isa.section1.chapter3.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.isa.section1.chapter3.stack.BasicStackWithIterator;

public class Q_1_3_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter a string: ");
			String line = reader.readLine();
			System.out.println(isProper(line));
		}

	}

	public static boolean isProper(String line) {
		BasicStackWithIterator<String> stack = new BasicStackWithIterator<String>(2);
		for (int i = 0; i < line.length(); i++) {
			String temp = line.substring(i, i + 1);
			if (temp.equals(")")) {
				for(String s : stack){
					System.out.println(s);
				}
				String stackString = stack.pop();
				if (stackString == null || !stackString.equals("(")) {
					return false;
				}
			} else {
				stack.push(temp);
			}
		}

		return true;
	}
}
