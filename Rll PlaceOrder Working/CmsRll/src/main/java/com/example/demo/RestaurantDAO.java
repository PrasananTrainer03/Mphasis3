package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public List<Restaurant> showRestaurant() {
		String cmd = "select * from restaurant";
		List<Restaurant> restaurantList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Restaurant restaurant = new Restaurant();
				restaurant.setRid(rs.getInt("RESTAURANTID"));
				restaurant.setRname(rs.getString("RESTAURANTNAME"));
				restaurant.setCity(rs.getString("city"));
				restaurant.setBranch(rs.getString("branch"));
				restaurant.setEmail(rs.getString("email"));
				restaurant.setContactNo(rs.getString("ContactNo"));
				return restaurant;
			}
		});
		return restaurantList;
	}
	
	public Restaurant searchRestaurant(int restaurantId) {
		String cmd = "select * from restaurant where RESTAURANTID=?";
		
		List<Restaurant> restaurantList = jdbcTemplate.query(cmd, new Object[] {restaurantId}, 
				new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Restaurant restaurant = new Restaurant();
				restaurant.setRid(rs.getInt("RESTAURANTID"));
				restaurant.setRname(rs.getString("RESTAURANTNAME"));
				restaurant.setCity(rs.getString("city"));
				restaurant.setBranch(rs.getString("branch"));
				restaurant.setEmail(rs.getString("email"));
				restaurant.setContactNo(rs.getString("ContactNo"));
				return restaurant;
			}
		});
		return restaurantList.get(0);
	}
}
 