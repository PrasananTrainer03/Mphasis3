package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantService {

	@Autowired
	RestaurantDAO dao;
	
	public Restaurant[] showRestaurant() {
		List<Restaurant> rlist = dao.showRestaurant();
		return rlist.toArray(new Restaurant[rlist.size()]);
	}
	
	public Restaurant searchRestaurnt(int restaurantId) {
		return dao.searchRestaurant(restaurantId);
	}
}
