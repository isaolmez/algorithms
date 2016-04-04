package com.isa.section3.chapter2;

import com.isa.section1.chapter3.queue.Queue;
import com.isa.section3.chapter1.OrderedST;

public class BST<Key extends Comparable<Key>, Value> extends OrderedST<Key, Value> {
	private Node root;

	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		int nodeCount;

		Node(Key key, Value value, Node left, Node right, int nodeCount) {
			this.key = key;
			this.value = value;
			this.right = right;
			this.left = left;
			this.nodeCount = nodeCount;
		}

		Node(Key key, Value value, int nodeCount) {
			this(key, value, null, null, nodeCount);
		}

		Node(Key key, Value value) {
			this(key, value, 0);
		}
	}

	@Override
	public void put(Key key, Value value) {
		if (isEmpty()) {
			root = new Node(key, value, 1);
			return;
		}

		putRecursive(key, value, root);
	}

	private void putRecursive(Key key, Value value, Node subRoot) {
		if (key.compareTo(subRoot.key) == 0) {
			subRoot.value = value; // Modification
		} else if (key.compareTo(subRoot.key) < 0) {
			if (subRoot.left != null) {
				putRecursive(key, value, subRoot.left);
			} else {
				subRoot.left = new Node(key, value, 1);// Insertion
			}

			subRoot.nodeCount = getNodeCount(subRoot.left) + getNodeCount(subRoot.right) + 1;
		} else {
			if (subRoot.right != null) {
				putRecursive(key, value, subRoot.right);
			} else {
				subRoot.right = new Node(key, value, 1);// Insertion
			}

			subRoot.nodeCount = getNodeCount(subRoot.left) + getNodeCount(subRoot.right) + 1;
		}
	}

	@Override
	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}

		return getRecursive(key, root);
	}

	private Value getRecursive(Key key, Node subRoot) {
		if (subRoot == null) {
			return null;
		}

		if (key.compareTo(subRoot.key) == 0) {
			return subRoot.value;
		} else if (key.compareTo(subRoot.key) < 0) {
			return getRecursive(key, subRoot.left);
		} else {
			return getRecursive(key, subRoot.right);
		}
	}

	private Value getIterative(Key key) {
		Node traverser = root;
		while (traverser != null) {
			if (key.compareTo(traverser.key) == 0) {
				return traverser.value;
			} else if (key.compareTo(traverser.key) < 0) {
				traverser = traverser.left;
			} else {
				traverser = traverser.right;
			}
		}

		return null;
	}

	@Override
	public void delete(Key key) {

	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return getNodeCount(root);
	}

	@Override
	public Key min() {
		if (isEmpty()) {
			return null;
		}

		return min(root);
	}

	private Key min(Node subRoot) {
		if (subRoot.left == null) {
			return subRoot.key;
		} else {
			return min(subRoot.left);
		}
	}

	@Override
	public Key max() {
		if (isEmpty()) {
			return null;
		}

		return max(root);
	}

	private Key max(Node subRoot) {
		if (subRoot.right == null) {
			return subRoot.key;
		} else {
			return max(subRoot.right);
		}
	}

	@Override
	public Key floor(Key key) {
		if (isEmpty()) {
			return null;
		}

		return floor(key, root);
	}

	private Key floor(Key key, Node subRoot) {
		if (subRoot == null) {
			return null;
		}

		if (key.compareTo(subRoot.key) == 0) {
			return subRoot.key;
		} else if (key.compareTo(subRoot.key) < 0) {
			return floor(key, subRoot.left);
		} else {
			Key temp = floor(key, subRoot.right);
			if (temp != null) {
				return temp;
			} else {
				return subRoot.key;
			}
		}
	}

	private void floorAlternative(Key key, Node subRoot, Key floor) {
		if (subRoot == null) {
			return;
		} else if (key.compareTo(subRoot.key) == 0) {
			floor = subRoot.key;
			return;
		} else if (key.compareTo(subRoot.key) > 0) {
			floor = subRoot.key;
			floorAlternative(key, subRoot.right, floor);
		} else if (key.compareTo(subRoot.key) < 0) {
			floorAlternative(key, subRoot.left, floor);
		}
	}

	@Override
	public Key ceiling(Key key) {
		if (isEmpty()) { // Fast exit, but redundant
			return null;
		}

		return ceiling(key, root);
	}

	private Key ceiling(Key key, Node subRoot) {
		if (subRoot == null) {
			return null;
		}

		if (key.compareTo(subRoot.key) == 0) {
			return subRoot.key;
		} else if (key.compareTo(subRoot.key) > 0) {
			return ceiling(key, subRoot.right);
		} else {
			Key temp = ceiling(key, subRoot.left);
			if (temp != null) {
				return temp;
			} else {
				return subRoot.key;
			}
		}
	}

	private void ceilingAlternative(Key key, Node subRoot, Key ceiling) {
		if (subRoot == null) {
			return;
		}

		if (key.compareTo(subRoot.key) == 0) {
			ceiling = subRoot.key;
			return;
		} else if (key.compareTo(subRoot.key) > 0) {
			ceilingAlternative(key, subRoot.right, ceiling);
		} else if (key.compareTo(subRoot.key) < 0) {
			ceiling = subRoot.key;
			ceilingAlternative(key, subRoot.left, ceiling);
		}
	}

	@Override
	public int rank(Key key) {
		if (isEmpty()) {
			return -1;
		}

		return rank(key, root);
	}

	private int rank(Key key, Node subRoot) {
		if (subRoot == null) {
			return -1;
		} else if (key.compareTo(subRoot.key) == 0) {
			return getNodeCount(subRoot.left);
		} else if (key.compareTo(subRoot.key) < 0) {
			return rank(key, subRoot.right) + getNodeCount(subRoot.left) + 1;
		} else { // if (subRoot.key.compareTo(key) > 0) {
			return rank(key, subRoot.left);
		}
	}

	private int getNodeCount(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.nodeCount;
		}
	}

	@Override
	public Key select(int k) {
		if (isEmpty() || k < 0 || k >= root.nodeCount) {
			return null;
		}

		return select(k, root);
	}

	private Key select(int k, Node subRoot) {
		if (getNodeCount(subRoot.left) == k) {
			return subRoot.key;
		} else if (k > getNodeCount(subRoot.left)) {
			return select(k - getNodeCount(subRoot.left) - 1, subRoot.right);
		} else {
			return select(k, subRoot.left);
		}
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size(Key lo, Key hi) {
		return getNodeCount(root);
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		return null;
	}

	@Override
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		if (!isEmpty()) {
			keys(queue, root);
		}

		return queue;
	}

	private void keys(Queue<Key> queue, Node subRoot) {
		if (subRoot == null) {
			return;
		}

		keys(queue, subRoot.left);
		queue.enqueue(subRoot.key);
		keys(queue, subRoot.right);
	}

}
