package com.isa.section3.chapter1;

import java.util.Iterator;

public class SequentialSearchST<Key, Value> extends ST<Key, Value> {
    // linked list holder
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private int size = 0;

    @Override
    public void put(Key key, Value value) {
        if (head == null) {
            head = new Node(key, value);
            size++;
            return;
        }

        Node traverser = head;
        while (true) {
            if (traverser.key.equals(key)) {
                traverser.value = value;
                return;
            }

            if (traverser.next != null) {
                traverser = traverser.next;
            } else {
                break;
            }
        }

        traverser.next = new Node(key, value);
        size++;
    }

    @Override
    public Value get(Key key) {
        Node traverser = head;
        while (traverser != null) {
            if (traverser.key.equals(key)) {
                return traverser.value;
            } else {
                traverser = traverser.next;
            }
        }

        return null;
    }

    @Override
    public void delete(Key key) {
        if (head == null) {
            size--;
            return;
        }

        if (size == 1) {
            if (head.key.equals(key)) {
                head = null;
                size--;
            }

            return;
        }

        Node traverser = head;
        while (traverser.next != null) {
            if (traverser.next.key.equals(key)) {
                traverser.next = traverser.next.next;
                size--;
                return;
            }

            traverser = traverser.next;
        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new STIterator();
            }
        };
    }

    private class STIterator implements Iterator<Key> {
        private Node traverser = head;

        @Override
        public boolean hasNext() {
            return traverser != null;
        }

        @Override
        public Key next() {
            Key key = traverser.key;
            traverser = traverser.next;
            return key;
        }

    }

}
