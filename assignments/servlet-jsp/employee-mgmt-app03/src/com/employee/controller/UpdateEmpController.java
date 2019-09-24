package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.services.EmployeeServices;
import com.employee.structures.Employee;

@WebServlet(value = "/updateEmployee.do")
	public class UpdateEmpController extends HttpServlet {
	EmployeeServices empService = new EmployeeServices();
	String id;
	
		@Override
		public void init(ServletConfig config){
			System.out.println("Employee Updation Servlet Initialized...");
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			id=req.getParameter("empId");			
			RequestDispatcher rd = req.getRequestDispatcher("updateEmployee.jsp");
			rd.forward(req, resp);
	//		this.doPost(req, resp);
		}
	
		@Override
		public void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {			
			int empId=Integer.parseInt(id);
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
			
			if(empService.viewEmp(empId).getId()==empId) {
				Employee newEmp = new Employee(empId, empName, empAge, empDept, empDesign, empCountry);
				empService.updateEmp(empId, newEmp);
				System.out.println("Employee updated successfully.");			
				RequestDispatcher rd2 = request.getRequestDispatcher("listEmployees.do");
				rd2.forward(request, response);							
			}else {
				System.out.println("given empId doesn't exist");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html><body>");
				out.print("<p>given empId doesn't exist.</p>");		
				out.println("<a href='index.jsp'>home</a>");
				out.println("</body></html>");
			}
		}		
}

