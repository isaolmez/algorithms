package com.isa.section1.chapter3.linkedlist;

public class Node<Item> {
	private Item item;
	private Node<Item> next;

	public Node(Item item) {
		this.item = item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setNext(Node<Item> next) {
		this.next = next;
	}

	public Node<Item> getNext() {
		return next;
	}
}
