package com.isa.section2.chapter4.exercises;

import com.isa.section2.chapter4.MaxPQ;

public class Exercise_2_4_1 {
	public static void main(String[] args) {
		MaxPQ<String> maxPQ = new MaxPQ<String>();
		String s = "P R I O * R * * I * T * Y * * * Q U E * * * U * E";
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("*")) {
				System.out.println(maxPQ.delMax());
			} else {
				maxPQ.insert(arr[i]);
			}
		}
	}
	
	/***
	 * P R I O * R * * I * T * Y * * * Q U E * * * U * E
	 * 
	 * START EMPTY
	 * -
	 * 
	 * - P 
	 * 
	 * - P R
	 * - R P
	 * 
	 * - R P I
	 * - R P I
	 * 
	 * - R P I O
	 * - R P I O
	 * 
	 * * => R
	 * - O P I 
	 * - P O I
	 * 
	 * - P O I R
	 * - P R I O
	 * - R P I O
	 * 
	 * * => R
	 * - O P I
	 * - P O I
	 * 
	 * * => P
	 * - I O
	 * - O I
	 * 
	 * - O I I
	 * - O I I
	 * 
	 * * => O
	 * - I I
	 * 
	 * - I I T
	 * - T I I 
	 * 
	 * * => T
	 * - I I 
	 * 
	 * - I I Y
	 * - Y I I
	 * 
	 * * => Y
	 * - I I
	 * 
	 * * => I
	 * * => I
	 * 
	 * - Q
	 * 
	 * - Q U
	 * - U Q
	 * 
	 * - U Q E
	 * - U Q E
	 * 
	 * * => U
	 * - E Q
	 * - Q E
	 * 
	 * * => Q
	 * * => E
	 * 
	 * - U
	 * 
	 * * => U
	 * 
	 * - E 
	 * 
	 */
}
