package com.java.demo;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmploy {

	public static void main(String[] args) {
		// Comparator c = new NameComparator();
		Comparator c = new BasicComparator();
		SortedSet employs = new TreeSet(c);
		employs.add(new Employ(1, "Kushal", 90442));
		employs.add(new Employ(2, "Abhishek", 89422));
		employs.add(new Employ(3, "Praveen", 95422));
		employs.add(new Employ(4, "Bala", 99422));
		employs.add(new Employ(5, "Tejasree", 79422));
		employs.add(new Employ(6, "Bhaskar", 85422));
		employs.add(new Employ(7, "Sunil", 98333));
		employs.add(new Employ(8, "Farhana", 87644));
		System.out.println("Employ List   ");
		for (Object ob : employs) {
			System.out.println(ob);
		}
	}
}
