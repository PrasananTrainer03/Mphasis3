package com.java.mphasis;

public class StrExamples {

	public void show() {
		String str="Welcome to Java Programming...From Prasanna...";
		System.out.println("Length of String is  " +str.length());
		System.out.println("First occurrence of char 'o' is " +str.indexOf("c"));
		System.out.println("Char at 5th position  " +str.charAt(5));
		System.out.println("Lower Case String is  " +str.toLowerCase());
		System.out.println("Upper Case String is  " +str.toUpperCase());
		String s1="Hemanth",s2="Aswin",s3="Hemanth";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
	}
	public static void main(String[] args) {
		StrExamples obj =  new StrExamples();
		obj.show();
	}
}
