package com.java.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmploySearchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empno;
		System.out.println("Enter Employ No   ");
		empno = sc.nextInt();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from EmployNew where empno="+empno);
		List<EmployNew> employList = query.list();
		if (employList.size()==1) {
			System.out.println(employList.get(0));
		} else {
			System.out.println("*** Record Not Found ***");
		}
	}
}
