package com.java.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountMain {

	public static void main(String[] args) {
		int accountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No    ");
		accountNo = sc.nextInt();
		AccountDAO dao = new AccountDAO();
		try {
			Account account = dao.searchAccount(accountNo);
			if (account!=null) {
				System.out.println(account);
			} else {
				System.out.println("*** AccountNo Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
