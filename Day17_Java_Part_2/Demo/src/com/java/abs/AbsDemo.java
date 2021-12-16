package com.java.abs;

abstract class Training {
	abstract void name();
	abstract void email();
}

class Sarvesh extends Training {

	@Override
	void name() {
		System.out.println("Name is Sarvesh...");
	}

	@Override
	void email() {
		System.out.println("Email is sarvesh@gmail.com");
	}
	
}

class Rajasekhar extends Training {

	@Override
	void name() {
		System.out.println("Name is Rajasekhar...");
	}

	@Override
	void email() {
		System.out.println("Email is rajasekhar@gmail.com");
	}
	
}

class Prithvi extends Training {

	@Override
	void name() {
		System.out.println("Name is Prithvi...");
	}

	@Override
	void email() {
		System.out.println("Email is Prithvi@gmail.com");
	}
	
}

public class AbsDemo {
	public static void main(String[] args) {
		Training[] arr = new Training[] {
			new Prithvi(),
			new Sarvesh(),
			new Rajasekhar()
		};
		for (Training t : arr) {
			t.name();
			t.email();
		}
	}
}
