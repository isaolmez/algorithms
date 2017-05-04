package com.isa.section2.chapter1.exercises;

import com.sedgewick.stdlib.StdRandom;

import java.util.Arrays;
import java.util.LinkedList;

public class Exercise_2_1_14 {
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        String[] suits = {"spades", "hearts", "clubs", "diamonds"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < suits.length; i++) {
            for (int k = 0; k < ranks.length; k++) {
                deck[i * 13 + k] = new Card(suits[i], ranks[k]);
            }
        }

        StdRandom.shuffle(deck);
        LinkedList<Card> deckList = new LinkedList<>();
        Arrays.stream(deck).forEachOrdered(card -> deckList.addLast(card));
        DequeueSort.sort(deckList);
        for (Card card : deckList) {
            System.out.printf("%s ", card);
        }
    }

    public static class DequeueSort {
        public static void sort(LinkedList<Card> deck) {
            int round = 0;
            int totalRounds = deck.size() - 1;
            while (round <= totalRounds) {
                for (int i = 0; i < deck.size() - 1 - round; i++) {
                    Card top = deck.removeFirst();
                    Card below = deck.removeFirst();
                    if (less(top, below)) {
                        deck.addLast(below);
                        deck.addFirst(top);
                    } else {
                        deck.addLast(top);
                        deck.addFirst(below);
                    }
                }
                for (int i = 0; i <= round; i++) {
                    deck.addLast(deck.removeFirst());
                }

                round++;
            }
        }

        public static boolean less(Comparable first, Comparable second) {
            return first.compareTo(second) < 0;
        }
    }

    public static class Card implements Comparable<Card> {
        private String suit;
        private String rank;
        private String internalKey;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
            this.internalKey = internalKey();
        }

        @Override
        public int compareTo(Card o) {
            if (this == o) {
                return 0;
            }

            return this.internalKey.compareTo(o.internalKey);
        }

        public String toString() {
            return suit.toUpperCase() + "-" + rank;
        }

        private String internalKey() {
            return internalSuit() + internalRank();
        }

        private String internalSuit() {
            if (suit.equals("spades")) {
                return "4";
            } else if (suit.equals("hearts")) {
                return "3";
            } else if (suit.equals("clubs")) {
                return "1";
            } else if (suit.equals("diamonds")) {
                return "2";
            } else {
                return null;
            }
        }

        private String internalRank() {
            if (rank.equals("10")) {
                return "91";
            } else if (rank.equals("J")) {
                return "92";
            } else if (rank.equals("Q")) {
                return "93";
            } else if (rank.equals("K")) {
                return "94";
            } else if (rank.equals("A")) {
                return "95";
            } else {
                return rank;
            }
        }
    }
}
