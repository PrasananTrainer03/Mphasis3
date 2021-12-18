package com.java.gen;

enum WeekDay {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumEx1 {

	public static void main(String[] args) {
		WeekDay wd = WeekDay.WEDNESDAY;
		System.out.println(wd);
	}
}
