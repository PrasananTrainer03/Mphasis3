package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployShowAllMain {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from EmployNew");
		List<EmployNew> employList = query.list();
		for (EmployNew employNew : employList) {
			System.out.println(employNew);
		}
	}
}
