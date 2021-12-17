package com.java.demo;

public class Voting {

	public void check(int age) throws VotingException {
		if (age < 18) {
			throw new VotingException("You are not elligible for Voting...");
		} else {
			System.out.println("You are elligible for voting...");
		}
	}
	
	public static void main(String[] args) {
		int age=21;
		Voting obj = new Voting();
		try {
			obj.check(age);
		} catch (VotingException e) {
			e.printStackTrace();
		}
	}
}
