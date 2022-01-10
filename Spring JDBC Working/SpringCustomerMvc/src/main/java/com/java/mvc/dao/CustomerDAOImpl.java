package com.java.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.java.mvc.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> list() {
		 String sql = "SELECT * FROM Customer";
		    List<Customer> customerList = jdbcTemplate.query(sql, new RowMapper<Customer>() {
		 
		        @Override
		        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Customer customer = new Customer();
		            customer.setCustomerId(rs.getInt("CUSTOMERID"));
		            customer.setCustomerName(rs.getString("CUSTOMERNAME"));
		            customer.setCustomerCity(rs.getString("CUSTOMERCITY"));
		            customer.setCustomerState(rs.getString("CUSTOMERSTATE"));
		            customer.setCustomerEmail(rs.getString("CUSTOMEREMAIL"));
		            customer.setCustomerMobile(rs.getString("CUSTOMERMOBILE"));
		            return customer;
		        }
		 
		    });
		 
		    return customerList;

	}

	private JdbcTemplate jdbcTemplate;
	
	public CustomerDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Customer searchCustomer(int custId) {
		String sql = "select * from Customer where CustomerID=?";
	    return jdbcTemplate.query(sql,new Object[] {custId}, new ResultSetExtractor<Customer>() {
	        public Customer extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Customer customer = new Customer();
		            customer.setCustomerId(rs.getInt("CUSTOMERID"));
		            customer.setCustomerName(rs.getString("CUSTOMERNAME"));
		            customer.setCustomerCity(rs.getString("CUSTOMERCITY"));
		            customer.setCustomerState(rs.getString("CUSTOMERSTATE"));
		            customer.setCustomerEmail(rs.getString("CUSTOMEREMAIL"));
		            customer.setCustomerMobile(rs.getString("CUSTOMERMOBILE"));
		            return customer;
	            }
	 
	            return null;
	        }
	 
	    });

	}

	@Override
	public void updateCustomer(Customer customer) {
		String cmd = "Update Customer set CustomerName=?, CustomerState=?, "
				+ " CustomerCity=?, CustomerEmail=?, CustomerMobile=? where "
				+ " CustomerId=?";
		jdbcTemplate.update(cmd, new Object[] {customer.getCustomerName(), 
				customer.getCustomerState(), 
				customer.getCustomerCity(), customer.getCustomerEmail(), 
				customer.getCustomerMobile(), customer.getCustomerId()
			});
	}
	
}
