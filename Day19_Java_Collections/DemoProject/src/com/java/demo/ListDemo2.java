package com.java.demo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {

	public static void main(String[] args) {
		List numbers = new ArrayList();
		numbers.add(new Integer(42));
		numbers.add(new Integer(11));
		numbers.add(new Integer(8));
		numbers.add(new Integer(23));
		numbers.add(new Integer(17));
		numbers.add(new Integer(29));
		int sum=0;
		for (Object ob : numbers) {
			sum+=(Integer)ob;
		}
		System.out.println("Sum is  " +sum);
	}
}
