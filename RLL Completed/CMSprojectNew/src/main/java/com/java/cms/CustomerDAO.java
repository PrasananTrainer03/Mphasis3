package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

	
	
	Connection connection;
	PreparedStatement pst;
	public List<Customer> showCustomer() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer = null;
		while(rs.next()) {
			customer = new Customer();
			customer.setCustomerid(rs.getInt("customerid"));
			customer.setCustomername(rs.getString("customername"));
			customer.setCustomercity(rs.getString("customercity"));
			customer.setCustomerstate(rs.getString("customerstate"));
			customer.setCustomeremail(rs.getString("customeremail"));
			customer.setCustomermobile(rs.getString("customermobile"));
			customerList.add(customer);
		}
		return customerList;
	}

	public Customer searchCustomer(int customerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from customer where customerid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerId);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		if(rs.next()) {
			customer = new Customer();
			customer.setCustomerid(rs.getInt("customerid"));
			customer.setCustomername(rs.getString("customername"));
			customer.setCustomercity(rs.getString("customercity"));
			customer.setCustomerstate(rs.getString("customerstate"));
			customer.setCustomeremail(rs.getString("customeremail"));
			customer.setCustomermobile(rs.getString("customermobile"));
		}
		return customer;
		
	}
	
	
	
	
	
	
}
