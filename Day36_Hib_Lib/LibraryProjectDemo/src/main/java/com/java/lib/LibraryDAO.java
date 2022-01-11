package com.java.lib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LibraryDAO {

	static SessionFactory sessionFactory;
	static Session session;
	static Query query;

	static {
		sessionFactory = SessionHelper.getFactory();
		session = sessionFactory.openSession();
	}
	
	public List<Books> searchBooks(String searchtype, String searchvalue) {

		if (searchtype.equals("id"))
			query = session.createQuery("from Books where id=" + Integer.parseInt(searchvalue));
		else if (searchtype.equalsIgnoreCase("dept"))
			query = session.createQuery("from Books where dept='" + searchvalue + "'");

		else if (searchtype.equalsIgnoreCase("bookname"))
			query = session.createQuery("from Books where name='" + searchvalue + "'");

		else if (searchtype.equalsIgnoreCase("authorname"))
			query = session.createQuery("from Books where author='" + searchvalue + "'");
		else
			query = session.createQuery("from Books where name!='" + searchvalue + "' or 1=1");

		List<Books> lst = query.list();

		if (lst.isEmpty())
			return null;
		else
			return lst;

	}


	
	public int loginCheck(LibUsers lib) {
		query = session.createQuery(
				"from LibUsers where username='" 
						+ lib.getUserName() + "' and password='" 
						+ lib.getPassWord() + "'");
		List<LibUsers> lst = query.list();
		if (lst.isEmpty()) {
			return 0; }
		else {
			return 1; }

	}

}
