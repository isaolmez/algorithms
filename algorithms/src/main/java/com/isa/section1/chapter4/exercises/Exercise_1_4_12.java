package com.isa.section1.chapter4.exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise_1_4_12 {
	public static void main(String[] args) {
		int[] first = { 5, 6, 7, 8, 9, 10, 11 };
		int[] second = { 1, 2, 5, 10, 11, 12 };
		System.out.println(intersection(first, second));
	}

	public static List<Integer> intersection(int[] first, int[] second) {
		List<Integer> list = new ArrayList<>();
		int firstIndex = 0;
		int secondIndex = 0;
		while (firstIndex < first.length && secondIndex < first.length) {
			if (second[secondIndex] == first[firstIndex]) {
				list.add(first[firstIndex]);
				firstIndex++;
				secondIndex++;
			} else if (second[secondIndex] < first[firstIndex]) {
				secondIndex++;
			} else if (second[secondIndex] > first[firstIndex]) {
				firstIndex++;
			}
		}

		return list;
	}
}
