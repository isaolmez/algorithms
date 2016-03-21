package com.isa.section1.chapter1.exercises;

import java.io.IOException;

import com.sedgewick.stdlib.Stopwatch;
import com.sedgewick.stdlib.StopwatchCPU;

public class Exercise_1_1_14 {

	public static void main(String[] args) throws IOException{
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String line = null;
//		while((line=reader.readLine())!= null){
//			StopWatch st = new StopWatch();
//			System.out.println(lgBasic(Integer.parseInt(line)));
//			st.stop();
//		}

		Stopwatch st = new Stopwatch();
		System.out.println(lgBasic(Integer.MAX_VALUE));
		System.out.println(st.elapsedTime());
		
		StopwatchCPU stCPU = new StopwatchCPU();
		System.out.println(lgBasic(Integer.MAX_VALUE));
		System.out.println(stCPU.elapsedTime());
		
		
	}

	public static int lgBasic(int input) {
		int power= 0;
		while(input/2 != 0){
			power++;
			input = input/2;
		}
		
		return power;
	}
}
