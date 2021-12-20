package com.java.files;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		File f1 = new File("D:/Mphasis3/Java/Day4/StudentProject/src/com/java/project/Student.java");
		System.out.println("File Name   " +f1.getName());
		System.out.println("Full Name   " +f1.getPath());
		System.out.println("Parent Directory   " +f1.getParent());
	}
}
