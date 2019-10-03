<%@page import="com.employee.structures.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>List Employees</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
		
		 <div class="container">		 
		<h1 class="text-center font-weight-bold">LIST OF EMPLOYEES</h1>
		<% 
// 		ArrayList<Employee> empList = (ArrayList) request.getAttribute("empList");
// 		
// 		   out.print("No of employees: " + empList.size());
		 %>
		<p style="text-align:left;"><a href="add"><button class="btn btn-info">Add new Employee</button></a><span style="float:right;"><a href="/employee-mgmt-app05"><button class="btn btn-info">Home</button></a></span> </p>
		<table class="table-striped table-bordered table-hover table-dark container-fluid text-center">
			<thead class="thead-dark font-weight-bold"> 
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>AGE</td>
					<td>DESIGNATION</td>
					<td>DEPARTMENT</td>
					<td>COUNTRY</td>
					<td>UPDATE</td>
					<td>DELETE</td>
				</tr> 
			</thead>
			<tbody class="text-capitalize">
			
				<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.getId()}</td>
					<td>${emp.getName()}</td>
					<td>${emp.getAge()}</td>
					<td>${emp.getDesign()}</td>
					<td class="text-uppercase">${emp.getDept()}</td>
					<td>${emp.getCountry()}</td>
					<td><form action="/employee-mgmt-app05/update/${emp.getId()}" method="GET"><button type="submit" class="btn btn-success">Update</button></form></td>
					<td><form action="/employee-mgmt-app05/delete/${emp.getId()}" method="GET"><button type="submit" class="btn btn-danger">Delete</button></form></td>				
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		
		</div>
	</body>
</html>