package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearch {

	public static void main(String[] args) {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No   ");
		empno=sc.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
					"training", "training");
            String cmd = "select * from EmployNew where empno=?";
            PreparedStatement pst = con.prepareStatement(cmd);
            pst.setInt(1, empno);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
				System.out.println("Employ Name   " +rs.getString("name"));
				System.out.println("Gender   " +rs.getString("gender"));
				System.out.println("Department   " +rs.getString("dept"));
				System.out.println("Designation   " +rs.getString("desig"));
				System.out.println("Basic    " +rs.getInt("basic"));
            } else {
            	System.out.println("*** Record Not Found ***");
            }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
