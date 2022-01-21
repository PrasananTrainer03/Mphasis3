package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/orderSearch/{orderid}")
	public Orders orderSearch(@PathVariable int orderid) {
		return service.searchByOrderId(orderid);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/acceptOrRejectOrder/{ordId}/{venId}/{status}")
	public String acceptOrReject(@PathVariable int ordId,@PathVariable int venId,
	@PathVariable String status) {
	return service.acceptOrRejectOrder(ordId, venId, status);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/orders/placeOrder")
	public String add(@RequestBody Orders orders) {
	return service.placeOrder(orders);
	}
}
