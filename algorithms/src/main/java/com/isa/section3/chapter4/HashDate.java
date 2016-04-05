package com.isa.section3.chapter4;

public class HashDate {
	private int day;
	private int month;
	private int year;

	public HashDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int hashCode() {
		int hash = 17;
		hash = hash * 31 + day;
		hash = hash * 31 + month;
		hash = hash * 31 + year;
		return hash;
	}

	public int modularHash(int indexSize) {
		int hash = 17;
		hash = (hash * 31 + day) % indexSize;
		hash = (hash * 31 + month % indexSize);
		hash = (hash * 31 + year) % indexSize;
		return hash;
	}

	public int modularHash2(int indexSize) {
		return (hashCode() & 0x7fffffff) % indexSize;
	}

	public static void main(String[] args) {
		HashDate hd = new HashDate(12, 2, 2011);
		System.out.println(hd.hashCode());
		System.out.println(hd.modularHash(97));
		System.out.println(hd.modularHash2(97));
	}
}
