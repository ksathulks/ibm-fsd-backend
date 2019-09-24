package com.employee.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.structures.Employee;
import com.employee.services.EmployeeServices;

@WebServlet("/listEmployees.do")
public class ListEmpController extends HttpServlet {

		EmployeeServices empService = new EmployeeServices();
		
		@Override
		public void init(ServletConfig config){
			System.out.println("Employee Listing Servlet Initialized...");
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Employee> empList = empService.getAll();			
			//empList.forEach(e->{System.out.println(e);});			
			req.setAttribute("empList", empList);
			
			RequestDispatcher rd = req.getRequestDispatcher("listEmployees.jsp");
			rd.forward(req, resp);
		}
}
