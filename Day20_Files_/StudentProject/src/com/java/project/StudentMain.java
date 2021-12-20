package com.java.project;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	static Scanner sc = new Scanner(System.in);
	
	static StudentBAL studentBal;
	
	static {
		studentBal = new StudentBAL();
	}
	
	public static void writeStudentFile() throws IOException {
		System.out.println(studentBal.writeStudentFileBal());
	}
	
	public static void readStudentFile() throws ClassNotFoundException, IOException {
		System.out.println(studentBal.readStudentFileBal());
	}
	public static void deleteStudent() {
		int sno;
		System.out.println("Enter Student No  ");
		sno = sc.nextInt();
		System.out.println(studentBal.deleteStudentBal(sno));
	}

	
	public static void searchStudent() {
		int sno;
		System.out.println("Enter Student No  ");
		sno = sc.nextInt();
		Student student = studentBal.searchStudentBal(sno);
		if (student==null) {
			System.out.println("Student Record Not Found...");
		} else {
			System.out.println(student);			
		}
	}
	public static void showStudent() {
		List<Student> studentList = studentBal.showStudentBal();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
	public static void addStudent() throws StudentException {
		Student student = new Student();
		System.out.println("Enter Student No   ");
		student.setSno(sc.nextInt());
		System.out.println("Enter Student Name   ");
		student.setName(sc.next());
		System.out.println("Enter City   ");
		student.setCity(sc.next());
		System.out.println("Enter Cgp   ");
		student.setCgp(sc.nextDouble());
		System.out.println(studentBal.addStudentBal(student));
	}
	
	public static void updateStudent() throws StudentException {
		Student student = new Student();
		System.out.println("Enter Student No   ");
		student.setSno(sc.nextInt());
		System.out.println("Enter Student Name   ");
		student.setName(sc.next());
		System.out.println("Enter City   ");
		student.setCity(sc.next());
		System.out.println("Enter Cgp   ");
		student.setCgp(sc.nextDouble());
		System.out.println(studentBal.updateStudentBal(student));
	}

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println(" O P T I O N S");
			System.out.println(" -------------");
			System.out.println("1. Add Student");
			System.out.println("2. Show Student");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Write Student File");
			System.out.println("7. Read Student File");
			System.out.println("8. Exit");
			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				try {
					addStudent();
				} catch (StudentException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2 : 
				showStudent();
				break;
			case 3 : 
				searchStudent();
				break;
			case 4 : 
				try {
					updateStudent();
				} catch (StudentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5 : 
				deleteStudent();
				break;
			case 6 : 
				try {
					writeStudentFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7 : 
				try {
					readStudentFile();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}while(choice!=8);
	}
}
