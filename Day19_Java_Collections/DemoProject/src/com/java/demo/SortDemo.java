package com.java.demo;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortDemo {

	public static void main(String[] args) {
		SortedSet names = new TreeSet();
		names.add("Narendra");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Saranya");
		names.add("Pragati");
		names.add("Farhana");
		names.add("Josephine");
		names.add("Aswin");
		
		System.out.println("Sorted Names are  ");
		for (Object ob : names) {
			System.out.println(ob);
		}
	}
}
