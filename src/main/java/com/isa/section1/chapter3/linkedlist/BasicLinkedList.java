package com.isa.section1.chapter3.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.isa.section1.chapter3.stack.BasicStack;

public class BasicLinkedList<Item> implements Iterable<Item> {

	private Node<Item> head;
	private Node<Item> tail;
	private int currentSize;

	public void insertToEnd(Node<Item> node) {
		if (node == null) {
			return;
		}

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}

		currentSize++;
	}

	public void insertToStart(Node<Item> node) {
		if (node == null) {
			return;
		}

		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.setNext(head);
			head = node;
		}

		currentSize++;
	}

	public void insertToIndex(Node<Item> node, int index) {
		if (node == null) {
			return;
		}

		if (head == null) {
			head = node;
			tail = node;
		}

		if (index == 0) {
			this.insertToStart(node);
		} else {
			Node<Item> temp = head;
			for (int i = 0; i < index - 1; i++) {
				if (temp.getNext() != null) {
					temp = temp.getNext();
				}
			}

			node.setNext(temp.getNext());
			temp.setNext(node);

			if (node.getNext() == null) {
				tail = node;
			}
		}

		currentSize++;
	}

	public Node<Item> removeFromEnd() {
		if (head == null) {
			return null;
		}

		currentSize--;
		Node<Item> oldTail = tail;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node<Item> temp = head;
			while (temp.getNext() != null) {
				if (temp.getNext().getNext() == null) {
					break;
				}

				temp = temp.getNext();
			}

			temp.setNext(null);
			tail = temp;
		}

		return oldTail;
	}

	public Node<Item> removeFromStart() {
		if (head == null) {
			return null;
		}

		currentSize--;
		Node<Item> oldHead = head;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.getNext();
		}

		return oldHead;
	}

	public int size() {
		return currentSize;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Item> {

		private Node<Item> activeNode = head;

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
		linkedlist.insertToStart(new Node<String>("isa"));
		linkedlist.insertToEnd(new Node<String>("Olmez"));
		linkedlist.insertToStart(new Node<String>("Sayın"));
		linkedlist.insertToIndex(new Node<String>("aka"), 2);
		linkedlist.insertToIndex(new Node<String>("Crow"), 3);
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

		List list = new ArrayList<String>();
		BasicStack<String>[] arr = (BasicStack<String>[]) new BasicStack[1];

	}

}
