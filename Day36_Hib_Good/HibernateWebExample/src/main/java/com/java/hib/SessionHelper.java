package com.java.hib;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionHelper {

	public static SessionFactory getFactory() {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		return sf;
	}
}
