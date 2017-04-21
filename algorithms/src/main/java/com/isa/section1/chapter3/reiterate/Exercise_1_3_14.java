package com.isa.section1.chapter3.reiterate;

import java.util.Arrays;

public class Exercise_1_3_14 {

    public static void main(String[] args) {
        ResizingQueue<String> queue = new ResizingQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(String.valueOf(i));
            System.out.println(queue.dequeue());
        }

        for (int i = 0; i < 20; i++) {
            queue.enqueue(String.valueOf(i));
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(queue.dequeue());
        }

        System.out.println();
    }

    private static class ResizingQueue<T> {
        private int first;

        private int last;

        private T[] values;

        public ResizingQueue() {
            first = 0;
            values = (T[]) new Object[10];
        }

        public ResizingQueue(int initialCapacity) {
            values = (T[]) new Object[initialCapacity < 0 ? 10 : initialCapacity];
        }

        public void enqueue(T value) {
            resizeIfNeeded();
            values[last++] = value;
        }

        public T dequeue() {
            if (size() == 0) {
                return null;
            }

            T result = values[first];
            values[first] = null;
            first++;
            return result;
        }

        private void resizeIfNeeded() {
            if (size() == values.length) {
                values = Arrays.copyOf(values, values.length * 2 + 1);
            } else if (last == values.length) {
                if (!isEmpty()) {
                    System.arraycopy(values, first, values, 0, size());
                }

                last = size();
                first = 0;
            }
        }

        private boolean shouldResize() {
            return size() == values.length || last == values.length;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return last - first;
        }
    }
}
