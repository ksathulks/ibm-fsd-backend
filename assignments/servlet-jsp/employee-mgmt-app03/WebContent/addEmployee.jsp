<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
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
		<form action="addEmployee.do" method="POST">
				
			<div class="container">
			    
			    <label for="empId"><b>Employee Id:</b></label>
			    <input type="text" placeholder="Enter Id" name="empId" required>
			    
			    <label for="empName"><b>Employee Name:</b></label>
			    <input type="text" placeholder="Enter Name" name="empName" required>
			    
			    <label for="empAge"><b>Employee Age:</b></label>
			    <input type="text" placeholder="Enter Age" name="empAge" required>
			    
			    <label for="empDept"><b>Employee Department:</b></label>
			    <input type="text" placeholder="Enter Dept" name="empDept" required>
			    
			    <label for="empDesign"><b>Employee Designation:</b></label>
			    <input type="text" placeholder="Enter Designation" name="empDesign" required>
			    
			    <label for="empCountry"><b>Employee Country:</b></label>
			    <input type="text" placeholder="Enter Country" name="empCountry" required>		
			    
			    <hr>			
			    <button type="submit" value="Submit" class="btn btn-success">Add new Employee</button> <button type="reset" value="Reset">Reset</button>
			  
			</div>			  
		</form>
		</div>
	</body>
</html>