package com.isa.section2.chapter5.exercises;

public class Exercise_2_5_1 {
	public static void main(String[] args) {
		
	}
	/**
	 * if (this == that) return 0;  // this line
	 * 
	 * This line is the best case, two references are equal. Skip the inner loop.
	 * growth of running time becomes constant from linear.
	 * 
	 */
	
//	public int compareTo(String that) 
//	{
//	   if (this == that) return 0;  // this line
//	   int n = Math.min(this.length(), that.length());
//	   for (int i = 0; i < n; i++)
//	   {
//	      if      (this.charAt(i) < that.charAt(i)) return -1;
//	      else if (this.charAt(i) > that.charAt(i)) return +1;
//	   }
//	   return this.length() - that.length(); 
//	}
}
