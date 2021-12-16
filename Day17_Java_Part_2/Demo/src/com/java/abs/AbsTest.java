package com.java.abs;

abstract class Vehicle {
	abstract void name();
	abstract void capacity();
	abstract void milage();
}

class Car extends Vehicle {

	@Override
	void name() {
		System.out.println("Its I20 Car...");
	}

	@Override
	void capacity() {
		System.out.println("CC 1200...");
	}

	@Override
	void milage() {
		System.out.println("Its 13 Kms");
	}
}

class Bike extends Vehicle {

	@Override
	void name() {
		System.out.println("Duke Bike...");
	}

	@Override
	void capacity() {
		System.out.println("200 C.C.");
	}

	@Override
	void milage() {
		System.out.println("Its 30kms...");
	}
	
}

public class AbsTest {
	public static void main(String[] args) {
		Vehicle[] arr = new Vehicle[] {
			new Bike(),
			new Car()
		};
		
		for (Vehicle v : arr) {
			v.name();
			v.milage();
			v.capacity();
		}
	}
}
