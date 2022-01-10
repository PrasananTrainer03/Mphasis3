package com.java.mvc.dao;

import java.util.List;

import com.java.mvc.model.Customer;

public interface CustomerDAO {

	List<Customer> list();
	Customer searchCustomer(int custId);
	void updateCustomer(Customer customer);
}
