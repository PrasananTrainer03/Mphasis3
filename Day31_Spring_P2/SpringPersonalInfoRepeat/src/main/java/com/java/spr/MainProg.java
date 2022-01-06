package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Person.xml");
		Person person = (Person)ctx.getBean("beanJyoshna");
		person.showAllInfo();
		
		Person personBhaskar = (Person)ctx.getBean("beanBhaskar");
		personBhaskar.showAllInfo();
		
		Person personJosephine = (Person)ctx.getBean("beanJosephine");
		personJosephine.showAllInfo();
	}
}
