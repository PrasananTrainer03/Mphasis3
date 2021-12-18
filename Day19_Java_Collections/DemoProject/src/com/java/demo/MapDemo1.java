package com.java.demo;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MapDemo1 {

	public static void main(String[] args) {
		Map data = new Hashtable();
		data.put(1, "Kalyani");
		data.put(2, "Tejaswini");
		data.put(3, "Farhana");
		data.put(4, "Kishore");
		data.put(5, "Kushal");
		data.put(6, "Hemanth");
		
		int key;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Key  ");
		key=sc.nextInt();
		String result = (String) data.getOrDefault(key, "Not Found");
		System.out.println("Result is   " +result);
	}
}
