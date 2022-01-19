package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendorService {

	@Autowired
	VendorDAO dao;
	
	public Vendor[] showVendor() {
		List<Vendor> vendorList = dao.showVendor();
		return vendorList.toArray(new Vendor[vendorList.size()]);
	}
	
	public Vendor searchVendor(int vendorId) {
		return dao.searchVendor(vendorId);
	}
}
