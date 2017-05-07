package com.isa.section5.chapter1;

import java.util.Arrays;

public class LSDSort {
    public static void main(String[] args) {
        String[] values = {
                "4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
                "1OHV845",
                "4JZY524",
                "1ICK750",
                "3CIO720",
                "1OHV845",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723"};
        sort(values, 7);
        System.out.println(Arrays.toString(values));
    }

    public static void sort(String[] values, int W) {
        int R = 256;
        String[] aux = new String[values.length];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < values.length; i++) {
                char c = values[i].charAt(d);
                count[c + 1]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = 0; i < aux.length; i++) {
                char c = values[i].charAt(d);
                aux[count[c]++] = values[i];
            }

            for (int i = 0; i < aux.length; i++) {
                values[i] = aux[i];
            }
        }
    }
}