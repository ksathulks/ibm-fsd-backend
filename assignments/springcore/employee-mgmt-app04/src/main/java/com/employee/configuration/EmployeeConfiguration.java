package com.employee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.employee.db.EmployeeDB;
import com.employee.services.EmployeeServices;
import com.employee.structures.Employee;

@Configuration
public class EmployeeConfiguration {
	@Lazy
	@Bean
	public EmployeeServices empService() {
		return new EmployeeServices();
	}
	@Lazy
	@Bean
	public Employee emp() {
		return new Employee();
	}
	@Lazy
	@Bean
	public EmployeeDB empDB() {
		return new EmployeeDB();
	}


}