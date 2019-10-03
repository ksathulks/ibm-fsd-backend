package com.employee.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.services.EmployeeServices;
import com.employee.structures.Employee;

@Controller
public class UpdateEmpController {
	private static final Logger logger = LoggerFactory.getLogger(UpdateEmpController.class);
	EmployeeServices empService = new EmployeeServices();	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateEmployee(@PathVariable("id") int id, Model model) {
		logger.info("Inside UpdateEmpController RequestMethod.GET method");
		model.addAttribute("employee", empService.viewEmp(id));
		return "updateEmployee";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateEmployeeAction(@PathVariable("id") int id, @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model) {
		logger.info("Inside UpdateEmpController RequestMethod.GET method");
		System.out.println(employee.getName());
		empService.updateEmp(id, employee);
		ArrayList<Employee> empList = empService.getAll();
		model.addAttribute("empList", empList);
		return "listEmployees";
	}		
}

