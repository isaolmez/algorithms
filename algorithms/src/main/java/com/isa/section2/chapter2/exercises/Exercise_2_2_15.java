package com.isa.section2.chapter2.exercises;

import com.sedgewick.stdlib.StdRandom;

import java.util.LinkedList;

public class Exercise_2_2_15 {
    public static void main(String[] args) {
        Integer[] values = new Integer[10];
        for (int i = 0; i < values.length; i++) {
            values[i] = StdRandom.uniform(1000);
        }

        LinkedList<Integer> sorted = MergeSortedQueues.sort(values);
        sorted.stream().forEachOrdered(System.out::println);

    }

    public static class MergeSortedQueues {

        public static <T extends Comparable<T>> LinkedList<T> sort(T[] values) {
            LinkedList<LinkedList<T>> masterQueue = new LinkedList<>();
            for (T value : values) {
                LinkedList<T> temp = new LinkedList<>();
                temp.offer(value);
                masterQueue.offer(temp);
            }

            while (masterQueue.size() != 1) {
                LinkedList<T> first = masterQueue.poll();
                LinkedList<T> second = masterQueue.poll();
                LinkedList<T> sorted = merge(first, second);
                masterQueue.offer(sorted);
            }

            return masterQueue.poll();
        }

        public static <T extends Comparable<T>> LinkedList<T> merge(LinkedList<T> first, LinkedList<T> second) {
            LinkedList<T> result = new LinkedList<>();
            int size = 0;
            int limit = first.size() + second.size();
            while (size < limit) {
                if (first.isEmpty()) {
                    result.offer(second.poll());
                } else if (second.isEmpty()) {
                    result.offer(first.poll());
                } else {
                    if (first.peek().compareTo(second.peek()) < 0) {
                        result.offer(first.poll());
                    } else {
                        result.offer(second.poll());
                    }
                }

                size++;
            }

            return result;
        }
    }
}
