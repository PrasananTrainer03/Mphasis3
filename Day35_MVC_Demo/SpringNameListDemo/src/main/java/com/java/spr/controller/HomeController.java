package com.java.spr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/namelist")
	public ModelAndView showNames() {
		List<String> names = new ArrayList<String>();
		names.add("Rachana");
		names.add("Prithvi");
		names.add("Sarvesh");
		names.add("Pragati");
		names.add("Narendra");
		names.add("Kalyani");
		return new ModelAndView("nameshow","names",names);
	}
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
}
