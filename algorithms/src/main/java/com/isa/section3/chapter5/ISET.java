package com.isa.section3.chapter5;

public abstract class ISET<Key> {
	
	public ISET(){}
	
	public abstract void add(Key key);
	
	public abstract void delete(Key key);
	
	public abstract boolean contains(Key key);
	
	public abstract boolean isEmpty();
	
	public abstract int size();
	
	public abstract String toString();
}
