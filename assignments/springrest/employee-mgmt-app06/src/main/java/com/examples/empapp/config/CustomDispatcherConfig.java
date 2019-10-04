package com.examples.empapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.examples.empapp.dao.EmployeeDB;
import com.examples.empapp.service.EmployeeServices;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class CustomDispatcherConfig {

	@Bean
	public Connection connection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training",
					"training");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Lazy
	@Bean
	public EmployeeServices empService() {
		return new EmployeeServices();
	}

	@Lazy
	@Bean
	public EmployeeDB empDao() {
		return new EmployeeDB();
	}

}
