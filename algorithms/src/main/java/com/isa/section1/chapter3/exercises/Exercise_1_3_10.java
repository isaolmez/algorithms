package com.isa.section1.chapter3.exercises;

import com.isa.section1.chapter3.stack.Stack;

public class Exercise_1_3_10 {
	public static String convertFromInfixToPostfix(String expression) {
		Stack<String> operatorStack = new Stack<String>();
		Stack<String> operandStack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			String temp = expression.substring(i, i + 1);
			if (isDigit(temp)) {
				operandStack.push(temp);
			} else if (isOperator(temp)) {
				operatorStack.push(temp);
			} else if (temp.equals(")")) {
				String operator = operatorStack.pop();
				String operand2 = operandStack.pop();
				String operand1 = operandStack.pop();
				String newOperand = "(" + operand1 + operand2 + operator + ")";
				operandStack.push(newOperand);
			}
		}
		
		return operandStack.pop();
	}

	private static boolean isDigit(String value) {
		char c = value.charAt(0);
		return c >= '0' && c <= '9';
	}

	private static boolean isOperator(String value) {
		char c = value.charAt(0);
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
	
	public static void main(String[] args) {
		
		System.out.println(convertFromInfixToPostfix("( (1 * 3) + (7 / 9) )"));
		
	}
}
