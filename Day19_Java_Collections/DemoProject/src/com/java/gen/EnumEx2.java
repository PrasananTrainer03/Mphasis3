package com.java.gen;

import java.util.Scanner;

enum OrderStatus {
	PENDING, ACCEPTED, REJECTED
}

public class EnumEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Order Status  ");
		String status = sc.next();
		OrderStatus ordStatus = OrderStatus.valueOf(status);
		System.out.println(ordStatus);
	}
}
