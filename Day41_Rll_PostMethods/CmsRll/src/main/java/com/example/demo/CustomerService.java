package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerDAO dao;
	
	public Customer[] showCustomer() {
		List<Customer> customerList = dao.showCustomer();
		return customerList.toArray(new Customer[customerList.size()]);
	}
	
	public Customer searchCustomer(int custId) {
		return dao.searchCustomer(custId);
	}
}
