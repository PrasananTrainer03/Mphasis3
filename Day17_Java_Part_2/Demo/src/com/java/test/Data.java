package com.java.test;

public class Data {

	int custId;
	String custName;
	double premium;
	
	@Override
	public String toString() {
		return "Data [custId=" + custId + ", custName=" + custName + ", premium=" + premium + "]";
	}

	public static void main(String[] args) {
		Data obj1 = new Data();
		obj1.custId=1;
		obj1.custName="Pragati";
		obj1.premium=88424;
		
		System.out.println(obj1);
	}
}
