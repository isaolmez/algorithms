package com.isa.section2.chapter2.exercises;

import java.util.LinkedList;

public class Exercise_2_2_14 {
    public static void main(String[] args) {
        LinkedList<Integer> first = new LinkedList<>();
        first.offer(1);
        first.offer(3);
        first.offer(7);
        first.offer(9);

        LinkedList<Integer> second = new LinkedList<>();
        second.offer(2);
        second.offer(4);
        second.offer(5);
        second.offer(10);

        LinkedList<Integer> merged = MergeSortedQueues.merge(first, second);
        merged.stream().forEachOrdered(System.out::println);

    }

    public static class MergeSortedQueues {

        public static <T extends Comparable> LinkedList<T> merge(LinkedList<T> first, LinkedList<T> second) {
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
