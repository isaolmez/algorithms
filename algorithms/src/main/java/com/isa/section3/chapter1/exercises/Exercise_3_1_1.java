package com.isa.section3.chapter1.exercises;

import com.isa.section3.chapter1.BinarySearchST;
import com.isa.section3.chapter1.OrderedST;

public class Exercise_3_1_1 {
	public static void main(String[] args) {
		OrderedST<Double, String> st = new BinarySearchST<>();
		st.put(4.33, "A+");
		st.put(4.00, "A");
		st.put(3.67, "A-");
		st.put(3.33, "B+");
		st.put(3.00, "B");
		st.put(2.67, "B-");
		st.put(2.33, "C+");
		st.put(2.00, "C");
		st.put(1.67, "C-");
		st.put(1.00, "D");
		st.put(0.00, "F");

		Double[] grades = { 1.5, 4.0, 3.0, 2.5 };
		Double sum = 0.0;
		for (Double grade : grades) {
			sum += grade;
		}

		double average = sum / grades.length;
		System.out.println("Average: " + average);
		System.out.println("Grade is: " + st.get(st.floor(average)));

	}
}
