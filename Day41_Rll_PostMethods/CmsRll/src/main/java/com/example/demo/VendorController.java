package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

	@Autowired
	VendorService service;
	
	@RequestMapping("/vendors")
	public Vendor[] showVendor() {
		return service.showVendor();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/vendorSearch/{vid}")
	public Vendor searchVendor(@PathVariable int vid) {
		return service.searchVendor(vid);
	}

}
