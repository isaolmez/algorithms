package com.isa.section1.chapter1.exercises;

public class Exercise_1_1_9 {

    public static void main(String[] args) {
        int source = 10054886;
        System.out.println(toBinaryPadded(source));
        System.out.println(toBinaryRepresentation1(source));
        System.out.println(toBinaryRepresentation2(source));
    }

    public static String toBinaryPadded(int n) {
        if (n < 0) {
            return "not supported";
        }

        char[] binary = new char[32];
        binary[0] = '0';

        for (int i = 31; i >= 0; i--) {
            if (n >= Math.pow(2, i)) {
                binary[31 - i] = '1';
                n = n % (int) Math.pow(2, i);
            } else {
                binary[31 - i] = '0';
            }
        }

        return new String(binary);
    }

    public static String toBinaryRepresentation1(int n) {
        String s = "";
        for (; n > 0; n /= 2) {
            s = (n % 2) + s;
        }

        return s;
    }

    private static String toBinaryRepresentation2(int num) {
        String result = "";
        while (num != 0) {
            result = num % 2 + result;
            num = num / 2;
        }

        return result;
    }
}
