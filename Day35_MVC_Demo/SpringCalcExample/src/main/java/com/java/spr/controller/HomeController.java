package com.java.spr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/calc")
	public ModelAndView calc(HttpServletRequest request, HttpServletResponse response) {
		int firstNo, secondNo, res;
		firstNo = Integer.parseInt(request.getParameter("firstNo"));
		secondNo = Integer.parseInt(request.getParameter("secondNo"));
		res = firstNo + secondNo;
		String result="";
		result+=res;
		return new ModelAndView("calcresult", "result", result);
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("calc");
	}
}
