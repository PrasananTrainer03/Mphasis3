package com.java.mphasis;

public class ArrStrings {

	public void show() {
		String[] arr = new String[] {
			"Tejasree","Aswin",
			"Bhaskar","Tejasree","Uday"
		};
		for (String s : arr) {
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		ArrStrings obj = new ArrStrings();
		obj.show();
	}
}
