package com.java.test;

public class BoxTest {

	public void show(Object ob) {
		String type = ob.getClass().getSimpleName();
		System.out.println(type);
		
		if (type.equals("Integer")) {
			System.out.println("Integer Casting...");
			int x = (Integer)ob;
			System.out.println("X value  " +x);
		}
		
		if (type.equals("String")) {
			System.out.println("String Casting...");
			String x = (String)ob;
			System.out.println("String Value  " +x);
		}
		
		if (type.equals("Double")) {
			System.out.println("Double Casting...");
			Double x = (Double)ob;
			System.out.println("Double Value  " +x);
		}
	}
	
	public static void main(String[] args) {
		int a=12;
		double  b=12.5;
		String str="Bala";
		BoxTest obj = new BoxTest();
		obj.show(a);
		obj.show(b);
		obj.show(str);
	}
}
