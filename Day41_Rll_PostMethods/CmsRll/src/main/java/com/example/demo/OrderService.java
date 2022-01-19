package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrdersDAO dao;
	
	
	public Orders searchByOrderId(int orderId) {
		return dao.searchOrder(orderId);
	}
	
	public String placeOrder(Orders orders) {
		return dao.placeOrder(orders);
	}
	
	public String acceptOrRejectOrder(int orderId, int vendorId, String status) {
		return dao.acceptOrRejectOrder(orderId, vendorId, status);
	}
}
