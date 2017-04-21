package com.isa.section1.chapter2.exercises;

import com.sedgewick.stdlib.StdDraw;
import com.sedgewick.stdlib.StdRandom;

public class Exercise_1_2_10 {
    public static void main(String[] args) {
        VisualCounter counter = new VisualCounter("trials", 100000, 1000);
        for (int i = 0; i < 100000; i++) {
            if (StdRandom.bernoulli(0.5)) {
                counter.increment();
            } else {
                counter.decrement();
            }
        }
    }

    private static class VisualCounter {
        private final String name;
        private final int operationLimit;
        private final int counterLimit;
        private int count;
        private int operationCount;

        public VisualCounter(String name, int operationLimit, int counterLimit) {
            this.name = name;
            this.operationLimit = operationLimit;
            this.counterLimit = counterLimit;
            StdDraw.setXscale(0, operationLimit);
            StdDraw.setYscale(-counterLimit, counterLimit);
            StdDraw.setPenRadius(.005);
        }

        public int tally() {
            return count;
        }

        public void increment() {
            if (operationCount >= operationLimit) {
                System.out.println("Operation limit has been reached!");
                System.out.println(this);
                return;
            }

            if (Math.abs(count + 1) > counterLimit) {
                System.out.println("Counter limit has been reached!");
                System.out.println(this);
                return;
            }

            operationCount++;
            count++;
            StdDraw.point(operationCount, count);
        }

        public void decrement() {
            if (operationCount >= operationLimit) {
                System.out.println("Operation limit has been reached!");
                System.out.println(this);
                return;
            }

            if (Math.abs(count - 1) > counterLimit) {
                System.out.println("Counter limit has been reached!");
                System.out.println(this);
                return;
            }

            operationCount++;
            count--;
            StdDraw.point(operationCount, count);

        }

        public String toString() {
            return count + " " + name;
        }
    }
}