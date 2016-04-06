package com.isa.section3.chapter5;

import com.isa.section3.chapter4.LinearProbingHashST;

public class SparseVector {
	private LinearProbingHashST<Integer, Double> columnValues;

	public SparseVector() {
		columnValues = new LinearProbingHashST<Integer, Double>(10);
	}

	public void put(Integer key, Double value) {
		columnValues.put(key, value);
	}

	public Double get(Integer key) {
		if (columnValues.contains(key))
			return columnValues.get(key);
		else
			return 0.0;
	}

	public Double dot(Double[] that) {
		double sum = 0.0;
		for (Integer key : columnValues.keys()) {
			sum += that[key] * columnValues.get(key);
		}

		return sum;
	}
}
