package com.java.demo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {

	public static void main(String[] args) {
		List names =  new ArrayList();
		names.add("Narendra");
		names.add("Abhishek");
		names.add("Kushal");
		names.add("Pragati");
		names.add("Aswin");
		System.out.println("Names are   ");
		for (Object ob : names) {
			System.out.println(ob);
		}
		names.add(3, "Kishore");
		System.out.println("Names after adding new One");
		for (Object ob : names) {
			System.out.println(ob);
		}
		names.set(5, "Pravin");
		System.out.println("Names after Updating...");
		for (Object ob : names) {
			System.out.println(ob);
		}
		names.remove("Pragati");
		System.out.println("Names after Delete...");
		for (Object ob : names) {
			System.out.println(ob);
		}
	}
}
