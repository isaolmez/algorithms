package com.isa.section1.chapter3.exercises;

import com.isa.section1.chapter3.stack.Stack;


public class Exercise_1_3_9 {
	public static void main(String[] args) {
		isDigit("3");
		System.out.println(convertToInfix("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) "));
	}

	public static String convertToInfix(String expression) {
		Stack<String> operandStack = new Stack<>();
		Stack<String> operatorStack = new Stack<>();
		for(int i = 0; i < expression.length(); i++){
			String temp = expression.substring(i, i+1);
			if(temp.equals(" ")){
				continue;
			}
			
			if(temp.equals(")")){
				if(operatorStack.peek() != null){
					String operator = operatorStack.pop();
					String operand2 = operandStack.pop();
					String operand1 = operandStack.pop();
					
					String newOperand = "(" + operand1 + operator + operand2 + ")";
					operandStack.push(newOperand);
				}
			}else if(isDigit(temp)){
				operandStack.push(temp);
			}else if(isOperator(temp)){
				operatorStack.push(temp);
			}
		}
	
		return operandStack.pop();
	}	
	
	private static boolean isDigit(String s){
		char c = s.charAt(0);
		return c>='0' && c <= '9';
	}
	
	private static boolean isOperator(String s){
		char c = s.charAt(0);
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
}
