package com.java.lib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LibraryDAO {

	static SessionFactory sessionFactory;
	static Session session;
	static Query query;

	static {
		sessionFactory = SessionHelper.getFactory();
		session = sessionFactory.openSession();
	}
	
	public List<TranBook> issuedBooks(String userName) {
		query = session.createQuery("from TranBook where userName='" + userName + "'");
		List<TranBook> lst = query.list();
		return lst;
		
	}
	
	public void issueBook(TranBook tb) {
		int id = generateTranId();
		tb.setTid(id);

		Transaction t = session.beginTransaction();
		session.save(tb);
		t.commit();

		t=session.beginTransaction();
		query = session.createQuery("from Books where id=" + tb.getBookId());
		List<Books> lst = query.list();

		// Transaction t1 = s.beginTransaction();
//		t.begin();
		Books b1 = new Books();
		if (lst.size() > 0) {
			for (Books b2 : lst) {
				b1 = b2;
				// b2.setTotalbooks(b2.getTotalbooks() - 1);

			}
			b1.setTotalBooks(b1.getTotalBooks() - 1);
		}

		session.update(b1);
		t.commit();
		
	}


	public int generateTranId() {
		Query q = session.createQuery("select max(tid) from TranBook");
		int id=0;
		List<Object> list= q.list();
		Object ob = list.get(0);
		if (ob==null) {
			return 1;
		} else {
			//Object ob = list.get(0);
			int x =(Integer)ob;
			x++;
			return x;
		}
	}

	public String issuedOrNot(String user, int bid) {

		query = session.createQuery("from TranBook where userName='" + user + "' and bookId=" + bid);
		List<TranBook> lst = query.list();

		if (!lst.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
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
