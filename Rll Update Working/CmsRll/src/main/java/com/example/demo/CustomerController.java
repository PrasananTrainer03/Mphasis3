package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/customer")
	public Customer[] showCustomer() {
		return service.showCustomer();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/customer/{cid}")
	public Customer searchCustomer(@PathVariable int cid) {
		return service.searchCustomer(cid);
	}
}
