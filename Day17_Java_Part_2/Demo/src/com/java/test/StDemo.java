package com.java.test;

public class StDemo {

	public void show() {
		System.out.println("Show Method from Demo class..");
	}
	
	public static void display() {
		System.out.println("Display Method from Demo Class..");
	}
	
	public static void main(String[] args) {
		StDemo.display();
		new StDemo().show();
	}
}
