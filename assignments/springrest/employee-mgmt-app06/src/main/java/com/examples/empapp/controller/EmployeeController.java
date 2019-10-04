package com.examples.empapp.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeServices;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeServices empService;

	@GetMapping
	public ArrayList<Employee> getAllEmployees() {

		return empService.getAll();
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Employee getEmployee(@PathVariable int id) {
		return empService.viewEmp(id);
	}

	@PostMapping
	@CrossOrigin("*")
	public String createEmployee(@RequestBody Employee newEmp) {
		empService.addEmp(newEmp);
		return "Created Employee";
	}

	@PutMapping(value = "/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmp) {
		updatedEmp.setId(id);
		empService.updateEmp(updatedEmp);
		return "Employee Updated";

	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empService.deleteEmp(id);
		return "Employee deleted";
	}

}
