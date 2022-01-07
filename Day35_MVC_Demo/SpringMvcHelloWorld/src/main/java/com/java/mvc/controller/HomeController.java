package com.java.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping("/sunil")
	public ModelAndView sunil(HttpServletResponse response) throws IOException{
		return new ModelAndView("sunil");
	}
	
	@RequestMapping("/pragati")
	public ModelAndView pragati(HttpServletResponse response) throws IOException{
		return new ModelAndView("pragati");
	}

	@RequestMapping("/naren")
	public ModelAndView naren(HttpServletResponse response) throws IOException{
		return new ModelAndView("narendra");
	}

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/home")
	public ModelAndView home(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
}
