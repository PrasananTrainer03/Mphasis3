package com.example.demo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public List<Vendor> showVendor() {
		String cmd = "select * from Vendor";
		List<Vendor> vendorList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor vendor = new Vendor();
				vendor.setVendorid(rs.getInt("vendorid"));
				vendor.setVendorname(rs.getString("vendorname"));
				vendor.setVendorcity(rs.getString("vendorcity"));
				vendor.setVendorstate(rs.getString("vendorstate"));
				vendor.setVendoremail(rs.getString("vendoremail"));
				vendor.setVendormobile(rs.getString("vendormobile"));
				return vendor;
			}
		});
		return vendorList;
	}

	public Vendor searchVendor(int vendorId)  {
		String cmd = "select * from vendor where vendorid=?";
		List<Vendor> vendorList = jdbcTemplate.query(cmd, 
				new Object[] {vendorId},
				new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor vendor = new Vendor();
				vendor = new Vendor();
				vendor.setVendorid(rs.getInt("vendorid"));
				vendor.setVendorname(rs.getString("vendorname"));
				vendor.setVendorcity(rs.getString("vendorcity"));
				vendor.setVendorstate(rs.getString("vendorstate"));
				vendor.setVendoremail(rs.getString("vendoremail"));
				vendor.setVendormobile(rs.getString("vendormobile"));
				return vendor;
			}
		});
		return vendorList.get(0);

	}
	
	

}
