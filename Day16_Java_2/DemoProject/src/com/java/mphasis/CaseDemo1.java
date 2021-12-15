package com.java.mphasis;

public class CaseDemo1 {

	public void show(int choice) {
		switch(choice) {
		case 1 : 
			System.out.println("Hi I am Shiva...");
			break;
		case 2 : 
			System.out.println("Hi I am Lokesh...");
			break;
		case 3 : 
			System.out.println("Hi I am Sunil...");
			break;
		case 4 : 
			System.out.println("HI I am Bhaskar...");
			break;
		case 5 : 
			System.out.println("Hi I am Hemanth...");
			break;
		default : 
			System.out.println("Invalid Choice...");
			break;
		}
	}
	public static void main(String[] args) {
		int choice=4;
		CaseDemo1 obj = new CaseDemo1();
		obj.show(choice);
	}
}
