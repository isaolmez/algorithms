package com.isa.section1.sandbox;


public class CloneTest implements Cloneable {
	private int i = 12;
	public int[] arr = new int[2];
	public void setValue(int i){
		this.i = i;
		arr[0] = 12;
	}
	public static void main(String[] args) throws Exception {
		CloneTest test = new CloneTest();
		System.out.println(test instanceof Cloneable);
		test.setValue(22);
		test.arr[0] = 22;
		CloneTest o = (CloneTest)test.clone();
		System.out.println(o.i);
		System.out.println(o.arr[0]);
		test.arr[0] = 23;
		System.out.println(o.arr[0]);
		o.arr[0] = 1;
		System.out.println(test.arr[0] +" "+o.arr[0]);	
	}
}
