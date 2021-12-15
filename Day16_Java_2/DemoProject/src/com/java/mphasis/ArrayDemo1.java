package com.java.mphasis;

public class ArrayDemo1 {

	public void show() {
		int[] a=new int[] {4,42,66,23,31};
//		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i]);
//		}
		for (int i : a) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		ArrayDemo1 obj = new ArrayDemo1();
		obj.show();
	}
}
