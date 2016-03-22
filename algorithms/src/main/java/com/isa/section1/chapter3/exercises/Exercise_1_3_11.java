package com.isa.section1.chapter3.exercises;

import com.isa.section1.chapter3.stack.Stack;

public class Exercise_1_3_11 {
	public static void main(String[] args) {
		System.out.println(evaluate("((13*)(79*)+)"));
	}

	public static int evaluate(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<String> operatorStack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			String element = expression.substring(i, i + 1);
			if (isDigit(element)) {
				operandStack.push(Integer.valueOf(element));
			} else if (isOperator(element)) {
				operatorStack.push(element);
			} else if (element.equals(")")) {
				int operand2 = operandStack.pop();
				int operand1 = operandStack.pop();
				String operator = operatorStack.pop();
				operandStack.push(performOperation(operand1, operand2, operator));
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

	private static int performOperation(int operand1, int operand2, String operator) {
		if (operator.equals("+")) {
			return operand1 + operand2;
		} else if (operator.equals("-")) {
			return operand1 - operand2;
		} else if (operator.equals("*")) {
			return operand1 * operand2;
		} else if (operator.equals("/")) {
			return operand1 / operand2;
		} else {// Lazy
			return 0;
		}
	}
}
