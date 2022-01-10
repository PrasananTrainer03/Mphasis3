package com.java.spr.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;

import javax.sql.DataSource;
import org.springframework.jdbc.core.ResultSetExtractor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployDAO {

	private JdbcTemplate jdbcTemplate;

	public EmployDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addEmploy(Employ employ) {
		String cmd = "insert into EmployNew(empno,name,gender,dept,desig,"
				+ "basic) values(?,?,?,?,?,?)";
		 jdbcTemplate.update(cmd, employ.getEmpno(),employ.getName(),
				 employ.getGender(), 
				 employ.getDept(),employ.getDesig(),employ.getBasic());
		
	}


	public void deleteEmploy(int empno) {
		String sql = "DELETE FROM EmployNew WHERE empno=?";
	    jdbcTemplate.update(sql, empno);
	}

	public void updateEmploy(Employ employ) {
		String cmd = "Update EmployNew set name=?, Gender=?, Dept=?, Desig=?, "
				+ " Basic=? WHERE Empno=?";
		 jdbcTemplate.update(cmd, employ.getName(),
				 employ.getGender().toString(), 
				 employ.getDept(),employ.getDesig(),employ.getBasic(),
				 employ.getEmpno());
	}

	public Employ searchEmploy(int empno) {
		String sql = "select * from EmployNew where empno=?";
	    return jdbcTemplate.query(sql,new Object[] {empno}, new ResultSetExtractor<Employ>() {
	        public Employ extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Employ employ = new Employ();
		            employ.setEmpno(rs.getInt("empno"));
		            employ.setName(rs.getString("name"));
		            employ.setGender(rs.getString("gender"));
		            employ.setDept(rs.getString("dept"));
		            employ.setDesig(rs.getString("desig"));
		            employ.setBasic(rs.getInt("basic"));
		            return employ;
	            }
	 
	            return null;
	        }
	 
	    });

	}

	public List<Employ> list() {
		 String sql = "SELECT * FROM EmployNew";
		    List<Employ> listEmploy = jdbcTemplate.query(sql, new RowMapper<Employ>() {
		 
		        @Override
		        public Employ mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Employ employ = new Employ();
		 
		            employ.setEmpno(rs.getInt("empno"));
		            employ.setName(rs.getString("name"));
		            employ.setGender(rs.getString("gender"));
		            employ.setDept(rs.getString("dept"));
		            employ.setDesig(rs.getString("desig"));
		            employ.setBasic(rs.getInt("basic"));
		 
		            return employ;
		        }
		 
		    });
		 
		    return listEmploy;
	}
}
