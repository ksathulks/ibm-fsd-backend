<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Employee</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<style type="text/css">
			* {box-sizing: border-box}

			.container {
			  padding: 10px;
			}

			input[type=text] {
			  width: 100%;
			  padding: 10px;
			  margin: 5px 0 15px 0;
			  display: inline-block;
			  border: none;
			  background: #f1f1f1;
			}
		</style>
	</head>
	<body>
	<div class="container-fluid">
		<h1 class="text-center font-weight-bold">Add New Employee</h1>
		<form:form method="POST" modelAttribute="employee" action="save">
				
			<div class="container">
			    
<!-- 			    <label for="empId"><b>Employee Id:</b></label> -->
			    <form:input type="text" placeholder="Enter Id" path="id"/>
			    
<!-- 			    <label for="empName"><b>Employee Name:</b></label> -->
			    <form:input type="text" placeholder="Enter Name" path="name" />
			    
<!-- 			    <label for="empAge"><b>Employee Age:</b></label> -->
			    <form:input type="text" placeholder="Enter Age" path="age" />
			    
<!-- 			    <label for="empDept"><b>Employee Department:</b></label> -->
			    <form:input type="text" placeholder="Enter Dept" path="dept" />
			    
<!-- 			    <label for="empDesign"><b>Employee Designation:</b></label> -->
			    <form:input type="text" placeholder="Enter Designation" path="design" />
			    
<!-- 			    <label for="empCountry"><b>Employee Country:</b></label> -->
			    <form:input type="text" placeholder="Enter Country" path="country" />		
			    
			    <hr>			
			    <button type="submit" class="btn btn-success">Add new Employee</button> <button type="reset" value="Reset">Reset</button>
			     <a href="/employee-mgmt-app05">Back</a>
			  
			</div>			  
		</form:form>
		</div>
	</body>
</html>