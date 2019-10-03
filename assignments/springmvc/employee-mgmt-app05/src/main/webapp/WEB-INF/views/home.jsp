<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Employee Management App</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container-fluid">
			<h1 class="text-center font-weight-bold">Welcome to Employee Management App</h1>
			<hr>
			<p class="text-center font-weight-bold"> Current Time: ${serverTime} </p>
			<hr>
			<div class="text-center"><a href="add" ><button class="btn btn-success">Add new Employee</button></a>
			<a href="employees"><button class="btn btn-success">View/Delete/Update Employees</button></a></div>
		</div>
	</body>
</html>