package com.java.demo;

public class ThrEx {

	public void show(int n) {
		if (n < 0) {
			throw new NumberFormatException("Negative Numbers Not Allowed...");
		} else if (n == 0) {
			throw new ArithmeticException("Zero is Invalid Value...");
		} else {
			System.out.println("N value is   " +n);
		}
	}
	
	public static void main(String[] args) {
		int n=0;
		ThrEx obj = new ThrEx();
		try {
			obj.show(n);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
