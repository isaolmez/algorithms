package com.isa.section1.chapter2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Interval1DBasic {

	private double start;
	private double end;

	public Interval1DBasic(double start, double end) {
		this.start = start;
		this.end = end;
	}

	public double getStart() {
		return start;
	}

	public double getEnd() {
		return end;
	}

	public boolean intersects(Interval1DBasic target) {
		if (target.getStart() > this.getEnd()){
			return false;
		}

		if (target.getEnd() < this.getStart()){
			return false;
		}

		return true;
	}

	public boolean contains(double value) {
		if (value >= this.getStart() && value <= this.getEnd()) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Interval1D [start=" + start + ", end=" + end + "]";
	}

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.exit(1);
		}

		int number = Integer.parseInt(args[0]);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		Interval1DBasic[] intervals = new Interval1DBasic[number];
		for (int i = 0; i < number; i++) {
			String pair = reader.readLine();
			String[] parts = pair.split(" ");
			intervals[i] = new Interval1DBasic(Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]));
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
