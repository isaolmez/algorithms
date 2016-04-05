package com.isa.section3.chapter4;

public class Sort3Numbers {
	public static void main(String[] args) {
		int a = 4;
		int b = 2;
		int c = 3;

		if(b<a){
			int temp = a;
			a = b;
			b = temp;
		}
		
		if(c<a){
			int temp = a;
			a = c;
			c = temp;
		}
		
		if(c<b){
			int temp = b;
			b = c;
			c = temp;
		}
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
