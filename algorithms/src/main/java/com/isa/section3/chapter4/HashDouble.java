package com.isa.section3.chapter4;

public class HashDouble {
	private double val;

	public HashDouble(double val) {
		this.val = val;
	}

	public int hashCode() {
		long longVal = Double.doubleToLongBits(val);
		return (int) (longVal ^ (longVal >>> 32));
	}

	public int modularHash() {
		return hashCode() % 31;
	}

	public static void main(String[] args) {
		HashDouble hd = new HashDouble(12.5);
		System.out.println(hd.hashCode());
		System.out.println(hd.modularHash());
	}
}
