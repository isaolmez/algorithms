package com.isa.section1.chapter2.exercises;

import com.sedgewick.stdlib.Stopwatch;

public class Exercise_1_2_6 {

	public static boolean isCircularRotationFast(String source, String target) {
		if (source == null || target == null || source.length() != target.length()) {
			return false;
		}

		return (target + target).indexOf(source) > -1;
	}
	
	public static boolean isCircularRotationSlow(String source, String target) {
		if (source == null || target == null || source.length() != target.length()) {
			return false;
		}

		for (int i = 0; i < target.length(); i++) {
			for (int k = 0; k < target.length(); k++) {
				if (target.charAt((k + i) % target.length()) != source.charAt(k)) {
					break;
				}

				if (k == target.length() - 1) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		String unit = "ACTGACG";
		String reverseUnit = "TGACGAC";
		String large = "";
		String reverse = "";
		for (int i = 0; i < 10000; i++) {
			large += unit;
			reverse += reverseUnit;
		}

		Stopwatch s = new Stopwatch();
		System.out.println(isCircularRotationFast("isa", "sai"));
		System.out.println(isCircularRotationFast("isa", "ssd"));
		System.out.println(isCircularRotationFast(large, reverse));
		System.out.println("Elapsed time: " + s.elapsedTime());

		Stopwatch s2 = new Stopwatch();
		System.out.println(isCircularRotationSlow("isa", "sai"));
		System.out.println(isCircularRotationSlow("isa", "ssd"));
		System.out.println(isCircularRotationSlow(large, reverse));
		System.out.println("Elapsed time: " + s2.elapsedTime());
	}
}
