<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee CRUD</title>
</head>
<body>
	<h3>Employee CRUD</h3>
	<hr>
	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Salary</th>
			<th colspan="2">Action</th>
		</tr>

		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.employeeId }</td>
				<td>${employee.firstName }</td>
				<td>${employee.lastName}</td>
				<td>${employee.salary }</td>
				<td><a href="deleteemployee/${employee.employeeId }">Delete</a></td>
				<td><a href="updateemployee/${employee.employeeId }">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="newemployee">Add New Employee</a>
</body>
</html>