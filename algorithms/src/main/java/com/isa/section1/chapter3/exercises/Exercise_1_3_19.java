package com.isa.section1.chapter3.exercises;

import java.util.Iterator;

public class Exercise_1_3_19 {
	public static void main(String[] args) {
		ExerciseLinkedList<String> list = new ExerciseLinkedList<>();
		list.insertToEnd("a");
		list.insertToEnd("s");
		list.insertToEnd("d");
		list.insertToEnd("f");
		list.insertToEnd("f");
		list.insertToEnd("f");
		for (String s : list) {
			System.out.print(s);
		}
		
		System.out.println();
		list.deleteAtIndex(2);
		for (String s : list) {
			System.out.print(s);
		}
		
		System.out.println();
		list.remove("f");
		for (String s : list) {
			System.out.print(s);
		}
		
	}
}

/**
 * Used For:
 * 
 * Exercise_1_3_19 
 * Exercise_1_3_20
 * Exercise_1_3_26
 * 
 * */
class ExerciseLinkedList<Item> implements Iterable<Item> {
	private Node head;

	private class Node {
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	/**
	 * Exercise_1_3_19
	 */
	public void deleteLast() {
		if (head == null) {
			return;
		}

		Node traverser = head;
		while (true) {
			if (traverser.next == null) {
				head = null;//head = head.next;
				break;
			} else if (traverser.next.next == null) {
				traverser.next = null;
				break;
			}

			traverser = traverser.next;
		}
	}

	/**
	 * Exercise_1_3_20 Delete node with index k or (k+1)th node.
	 */
	public void deleteAtIndex(int k) {
		if (head == null) {
			return;
		}

		if (k == 0) {
			head = head.next;
			return;
		}

		// Find the node with index (k-1)
		Node traverser = null;
		for (int i = 0; i <= k - 1; i++) {
			if (i == 0) {
				traverser = head;
			} else {
				traverser = traverser.next;
			}

			if (traverser == null) {
				return;
			}
		}

		if (traverser != null && traverser.next != null) {
			traverser.next = traverser.next.next;
		}

	}

	/**
	 * Exercise_1_3_26 Delete node with index k or (k+1)th node.
	 */
	public void remove(Item key) {
		if (head == null) {
			return;
		}

		Node traverser = head;
		Node nextToTraverser = null;

		// Traverser is not allowed to be null
		while (true) {
			if (traverser.item.equals(key)) {
				// Structural changes
				if (nextToTraverser != null) {
					nextToTraverser.next = traverser.next;
				}else{
					head = head.next;
				}
				
				// A little trick
				traverser = nextToTraverser;
			}
			
			// Update 2 references
			if (traverser.next != null) {
				nextToTraverser = traverser;
				traverser = traverser.next;
			} else {
				break;
			}
		}
		
		// Traverser is allowed to be null
//		while (true) {
//			if(traverser == null){
//				break;
//			}
//			
//			if (traverser.item.equals(key)) {
//				if (nextToTraverser != null) {
//					nextToTraverser.next = traverser.next;
//					traverser = traverser.next;
//				}else{
//					head = head.next;
//					traverser = traverser.next;
//				}
//			} else {
//				nextToTraverser = traverser;
//				traverser = traverser.next;
//			} 
//		}

	}

	public void insertToEnd(Item item) {
		if (head == null) {
			head = new Node(item);
			return;
		}

		Node traverser = head;
		while (traverser.next != null) {
			traverser = traverser.next;
		}

		traverser.next = new Node(item);
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
			Item result = activeNode.item;
			activeNode = activeNode.next;
			return result;
		}

	}
}
