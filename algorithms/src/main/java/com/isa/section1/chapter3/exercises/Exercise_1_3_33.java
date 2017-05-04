package com.isa.section1.chapter3.exercises;

import java.util.Iterator;

public class Exercise_1_3_33 {

    public static void main(String[] args) {
        Deque<Integer> steque = new Deque<>();
        for (int i = 0; i < 20; i++) {
            steque.addFirst(i);
        }
        for (Integer item : steque) {
            System.out.printf("%s ", item);
            steque.removeFirst();
        }

        System.out.println();
        for (int i = 0; i < 20; i++) {
            steque.addLast(i);
        }
        for (Integer item : steque) {
            System.out.printf("%s ", item);
        }

        System.out.println();
        System.out.printf("Size: %s", steque.size());
    }

    private static class Deque<T> implements Iterable<T> {

        private int size;

        private Node head;

        private Node tail;

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
        }

        public void addFirst(T value) {
            if (head == null) {
                head = tail = new Node(value, null, null);
            } else {
                head = new Node(value, head, null);
            }

            size++;
        }

        public void addLast(T value) {
            if (head == null) {
                head = tail = new Node(value, null, null);
            } else {
                tail.next = new Node(value, null, tail);
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
                    head.prev = null;
                }

                size--;
                return result;
            }
        }

        public T removeLast() {
            if (head == null) {
                return null;
            } else {
                T result = tail.value;
                if (head == tail) {
                    head = tail = head.next;
                } else {
                    tail = tail.prev;
                    tail.next = null;
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
            Node prev;

            public Node(T value) {
                this(value, null);
            }

            public Node(T value, Node next) {
                this(value, next, null);
            }

            public Node(T value, Node next, Node prev) {
                this.value = value;
                this.next = next;
                this.prev = prev;
            }
        }


    }
}
