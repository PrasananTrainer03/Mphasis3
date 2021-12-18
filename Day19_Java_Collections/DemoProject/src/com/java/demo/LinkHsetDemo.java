package com.java.demo;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkHsetDemo {

	public static void main(String[] args) {
		Set names = new LinkedHashSet();
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
		for (Object ob : names) {
			System.out.println(ob);
		}
	}
}
