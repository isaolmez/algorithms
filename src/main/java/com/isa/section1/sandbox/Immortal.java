package com.isa.section1.sandbox;

import java.util.Hashtable;

public class Immortal {

	/** tracks the number of times each finalizer is run */
	private static Hashtable<Integer, Integer> finalizeCounts = new Hashtable<Integer, Integer>();

	/** used to control object lifetimes */
	private static Hashtable<Integer, Immortal> pointers = new Hashtable<Integer, Immortal>();

	/** used to generate unique identifier codes */
	private static int unique = 0;

	/** deletes the object with the given id. */
	public static void kill(int id) {
		int finalizeCount = finalizeCounts.get(id);
		pointers.remove(id);
		while (finalizeCounts.get(id) == finalizeCount) {
			System.out.println("trying to kill " + id + "...");
			System.gc();
		}
	}

	// The code from these two methods can't be inlined, because
	// we rely on their stack frame disappearing to prevent the
	// link to the tracked object from persisting.

	public static int makeTemporaryObject() {
		Immortal temp = new Immortal();
		return temp.id;
	}

	public static void doSomethingWith(int id) {
		Immortal temp = pointers.get(id);
		temp.sayHello();
	}

	/** identifier code */
	private int id;

	private Immortal() {
		id = unique++;
		System.out.println("creating instance " + id);
		finalizeCounts.put(id, 0);
		pointers.put(id, this);
	}

	public void sayHello() {
		System.out.println("hi, I'm number " + id);
	}

	public void finalize() {
		System.out.println("finalizing " + id + "...");
		finalizeCounts.put(id, finalizeCounts.get(id) + 1);
		// clear! *khzh-thump*
		pointers.put(id, this);
	}

	public static void main(String[] args) {
		int id = Immortal.makeTemporaryObject();

		// This causes the finalizer to run (in the GC thread.)
		Immortal.kill(id);

		// And yet, the object is still alive!
		Immortal.doSomethingWith(id);

		// This will now loop infinitely, since the finalizer
		// will never be run a second time.
		Immortal.kill(id);
	}
}