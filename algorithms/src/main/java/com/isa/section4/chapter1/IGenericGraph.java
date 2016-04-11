package com.isa.section4.chapter1;



public interface IGenericGraph<Type> {
	
	public abstract int V();

	public abstract int E();

	public abstract void addEdge(Type v, Type w);

	public abstract Iterable<Type> adj(Type v);

	public abstract String toString();
}
