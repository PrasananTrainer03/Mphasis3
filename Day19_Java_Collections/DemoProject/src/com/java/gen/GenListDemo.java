package com.java.gen;

import java.util.ArrayList;
import java.util.List;

public class GenListDemo {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Narendra");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Aswin");
		System.out.println("Names are  ");
		for (String s : names) {
			System.out.println(s);
		}
	}
}
