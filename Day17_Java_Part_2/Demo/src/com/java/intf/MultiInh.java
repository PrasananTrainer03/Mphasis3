package com.java.intf;

interface IOne {
	void name();
}

interface ITwo {
	void email();
}

class First implements IOne, ITwo {

	@Override
	public void email() {
		System.out.println("Email is rachana@gmail.com");
	}

	@Override
	public void name() {
		System.out.println("Name is Rachana...");
	}
	
}
public class MultiInh {
	public static void main(String[] args) {
		First obj = new First();
		obj.name();
		obj.email();
	}
}
