package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantService service;
	
	@RequestMapping("/showRestaurant")
	public Restaurant[] showRestaurant() {
		return service.showRestaurant();
	}
	
	@RequestMapping("/{rid}")
	public Restaurant searchRestaurant(@PathVariable int rid) {
		return service.searchRestaurnt(rid);
	}
}
