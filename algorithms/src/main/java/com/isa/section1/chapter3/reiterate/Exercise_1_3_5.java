package com.isa.section1.chapter3.reiterate;

import java.util.LinkedList;

public class Exercise_1_3_5 {

    public static void main(String[] args) {
        final int number1 = 50;
        final int number2 = 15;
        System.out.println(BinaryRepresentation.version1(number1));
        System.out.println(BinaryRepresentation.version1(number2));
        System.out.println(BinaryRepresentation.version2(number1));
        System.out.println(BinaryRepresentation.version2(number2));
        System.out.println(BinaryRepresentation.version3(number1));
        System.out.println(BinaryRepresentation.version3(number2));
    }


    private static class BinaryRepresentation {

        public static String version1(int number) {
            int current = number;
            String binary = "";
            while (current > 0) {
                binary = (current % 2) + binary;
                current = current / 2;
            }

            return binary;
        }

        public static String version2(int number) {
            int current = number;
            LinkedList<String> stack = new LinkedList<>();
            while (current > 0) {
                stack.push(String.valueOf(current % 2));
                current = current / 2;
            }

            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
            }

            return builder.toString();
        }

        public static String version3(int number) {
            int current = number;
            String binary = "";
            if (current > 0) {
                binary = version3(number / 2) + (number % 2);
            }

            return binary;
        }
    }
}
