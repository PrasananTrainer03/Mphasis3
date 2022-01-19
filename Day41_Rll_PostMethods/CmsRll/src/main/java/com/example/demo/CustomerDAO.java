package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;

	public List<Customer> showCustomer()  {
		String cmd = "select * from Customer";
		List<Customer> customerList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setCustomerid(rs.getInt("customerid"));
				customer.setCustomername(rs.getString("customername"));
				customer.setCustomercity(rs.getString("customercity"));
				customer.setCustomerstate(rs.getString("customerstate"));
				customer.setCustomeremail(rs.getString("customeremail"));
				customer.setCustomermobile(rs.getString("customermobile"));
				return customer;
			}
		});
		return customerList;
	}

	public Customer searchCustomer(int customerId) {
		String cmd = "select * from Customer where customerId=?";
		List<Customer> customerList = jdbcTemplate.query(cmd, 
				new Object[] {customerId},
				new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setCustomerid(rs.getInt("customerid"));
				customer.setCustomername(rs.getString("customername"));
				customer.setCustomercity(rs.getString("customercity"));
				customer.setCustomerstate(rs.getString("customerstate"));
				customer.setCustomeremail(rs.getString("customeremail"));
				customer.setCustomermobile(rs.getString("customermobile"));
				return customer;
			}
		});
		return customerList.get(0);
		
	}
}
