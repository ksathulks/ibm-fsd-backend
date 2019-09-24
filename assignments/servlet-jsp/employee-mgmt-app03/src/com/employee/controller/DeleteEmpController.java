package com.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.services.EmployeeServices;

@WebServlet(value = "/deleteEmployee.do")
public class DeleteEmpController extends HttpServlet {
EmployeeServices empService = new EmployeeServices();
	
	@Override
	public void init(ServletConfig config){
		System.out.println("Employee Deletion Servlet Initialized...");
	}

	@Override
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		empService.deleteEmp(empId);
		RequestDispatcher rd = request.getRequestDispatcher("listEmployees.do");
		rd.forward(request, response);
	}
}
