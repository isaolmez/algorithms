package com.isa.section3.chapter4.exercises;

public class Exercise_3_4_5 {
	
	/***
	 * This hashCode is legal. It gives the same hash code for equal objects; since it gives the same value in all conditions. 
	 * Result of using this hashCode is that SeperateChainingHashST becomes SequentialSearchST. Constant growth of running time becomes Quadratic
	 * LinearProbingHashST also becomes quadratic
	 */
	public int hashCode() {
		return 17;
	}
}
