package com.isa.section1.chapter1.exercises;

import com.sedgewick.stdlib.StdOut;

public class Exercise_1_1_19 {

	public static long[] cache = new long[100];
	
	public static long F(int N) {
		if (N == 0){
			return 0;
		}
			
		if (N == 1){
			return 1;
		}
		
		if(cache[N] == 0){
			long result = F(N - 1) + F(N - 2);
			cache[N] = result;
			return result;	
		}else{
			return cache[N];
		}
		
	}
	
	public static long FImproved(int N) {
		if (N == 0)
			return 0;
		if (N == 1)
			return 1;
		return F(N - 1) + F(N - 2);
	}

	public static void main(String[] args) {
		for (int N = 0; N < 100; N++)
			StdOut.println(N + " " + FImproved(N));
	}
	
	
}
