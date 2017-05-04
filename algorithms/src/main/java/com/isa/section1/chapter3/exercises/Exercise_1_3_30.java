package com.isa.section1.chapter3.exercises;

import java.util.Iterator;

public class Exercise_1_3_30 {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 20; i >= 0; i--) {
            linkedList.addFirst(i);
        }

        for (Integer item : linkedList) {
            System.out.printf("%s ", item);
        }

        System.out.println();
        linkedList.reverseRecursive();
//        linkedList.reverse();
        for (Integer item : linkedList) {
            System.out.printf("%s ", item);
        }

        System.out.println();
        System.out.printf("Size: %s", linkedList.size());
    }

    private static class MyLinkedList<T> implements Iterable<T> {
        private int size;
        private Node head;

        public MyLinkedList() {
            size = 0;
            head = null;
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

        public T getFirst() {
            return head == null ? null : head.value;
        }

        public void reverse() {
            Node traverser = head;
            Node backward = null;
            Node forward;
            while (traverser != null) {
                traverser.next = backward;
                backward = traverser;
                forward = traverser.next;
                traverser = forward;
            }

            head = backward;
        }

        public void reverseRecursive() {
            if (head == null) {
                return;
            }

            Node node = reverseRecursive(head);
            node.next = null;
        }

        public Node reverseRecursive(Node node) {
            if (node.next != null) {
                Node forward = reverseRecursive(node.next);
                forward.next = node;
            } else {
                head = node;
            }

            return node;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
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
