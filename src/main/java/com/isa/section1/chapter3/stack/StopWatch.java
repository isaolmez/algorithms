package com.isa.section1.chapter3.stack;

public class StopWatch {
	private long lastTimeInMillis;

	public StopWatch() {
		lastTimeInMillis = System.currentTimeMillis();
	}
	
	public void stop(){
		System.out.println(System.currentTimeMillis() - lastTimeInMillis + " have passed");
	}
}
