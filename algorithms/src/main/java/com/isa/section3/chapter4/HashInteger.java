package com.isa.section3.chapter4;

public class HashInteger {
	private int a;

	public HashInteger(int a) {
		this.a = a;
	}

	public int hashCode() {
		return a;
	}

	public int modularHash() {
		return hashCode() % 31;
	}
	
	public static void main(String[] args) {
		HashInteger hi = new HashInteger(123);
		System.out.println(hi.hashCode());
		System.out.println(hi.modularHash());
	}
}
