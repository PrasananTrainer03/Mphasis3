package com.java.demo;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MapDemo2 {

	public static void main(String[] args) {
		Map data = new Hashtable();
		data.put("Kushal", 99542.44);
		data.put("Kishore", 89044.23);
		data.put("Aswin", 89088.43);
		data.put("Bala", 98834.33);
		data.put("Pradeep", 87889.44);
		data.put("Hemanth", 88894.33);
		data.put("Lokesh", 89994.23);
		Scanner sc = new Scanner(System.in);
		String key;
		System.out.println("Enter Key (name)  ");
		key = sc.next();
		double res = (Double)data.getOrDefault(key, 0.0);
		System.out.println("Result is   " +res);
	}
}
