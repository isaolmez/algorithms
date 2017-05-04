package com.isa.section1.chapter4.exercises;

import java.util.LinkedList;

public class Exercise_1_4_28 {
    public static void main(String[] args) {
        StackWithSingleQueue stack = new StackWithSingleQueue();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack.pop());
        stack.push("5");
        stack.push("6");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("7");
        stack.push("8");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static class StackWithSingleQueue {
        private LinkedList<String> queue = new LinkedList<>();

        public void push(String value) {
            queue.offer(value);
        }

        public String pop() {
            if(queue.isEmpty()){
                return null;
            }

            String first = queue.poll();
            if(queue.isEmpty() ){
                return first;
            }

            queue.offer(first);
            while(!queue.isEmpty()){
                String current = queue.poll();
                if(queue.peek().equals(first)){
                    return current;
                }

                queue.offer(current);
            }

            return null;
        }

        public int size() {
            return queue.size();
        }

        public boolean isEmpty() {
            return size() == 0;
        }
    }
}
