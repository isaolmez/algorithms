package com.isa.section1.chapter3.linkedlist;

import java.util.Iterator;

public class BasicLinkedList<Item> implements Iterable<Item> {

	private Node head;
	private Node tail;
	private int currentSize;

	private class Node {
		private Item item;
		private Node next;

		public Node(Item item) {
			this.item = item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public Item getItem() {
			return item;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return next;
		}
	}

	public void insertToEnd(Item item) {
		Node node = new Node(item);

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}

		currentSize++;
	}

	public void insertToStart(Item item) {
		Node node = new Node(item);

		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.setNext(head);
			head = node;
		}

		currentSize++;
	}

	public void insertToIndex(Item item, int index) {
		if (index == 0) {
			this.insertToStart(item);
		} else {
			Node traverser = null;
			for (int i = 0; i <= index - 1; i++) {
				if (i == 0) {
					traverser = head;
				} else {
					traverser = traverser.getNext();
				}

				if (traverser == null) {
					return;
				}
			}

			// Insert after (index-1)th node
			Node node = new Node(item);
			node.setNext(traverser.getNext());
			traverser.setNext(node);

			if (node.getNext() == null) {
				tail = node;
			}
		}

		currentSize++;
	}

	public Item removeFromEnd() {
		if (head == null) {
			return null;
		}

		currentSize--;
		Node oldTail = tail;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node traverser = head;
			while (traverser.getNext().getNext() != null) {
				traverser = traverser.getNext();
			}

			traverser.setNext(null);
			tail = traverser;
		}

		return oldTail.getItem();
	}

	public Item removeFromStart() {
		if (head == null) {
			return null;
		}

		currentSize--;
		Node oldHead = head;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.getNext();
		}

		return oldHead.getItem();
	}

	public int size() {
		return currentSize;
	}

	public Item peekHead() {
		return head.getItem();
	}

	public Item peekTail() {
		return tail.getItem();
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Item> {

		private Node activeNode = head;

		@Override
		public boolean hasNext() {
			return activeNode != null;
		}

		@Override
		public Item next() {
			Item result = activeNode.getItem();
			activeNode = activeNode.getNext();
			return result;
		}

	}

	public static void main(String[] args) {
		BasicLinkedList<String> linkedlist = new BasicLinkedList<String>();
		linkedlist.insertToStart("isa");
		linkedlist.insertToEnd("Olmez");
		linkedlist.insertToStart("Sayın");
		linkedlist.insertToIndex("aka", 2);
		linkedlist.insertToIndex("Crow", 3);
		for (String s : linkedlist) {
			System.out.print(s + " ");
		}

		System.out.println();
		linkedlist.removeFromEnd();
		for (String s : linkedlist) {
			System.out.print(s + " ");
		}

		System.out.println();
		linkedlist.removeFromStart();
		linkedlist.removeFromEnd();
		linkedlist.removeFromEnd();
		for (String s : linkedlist) {
			System.out.print(s + " ");
		}
	}

}
