package com.java.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	static List<Student> studentList;
	
	static {
		studentList = new ArrayList<Student>();
	}
	
	public String readStudentFileDao() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("d:/files/studentfile.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		studentList = (List<Student>)objin.readObject();
		return "Data Retrieved from File...";
	}
	
	public String writeStudentFileDao() throws IOException {
		FileOutputStream fout = new FileOutputStream("d:/files/studentfile.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(studentList);
		objout.close();
		fout.close();
		return "Data Stored in File Successfully...";
	}
	
	public String deleteStudentDao(int sno) {
		Student studentFound = searchStudentDao(sno);
		if (studentFound!=null) {
			studentList.remove(studentFound);
			return "Student Record Deleted...";
		}
		return "Student Record Not Found...";
	}
	public String updateStudentDao(Student studentNew) {
		Student studentFound = searchStudentDao(studentNew.getSno());
		if (studentFound!=null) {
			for (Student student : studentList) {
				if (student.getSno()==studentNew.getSno()) {
					student.setName(studentNew.getName());
					student.setCity(studentNew.getCity());
					student.setCgp(studentNew.getCgp());
				}
			}
			return "Student Record Updated Successfully...";
		}
		return "Student Record Not Found...";
	}
	
	public Student searchStudentDao(int sno) {
		Student studentFound = null;
		for (Student student : studentList) {
			if (student.getSno()==sno) {
				studentFound=student;
			}
		}
		return studentFound;
	}
	
	public String addStudentDao(Student student) {
		studentList.add(student);
		return "Student Record Added...";
	}
	
	public List<Student> showStudentDao() {
		return studentList;
	}
}
