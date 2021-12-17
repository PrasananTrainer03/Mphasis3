package com.java.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample2 {

	public void show(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(strDate);
		System.out.println(dt);
	}
	public static void main(String[] args) {
		String strDate = "2021-12-17";
		DateExample2 obj = new DateExample2();
		try {
			obj.show(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
