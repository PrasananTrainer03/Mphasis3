package com.java.gen;

import java.util.ArrayList;
import java.util.List;

public class GenListEmploy {

	public static void main(String[] args) {
		List<Employ> employs = new ArrayList<Employ>();
		employs.add(new Employ(1, "Kushal", 99422));
		employs.add(new Employ(2, "Abhishek", 99422));
		employs.add(new Employ(3, "Praveen", 99422));
		employs.add(new Employ(4, "Bala", 99422));
		employs.add(new Employ(5, "Tejasree", 99422));
		employs.add(new Employ(6, "Bhaskar", 99422));
		employs.add(new Employ(7, "Sunil", 99422));
		employs.add(new Employ(8, "Farhana", 99422));
		
		System.out.println("Employ List  ");
		for (Employ e : employs) {
			System.out.println(e);
		}
	}
}
