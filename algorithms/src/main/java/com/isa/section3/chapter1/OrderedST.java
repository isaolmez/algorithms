package com.isa.section3.chapter1;

public abstract class OrderedST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
	public abstract Key min();

	public abstract Key max();

	public abstract Key floor(Key key);

	public abstract Key ceiling(Key key);

	public abstract int rank(Key key);

	public abstract Key select(int k);

	public abstract void deleteMin();

	public abstract void deleteMax();

	public abstract int size(Key lo, Key hi);

	public abstract Iterable<Key> keys(Key lo, Key hi);
}
