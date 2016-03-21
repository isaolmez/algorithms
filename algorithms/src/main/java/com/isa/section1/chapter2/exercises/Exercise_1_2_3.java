package com.isa.section1.chapter2.exercises;

import com.isa.section1.chapter2.Interval1D;
import com.isa.section1.chapter2.Interval2D;
import com.sedgewick.stdlib.StdRandom;

public class Exercise_1_2_3 {
	public static void main(String[] args) {
		int n = 10;// Integer.parseInt(args[0]);
		double min = 0.1;
		double max = 0.9;

		for (int i = 0; i < n; i++) {
			double x1 = StdRandom.uniform(min, max);
			double x2 = StdRandom.uniform(min, max);
			if (x2 < x1) {
				double t = x1;
				x1 = x2;
				x2 = t;
			}

			System.out.println(x1 + " " + x2);
			Interval1D xinterval = new Interval1D(x1, x2);
			Interval1D yinterval = new Interval1D(x1, x2);
			Interval2D box = new Interval2D(xinterval, yinterval);
			box.draw();
		}

	}
}
