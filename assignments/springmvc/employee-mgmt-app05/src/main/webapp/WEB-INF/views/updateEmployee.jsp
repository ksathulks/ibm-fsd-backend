<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Employee</title>
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
			<h1 class="text-center font-weight-bold">Update Employee</h1>
			<form:form method="POST" modelAttribute="employee" action="../update/${employee.getId()}" >					
				<div class="container">
			    			    
<!-- 				    <label for="empName"><b>Employee Name:</b></label>  -->
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
				    <button type="submit" value="Submit" class="btn btn-success">Update Employee</button> <button type="reset" value="Reset">Reset</button>
				    <a href="../"></a><button type="button" class="btn">Back</button></a>		  
				</div>			  
			</form:form>
		</div>
	</body>
</html>