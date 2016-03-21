package com.isa.section1.chapter2;

public class ShortDate {
	private int date;

	public ShortDate(int m, int d, int y) {
		date = y * 512 + m * 32 + d;
	}

	public int month() {
		return (date / 32) % 16;
	}

	public int day() {
		return date % 32;
	}

	public int year() {
		return date / 512;
	}

	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
	
	public static void main(String[] args) {
		ShortDate date = new ShortDate(2, 23, 2016);
		System.out.println(date.toString());
	}
}
