package com.java.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployDeleteMain {

	public static void main(String[] args) {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No    ");
		empno = sc.nextInt();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from EmployNew where empno="+empno);
		List<EmployNew> employList = query.list();
		if (employList.size()==1) {
			session.delete(employList.get(0));
			t.commit();
			System.out.println("*** Record Deleted ***");
		} else {
			System.out.println("*** Record Not Found ***");
		}
	}
}
