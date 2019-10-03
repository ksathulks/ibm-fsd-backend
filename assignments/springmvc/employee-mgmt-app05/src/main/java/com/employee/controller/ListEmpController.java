package com.employee.controller;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.structures.Employee;
import com.employee.services.EmployeeServices;

@Controller
public class ListEmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(ListEmpController.class);

		EmployeeServices empService = new EmployeeServices();
		
		@RequestMapping(value = "/employees", method = RequestMethod.GET)
		public String listEmployee(Model model) {
			logger.info("Inside ListEmpController");
			ArrayList<Employee> empList = empService.getAll();
			model.addAttribute("empList", empList);
			model.addAttribute("emp", new Employee());
			return "listEmployees";
		}
}
