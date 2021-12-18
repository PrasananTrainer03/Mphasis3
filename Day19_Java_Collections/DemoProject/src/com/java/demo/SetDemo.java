package com.java.demo;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set names = new HashSet();
		names.add("Narendra");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Aswin");
		names.add("Narendra");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Narendra");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Narendra");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Aswin");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Aswin");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Aswin");
		System.out.println("Names are  ");
		for (Object ob : names) {
			System.out.println(ob);
		}
	}
}
