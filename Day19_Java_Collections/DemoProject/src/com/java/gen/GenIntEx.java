package com.java.gen;

import java.util.ArrayList;

import java.util.List;

public class GenIntEx {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(42));
		numbers.add(new Integer(11));
		numbers.add(new Integer(78));
		numbers.add(new Integer(56));
		numbers.add(new Integer(34));
		numbers.add(new Integer(89));
		int sum=0;
		for (Integer i : numbers) {
			sum+=i;
		}
		System.out.println("Sum is   " +sum);
	}
}
