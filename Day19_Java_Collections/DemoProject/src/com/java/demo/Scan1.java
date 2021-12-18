package com.java.demo;

import java.util.Scanner;

public class Scan1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 Numbers   ");
		int a,b,c;
		a=sc.nextInt();
		b=sc.nextInt();
		c=a+b;
		System.out.println("Sum is  " +c);
	}
}
