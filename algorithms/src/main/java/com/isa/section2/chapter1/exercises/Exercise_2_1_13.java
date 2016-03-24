package com.isa.section2.chapter1.exercises;

import com.isa.section2.chapter1.Shell;
import com.sedgewick.stdlib.StdRandom;

public class Exercise_2_1_13 {
	public static void main(String[] args) {
		Card[] deck = new Card[52];
		String[] suits = { "spades", "hearts", "clubs", "diamonds" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		for (int i = 0; i < suits.length; i++) {
			for (int k = 0; k < ranks.length; k++) {
				deck[i * 13 + k] = new Card(suits[i], ranks[k]);
			}
		}

		StdRandom.shuffle(deck);
		Shell.sort(deck);
		Shell.show(deck);
	}
}

class Card implements Comparable<Card> {
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
			return "0";
		} else if (suit.equals("hearts")) {
			return "1";
		} else if (suit.equals("clubs")) {
			return "2";
		} else if (suit.equals("diamonds")) {
			return "3";
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
