package com.isa.section1.chapter3.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.isa.section1.chapter3.linkedlist.BasicLinkedList;

public class Exercise_1_3_7 {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter the string: ");
            String input = reader.readLine();
            String[] parts = input.split(" ");
            for (String part : parts) {
                if (part.equals("-")) {
                    System.out.println(stack.pop());
                } else {
                    stack.push(part);
                }
            }

            for (String s : stack) {
                System.out.print(s);
            }
        }
    }

    private static class Stack<Item> implements Iterable<Item> {
        private BasicLinkedList<Item> backingList;

        public Stack() {
            backingList = new BasicLinkedList<Item>();
        }

        public void push(Item item) {
            backingList.insertToEnd(item);
        }

        public Item pop() {
            if (isEmpty()) {
                return null;
            }

            return backingList.removeFromEnd();
        }

        public boolean isEmpty() {
            return backingList.size() == 0;
        }

        public int size() {
            return backingList.size();
        }

        public Item peek() {
            return backingList.peekTail();
        }

        private class StackIterator implements Iterator<Item> {
            Iterator<Item> iter = backingList.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Item next() {
                return iter.next();
            }
        }

        @Override
        public java.util.Iterator<Item> iterator() {
            return new StackIterator();
        }

    }

}