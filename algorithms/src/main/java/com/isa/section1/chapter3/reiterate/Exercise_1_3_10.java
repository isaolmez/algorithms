package com.isa.section1.chapter3.reiterate;


import java.util.LinkedList;

public class Exercise_1_3_10 {

    public static void main(String[] args) {
        System.out.println(InfixToPostfix.convert("((1+2)+((3-4)+(5*6)))"));
    }

    public static class InfixToPostfix {
        public static String convert(String infix) {
            char[] symbols = infix.toCharArray();
            LinkedList<String> operands = new LinkedList<>();
            LinkedList<String> operators = new LinkedList<>();
            for (int i = 0; i < symbols.length; i++) {
                char current = symbols[i];
                if (current == ')') {
                    String operand2 = operands.pop();
                    String operand1 = operands.pop();
                    String operator = operators.pop();
                    String postFixOperand = String.format("(%s%s%s)", operand1, operand2, operator);
                    operands.push(postFixOperand);
                } else if (isDigit(current)) {
                    operands.push(String.valueOf(current));
                } else if (isOperator(current)) {
                    operators.push(String.valueOf(current));
                }
            }

            return operands.pop();
        }

        private static boolean isDigit(char c) {
            return c >= '0' && c <= '9';
        }

        private static boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }
    }
}
