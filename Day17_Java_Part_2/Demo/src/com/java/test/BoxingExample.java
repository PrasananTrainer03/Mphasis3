package com.java.test;

public class BoxingExample {

	public static void main(String[] args) {
		int a=12;
		String str="Mphasis";
		double b=12.5;
		
		/* Implement Boxing */ 
		
		Object ob1=a;
		Object ob2=b;
		Object ob3=str;
		
		/* Implement Unboxing */ 
		int x1 = (Integer)ob1;
		double b1 = (Double)ob2;
		String s1 = (String)ob3;
		
		System.out.println("x1 value  " +x1);
		System.out.println("B1 value  " +b1);
		System.out.println("S1 value  " +s1);
	}
}
