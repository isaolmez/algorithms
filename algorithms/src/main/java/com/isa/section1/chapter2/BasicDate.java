package com.isa.section1.chapter2;

public class BasicDate {

	private final int year;
	private final int month;
	private final int day;

	public BasicDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
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

	@Override
	public String toString() {
		return "BasicDate [year=" + year() + ", month=" + month() + ", day=" + day() + "]";
	}

	public static void main(String[] args) {
		BasicDate date = new BasicDate(2016, 2, 23);
		System.out.println(date.toString());
	}
}
