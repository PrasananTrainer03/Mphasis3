package com.java.intf;

interface ITraining {
	void name();
	void email();
}

class Shiva implements ITraining {

	@Override
	public void name() {
		System.out.println("Name is Shiva...");
	}

	@Override
	public void email() {
		System.out.println("Email is Shiva@gmail.com");
	}
	
}

class Sarvana implements ITraining {

	@Override
	public void name() {
		System.out.println("Name is Sarvana...");
	}

	@Override
	public void email() {
		System.out.println("Email is sarvana@gmail.com");
	}
	
}
public class IntfEx {
	public static void main(String[] args) {
		ITraining[] arr = new ITraining[] {
			new Sarvana(),
			new Shiva()
		};
		for (ITraining i : arr) {
			i.name();
			i.email();
		}
	}
}
