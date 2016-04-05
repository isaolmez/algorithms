package com.isa.section3.chapter4;

import java.util.Date;

public class HashComplex {
	private int a;
	private Date d;
	private String s;

	public HashComplex(int a, Date d, String s) {
		this.a = a;
		this.d = d;
		this.s = s;
	}

	public int hashCode() {
		final int primeBase = 31;
		int hashResult = 17;
		hashResult = primeBase * hashResult + a;
		hashResult = primeBase * hashResult + (d == null ? 0 : d.hashCode());
		hashResult = primeBase * hashResult + (s == null ? 0 : s.hashCode());
		return hashResult;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null) {
			return false;
		}

		if (!(o instanceof HashComplex)) {
			return false;
		}

		HashComplex target = (HashComplex) o;
		if (a != target.a) {
			return false;
		}

		if (d == null) {
			if (target.d != null) {
				return false;
			}
		} else if (!d.equals(target.d)) {
			return false;
		}

		if (s == null) {
			if (target.s != null) {
				return false;
			}
		} else if (!s.equals(target.s)) {
			return false;
		}

		return true;

	}
}
