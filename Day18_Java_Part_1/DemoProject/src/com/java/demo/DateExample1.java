package com.java.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample1 {

	public void show(Date dt) {
		System.out.println(dt);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Date is  " +sdf.format(dt));
	}
	public static void main(String[] args) {
		Date dt = new Date();
		DateExample1 obj1 = new DateExample1();
		obj1.show(dt);
	}
}
