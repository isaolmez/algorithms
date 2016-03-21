package com.isa.section1.sandbox;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>(); 
		stringList.add("isa");
		System.out.println(stringList);
		
		mutate(stringList); // Equals  to => List stringList = new ArrayList<String>();
		System.out.println(stringList);
	
		// Also equals to below code
		List oldList = new ArrayList<String>();
		oldList.add("a");
		oldList.add(2);
		System.out.println(oldList);
		
		List<String> newList = new ArrayList();
		newList.add("a");
		mutate(newList);
		System.out.println(newList);
	}
	
	public static void mutate(List list){
		list.add(2);
	}
}
