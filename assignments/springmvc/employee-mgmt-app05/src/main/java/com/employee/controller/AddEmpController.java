package com.employee.controller;

import com.employee.services.EmployeeServices;
import com.employee.structures.Employee;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddEmpController {	
	private static final Logger logger = LoggerFactory.getLogger(AddEmpController.class);
	EmployeeServices empService= new EmployeeServices();
	
	@ModelAttribute("employee")
	public Employee employee() {
		return new Employee();
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		logger.info("Inside AddEmpController RequestMethod.GET method");
		//model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model, Locale locale) {
		logger.info("Inside AddEmpController RequestMethod.POST method");
		System.out.println(employee.getName());
		empService.addEmp(employee);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );		
		return "home";
	}
		
		
	
}






