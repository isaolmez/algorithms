package com.isa.section1.chapter3.reiterate;

public class Exercise_1_3_19 {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        System.out.println(linkedList.deleteLast());
        System.out.println(linkedList.size());
    }

    private static class MyLinkedList<T> {
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

        public T deleteLast() {
            if (head == null) {
                return null;
            } else if (head.next == null) {
                size--;
                Node last = head;
                head = null;
                return last.value;
            } else {
                Node traverser = head;
                while (traverser.next.next != null) {
                    traverser = traverser.next;
                }

                size--;
                Node last = traverser.next;
                traverser.next = null;
                return last.value;
            }
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
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
