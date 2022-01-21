package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

	@Autowired
	MenuService service;
	
	@RequestMapping("/showMenu/{rid}")
	public Menu[] showMenu(@PathVariable int rid) {
		return service.showMenu(rid);
	}
	
	@RequestMapping("/search/{menuId}")
	public Menu searchMenu(@PathVariable int menuId) {
		return service.searchMenu(menuId);
	}
}
