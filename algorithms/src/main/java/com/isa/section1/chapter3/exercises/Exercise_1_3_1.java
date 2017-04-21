package com.isa.section1.chapter3.exercises;

public class Exercise_1_3_1 {
    private static class FixedCapacityStackOfStrings {
        private int cap;
        private String[] backingArray;
        private int size;

        public FixedCapacityStackOfStrings(int cap) {
            this.cap = cap;
            backingArray = new String[this.cap];
        }

        public void push(String item) {
            backingArray[size++] = item;
        }

        public String pop() {
            if (!isEmpty()) {
                return backingArray[--size];
            }

            return null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // Checks whether the backing array is full
        public boolean isFull() {
            return size == backingArray.length;
        }

        public int size() {
            return size;
        }
    }
}