package com.java.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account account = new Account();
		System.out.println("Enter FirstName   ");
		account.setFirstName(sc.next());
		System.out.println("Enter LastName   ");
		account.setLastName(sc.next());
		System.out.println("Enter City   ");
		account.setCity(sc.next());
		System.out.println("Enter State   ");
		account.setState(sc.next());
		System.out.println("Enter Amount   ");
		account.setAmount(sc.nextInt());
		System.out.println("Enter CheqFacil   ");
		account.setCheqFacil(sc.next());
		System.out.println("Enter Account Type  ");
		account.setAccountType(sc.next());
		AccountDAO dao = new AccountDAO();
		try {
			System.out.println(dao.createAccount(account));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
