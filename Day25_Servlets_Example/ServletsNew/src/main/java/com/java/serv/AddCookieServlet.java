package com.java.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookieServlet
 */
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ckSarvan = new Cookie("Sarvana", "91");
		ckSarvan.setMaxAge(1000*60*60*24);
		response.addCookie(ckSarvan);
		
		Cookie ckSandhiya = new Cookie("Sandhiya", "87");
		ckSarvan.setMaxAge(1000*60*60*24);
		response.addCookie(ckSandhiya);
		
		Cookie ckBhagya = new Cookie("Bhagya", "89");
		ckSarvan.setMaxAge(1000*60*60*24);
		response.addCookie(ckBhagya);
		
		Cookie ckSrinadhi = new Cookie("Srinadhi", "98");
		ckSarvan.setMaxAge(1000*60*60*24);
		response.addCookie(ckSrinadhi);
		
		PrintWriter out = response.getWriter();
		out.println("Cookies Created...");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
