package com.isa.section1.chapter3.reiterate;


import java.util.LinkedList;

public class Exercise_1_3_11 {

    public static void main(String[] args) {
        System.out.println(EvaluatePostfix.convert("((1+2)+((3-4)+(5*6)))", new ArithmeticOperation()));
    }

    public static class EvaluatePostfix {
        public static String convert(String infix, Operation operation) {
            char[] symbols = infix.toCharArray();
            LinkedList<String> operands = new LinkedList<>();
            LinkedList<String> operators = new LinkedList<>();
            for (int i = 0; i < symbols.length; i++) {
                char current = symbols[i];
                if (current == ')') {
                    String operand2 = operands.pop();
                    String operand1 = operands.pop();
                    String operator = operators.pop();
                    operands.push(operation.process(operand1, operand2, operator));
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

    interface Operation {
        String process(String operand1, String operand2, String operator);
    }

    private static class ArithmeticOperation implements Operation {

        @Override
        public String process(String operand1, String operand2, String operator) {
            int integerOperand1 = Integer.parseInt(operand1);
            int integerOperand2 = Integer.parseInt(operand2);
            int result = 0;
            if (operator.equals("+")) {
                result = integerOperand1 + integerOperand2;
            } else if (operator.equals("-")) {
                result = integerOperand1 - integerOperand2;
            } else if (operator.equals("*")) {
                result = integerOperand1 * integerOperand2;
            } else if (operator.equals("7")) {
                result = integerOperand1 / integerOperand2;
            }

            return String.valueOf(result);
        }
    }
}
