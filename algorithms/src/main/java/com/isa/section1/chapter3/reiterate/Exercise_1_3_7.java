package com.isa.section1.chapter3.reiterate;

import java.util.Arrays;

public class Exercise_1_3_7 {
    public static void main(String[] args) {
        System.out.println("--- Resizing Array Implementation");
        ResizingStack<Integer> resizingStack = new ResizingStack<>();
        for (int i = 0; i < 20; i++) {
            resizingStack.push(i);
            System.out.println(resizingStack.pop());
        }

        for (int i = 0; i < 20; i++) {
            resizingStack.push(i);
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(resizingStack.pop());
        }

        System.out.println("--- Linked List Implementation");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 20; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack.pop());
        }

        for (int i = 0; i < 20; i++) {
            linkedListStack.push(i);
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(linkedListStack.pop());
        }
    }

    private static class ResizingStack<T> {
        private int size;

        private T[] values;

        public ResizingStack() {
            size = 0;
            values = (T[]) new Object[10];
        }

        public ResizingStack(int initialSize) {
            size = 0;
            values = (T[]) new Object[initialSize < 0 ? 10 : initialSize];
        }

        public void push(T value) {
            addLast(value);
        }

        public T pop() {
            return removeLast();
        }

        public T peek() {
            return values[size - 1];
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
        }

        public void addLast(T value) {
            resizeIfNeeded();
            values[size++] = value;
        }

        public T removeLast() {
            if (size == 0) {
                return null;
            }

            size--;
            T val = values[size];
            values[size] = null;
            return val;
        }

        private void resizeIfNeeded() {
            if (shouldResize()) {
                values = Arrays.copyOf(values, values.length * 2 + 1);
            }
        }

        private boolean shouldResize() {
            return size == values.length;
        }
    }

    private static class LinkedListStack<T> {
        private int size;
        private Node head;

        public LinkedListStack() {
            size = 0;
            head = null;
        }

        public void push(T value) {
            addFirst(value);
        }

        public T pop() {
            return removeFirst();
        }

        public T peek() {
            return head == null ? null : head.value;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
        }

        public void addFirst(T value) {
            size++;
            head = new Node(value, head);
        }

        public T removeFirst() {
            if (head == null) {
                return null;
            }

            size--;
            T result = head.value;
            head = head.next;
            return result;
        }

        private class Node {
            T value;
            Node next;

            public Node(T value) {
                this(value, null);
            }

            public Node(T value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }
}
