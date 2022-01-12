package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/")
	public String sayHello() {
		return "Welcome to SpringBoot...";
	}
	
	@RequestMapping("/kushal")
	public String kushal() {
		return "Hi I am Kushal...";
	}
	
	@RequestMapping("/pragati")
	public String pragati() {
		return "Hi I am Pragathi...";
	}
	
	@RequestMapping("/abhishek") 
	public String abhishek(){
		return "Hi I am Abhishek";
	}
	
	@RequestMapping("/greet/{name}")
	public String greeting(@PathVariable String name) {
		return "Good Evening to " +name;
	}
	
	@RequestMapping("/sum/{a}/{b}")
	public String sum(@PathVariable int a, @PathVariable int b) {
		int c=a+b;
		String res="";
		res+=c;
		return res;
	}
}
