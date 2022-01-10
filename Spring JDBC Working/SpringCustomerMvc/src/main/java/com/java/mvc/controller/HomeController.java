package com.java.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.mvc.dao.CustomerDAO;
import com.java.mvc.model.Customer;

@Controller
public class HomeController {

	@Autowired
	CustomerDAO  dao;
	
	 @RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
	 public ModelAndView updateCustomer(@ModelAttribute Customer customer) {
	     dao.updateCustomer(customer);
	     return new ModelAndView("redirect:/");
	 }

	 @RequestMapping(value="/editcustomer")
		public ModelAndView editCustomer(HttpServletRequest request) {
		    int custId = Integer.parseInt(request.getParameter("custid"));
		    Customer customer = dao.searchCustomer(custId);
		    return new ModelAndView("customersearchform", "customer", customer);
		}
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		  List<Customer> listCustomer = dao.list();

		return new ModelAndView("home","listCustomer",listCustomer);

	}
}
