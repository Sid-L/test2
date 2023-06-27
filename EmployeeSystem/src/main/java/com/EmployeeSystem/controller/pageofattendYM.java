package com.EmployeeSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl/YM")
public class pageofattendYM {
	
	@GetMapping
	public String displayList() {
		
		return "employeeUpdate/employee_YM.html";
	}	
}
