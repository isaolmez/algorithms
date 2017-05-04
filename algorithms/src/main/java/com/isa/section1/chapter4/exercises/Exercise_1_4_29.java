package com.isa.section1.chapter4.exercises;

import java.util.LinkedList;

public class Exercise_1_4_29 {
    public static void main(String[] args) {
        StequeWithTwoStacks stack = new StequeWithTwoStacks();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.enqueue("51");
        stack.enqueue("52");
        stack.enqueue("53");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("5");
        stack.push("6");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("7");
        stack.push("8");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static class StequeWithTwoStacks {

        private LinkedList<String> pushStack = new LinkedList<>();

        private LinkedList<String> enqueueStack = new LinkedList<>();

        public void push(String value) {
            pushStack.push(value);
        }

        public void enqueue(String value) {
            enqueueStack.push(value);
        }

        public String pop() {
            if (pushStack.isEmpty()) {
                while (!enqueueStack.isEmpty()) {
                    pushStack.push(enqueueStack.pop());
                }
            }

            return pushStack.pop();
        }

        public int size() {
            return pushStack.size() + enqueueStack.size();
        }

        public boolean isEmpty() {
            return size() == 0;
        }

    }
}
