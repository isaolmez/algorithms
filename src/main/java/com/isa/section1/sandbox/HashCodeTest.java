package com.isa.section1.sandbox;

import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {
	public String name;
	
	public HashCodeTest(String name){
		this.name = name;
	}
	
	public boolean equals(Object target){
		if(!(target instanceof HashCodeTest)){
			return false;
		}
		
		HashCodeTest casted = (HashCodeTest)target;
		if(casted.name.equals(this.name))
		{
			return true;
		}
		
		return false;
	}
	
	// Comment out to see the effect
//	public int hashCode(){
//		return name.length();
//	}
	
	public static void main(String[] args) {
		Map<HashCodeTest, String> map = new HashMap<>();
		HashCodeTest key1 = new HashCodeTest("isa");
		HashCodeTest key2 = new HashCodeTest("isa");
		
		map.put(key1, "My Value");
		System.out.println(map.get(key1));
		System.out.println(map.get(key2));
	}
}
