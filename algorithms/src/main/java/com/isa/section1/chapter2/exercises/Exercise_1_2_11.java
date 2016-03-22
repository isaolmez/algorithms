package com.isa.section1.chapter2.exercises;

public class Exercise_1_2_11 {
	public static void main(String[] args) {
		SmartDate date = new SmartDate(12,2,2000);
		System.out.println(date.dayOfTheWeek());
	}
}

class SmartDate {
	private final int month;
	private final int day;
	private final int year;
	private int[] dayCount = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String[] dayName = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

	public SmartDate(int m, int d, int y) {
		if (!isValidBasic(m, d, y)) {
			throw new RuntimeException("Invalid date");
		}

		month = m;
		day = d;
		year = y;
	}

	private boolean isValidBasic(int m, int d, int y) {
		if (m < 1 || m > 12) {
			return false;
		}

		if (d <= 0 || d > dayCount[m-1]) {
			return false;
		}

		return true;
	}

	public int month() {
		return month;
	}

	public int day() {
		return day;
	}

	public int year() {
		return year;
	}

	public String dayOfTheWeek(){
		//TODO Gauss method can be implemented
		return null;
	}
	
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}

	public boolean equals(Object x) {
		if (this == x)
			return true;
		if (x == null)
			return false;
		if (this.getClass() != x.getClass())
			return false;
		SmartDate that = (SmartDate) x;
		if (this.day != that.day)
			return false;
		if (this.month != that.month)
			return false;
		if (this.year != that.year)
			return false;
		return true;
	}
}
