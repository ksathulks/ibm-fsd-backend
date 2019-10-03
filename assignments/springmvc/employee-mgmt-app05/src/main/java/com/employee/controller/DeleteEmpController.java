package com.employee.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.services.EmployeeServices;
import com.employee.structures.Employee;

@Controller
public class DeleteEmpController {	

	private static final Logger logger = LoggerFactory.getLogger(DeleteEmpController.class);
	EmployeeServices empService = new EmployeeServices();	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String updateEmployee(@PathVariable("id") int id, Model model) {
		logger.info("Inside DeleteEmpController");
		empService.deleteEmp(id);
		ArrayList<Employee> empList = empService.getAll();
		model.addAttribute("empList", empList);
		model.addAttribute("emp", new Employee());
		return "listEmployees";
	}
}
