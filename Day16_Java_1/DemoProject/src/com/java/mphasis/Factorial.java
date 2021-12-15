package com.java.mphasis;

public class Factorial {

	public void calc(int n) {
		int f=1,i=1;
		while(i <= n) {
			f=f*i;
			i++;
		}
		System.out.println("Factorial Value " +f);
	}
	public static void main(String[] args) {
		int n=8;
		Factorial obj = new Factorial();
		obj.calc(n);
	}
}
