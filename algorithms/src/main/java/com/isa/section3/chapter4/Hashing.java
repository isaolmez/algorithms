package com.isa.section3.chapter4;

public class Hashing {
	private int a;
	private int b;
	private int c;

	public Hashing(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hashing other = (Hashing) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Hashing h = new Hashing(3,3,3);
		System.out.println(h.hashCode());
		
	}

}
