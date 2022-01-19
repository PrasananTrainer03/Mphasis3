package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public List<Menu> showMenu(int restaurantId) {
		String cmd = "select * from menu where RESTAURANTID=?";
		List<Menu> menuList = jdbcTemplate.query(cmd, 
				new Object[] {restaurantId}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Menu menu = new Menu();
						menu.setMenuId(rs.getInt("menuid"));
						menu.setRestaurantId(rs.getInt("restaurantid"));
						menu.setItemName(rs.getString("itemname"));
						menu.setMenutype(rs.getString("menutype"));
						menu.setCalories(rs.getInt("calories"));
						menu.setPrice(rs.getInt("Price"));
						return menu;
					}
		});
		return menuList;
	}
	
	public Menu searchMenu(int menuId)  {
		String cmd = "select * from menu where menuid=?";
		List<Menu> menuList = jdbcTemplate.query(cmd, 
				new Object[] {menuId}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Menu menu = new Menu();
						menu.setMenuId(rs.getInt("menuid"));
						menu.setRestaurantId(rs.getInt("restaurantid"));
						menu.setItemName(rs.getString("itemname"));
						menu.setMenutype(rs.getString("menutype"));
						menu.setCalories(rs.getInt("calories"));
						menu.setPrice(rs.getInt("Price"));
						return menu;
					}
		});
		return menuList.get(0);
	}
}
