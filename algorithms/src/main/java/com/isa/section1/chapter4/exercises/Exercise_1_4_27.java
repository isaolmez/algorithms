package com.isa.section1.chapter4.exercises;

import java.util.LinkedList;

public class Exercise_1_4_27 {
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("6");
        queue.enqueue("7");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

    public static class QueueWithTwoStacks {
        private LinkedList<String> pushStack = new LinkedList<>();
        private LinkedList<String> popStack = new LinkedList<>();

        public void enqueue(String val) {
            pushStack.push(val);
        }

        public String dequeue() {
            if (!popStack.isEmpty()) {
                return popStack.pop();
            }

            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }

            return popStack.pop();
        }

        public int size() {
            return pushStack.size() + popStack.size();
        }

        public boolean isEmpty() {
            return size() == 0;
        }
    }
}
