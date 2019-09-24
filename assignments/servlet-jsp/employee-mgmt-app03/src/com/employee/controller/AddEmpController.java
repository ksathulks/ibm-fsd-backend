package com.employee.controller;

import com.employee.services.EmployeeServices;
import com.employee.structures.Employee;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value = "/addEmployee.do")
public class AddEmpController extends HttpServlet {
	EmployeeServices empService = new EmployeeServices();
	
	@Override
	public void init(ServletConfig config){
		System.out.println("Employee Addition Servlet Initialized...");
	}

	@Override
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		int empAge = Integer.parseInt(request.getParameter("empAge"));
		String empDept = request.getParameter("empDept");
		String empDesign = request.getParameter("empDesign");
		String empCountry = request.getParameter("empCountry");
		
		System.out.println("Id: " + empId);
		System.out.println("Name: " + empName);
		System.out.println("Age: " + empAge);
		System.out.println("Designation: " + empDept);
		System.out.println("Departememt: " + empDesign);
		System.out.println("Country: " + empCountry);
		
		Employee newEmp = new Employee(empId, empName, empAge, empDept, empDesign, empCountry);
		empService.addEmp(newEmp);
		System.out.println("Employee created successfully.");	
		
		RequestDispatcher rd = request.getRequestDispatcher("listEmployees.do");
		rd.forward(request, response);

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html><body>");
//		out.print("<p>Employee Addition Successful.</p>");
//		out.println("<p>empId: " + empId + "</p>");
//		out.println("<p>empName: " + empName + "</p>");
//		out.println("<p>empAge: " + empAge + "</p>");
//		out.println("<p>empDept: " + empDept + "</p>");
//		out.println("<p>empDesign: " + empDesign + "</p>");
//		out.println("<p>empCountry: " + empCountry + "</p>");		
//		out.println("<a href='index.jsp'>home</a>");
//		out.println("</body></html>");		
	}
}






