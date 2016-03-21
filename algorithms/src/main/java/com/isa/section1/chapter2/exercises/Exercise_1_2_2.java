package com.isa.section1.chapter2.exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.isa.section1.chapter2.Interval1D;

public class Exercise_1_2_2 {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.exit(1);
		}

		int number = Integer.parseInt(args[0]);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Interval1D[] intervals = new Interval1D[number];
		for (int i = 0; i < number; i++) {
			String pair = reader.readLine();
			String[] parts = pair.split(" ");
			intervals[i] = new Interval1D(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		}

		for (int i = 0; i < intervals.length; i++) {
			for (int k = i + 1; k < intervals.length; k++) {
				if (intervals[i].intersects(intervals[k])) {
					System.out.println(intervals[i] + "-" + intervals[k]);
				}
			}
		}
	}
}
