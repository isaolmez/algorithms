package com.isa.section1.sandbox;


public class FinalizeTest {
	static DieHard[] objects = new DieHard[3];

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			objects[i] = new DieHard(i);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("\nLoop: " + i);
			for (DieHard d : objects) {
				System.out.print(d);
				System.out.print(" ");
			}

			System.out.println();
			System.out.println("Garbage collecting!!!");
			objects = new DieHard[3];
			System.gc();
			Thread.sleep(100);
		}

	}

}

class DieHard {
	private String name = "isa";
	private int i;

	public DieHard(int i) {
		this.name = name + i;
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void finalize() {
		FinalizeTest.objects[i] = this;
		System.out.println("Not dead bitch! Reviving...");
	}

	public String toString() {
		return name;
	}
}
