package com.java.demo;

import java.util.ArrayList;
import java.util.List;

public class ListEmploy {

	public static void main(String[] args) {
		List employs = new ArrayList();
		employs.add(new Employ(1, "Kushal", 99422));
		employs.add(new Employ(2, "Abhishek", 99422));
		employs.add(new Employ(3, "Praveen", 99422));
		employs.add(new Employ(4, "Bala", 99422));
		employs.add(new Employ(5, "Tejasree", 99422));
		employs.add(new Employ(6, "Bhaskar", 99422));
		employs.add(new Employ(7, "Sunil", 99422));
		employs.add(new Employ(8, "Farhana", 99422));
		
		for (Object ob : employs) {
			Employ employ = (Employ)ob;
			System.out.println(employ);
		}
	}
}
