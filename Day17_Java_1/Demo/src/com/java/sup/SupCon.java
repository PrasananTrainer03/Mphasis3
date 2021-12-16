package com.java.sup;

class Employ {
	
	int empno;
	String name;
	double basic;
	
	public Employ(int empno, String name, double basic) {
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Employ [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}
}

class Lokesh extends Employ {

	public Lokesh(int empno, String name, double basic) {
		super(empno, name, basic);
	}
	
}

class Pranavi extends Employ {

	public Pranavi(int empno, String name, double basic) {
		super(empno, name, basic);
	}
	
}

class Shaik extends Employ {

	public Shaik(int empno, String name, double basic) {
		super(empno, name, basic);
		// TODO Auto-generated constructor stub
	}
	
}
public class SupCon {
	public static void main(String[] args) {
		Employ e1 = new Shaik(1, "Shaik", 92344);
		Employ e2 = new Pranavi(2, "Pranavi", 99922);
		Employ e3 = new Lokesh(3, "Lokesh", 99234);
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}
}
