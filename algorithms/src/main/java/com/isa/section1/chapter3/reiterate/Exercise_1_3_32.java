package com.isa.section1.chapter3.reiterate;

import java.util.Iterator;

public class Exercise_1_3_32 {

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        for (int i = 0; i < 20; i++) {
            steque.push(i);
        }
        for (Integer item : steque) {
            System.out.printf("%s ", item);
            steque.pop();
        }

        System.out.println();
        for (int i = 0; i < 20; i++) {
            steque.enqueue(i);
        }
        for (Integer item : steque) {
            System.out.printf("%s ", item);
        }

        System.out.println();
        System.out.printf("Size: %s", steque.size());
    }

    private static class Steque<T> implements Iterable<T> {

        private int size;

        private Node head;

        private Node tail;

        public void push(T value) {
            addFirst(value);
        }

        public T pop() {
            return removeFirst();
        }

        public void enqueue(T value) {
            addLast(value);
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
        }

        public void addFirst(T value) {
            if (head == null) {
                head = tail = new Node(value);
            } else {
                head = new Node(value, head);
            }

            size++;
        }

        public void addLast(T value) {
            if (head == null) {
                head = tail = new Node(value);
            } else {
                tail.next = new Node(value);
                tail = tail.next;
            }

            size++;
        }

        public T removeFirst() {
            if (head == null) {
                return null;
            } else {
                T result = head.value;
                if (head == tail) {
                    head = tail = head.next;
                } else {
                    head = head.next;
                }

                size--;
                return result;
            }
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private Node traverser = head;

                @Override
                public boolean hasNext() {
                    return traverser != null;
                }

                @Override
                public T next() {
                    T value = traverser.value;
                    traverser = traverser.next;
                    return value;
                }
            };
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
