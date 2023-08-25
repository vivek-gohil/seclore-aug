<%@page import="com.seclore.main.domain.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee CRUD</title>
</head>
<body>
	<h2>Add New Employee</h2>
	<hr>
	<%
	Employee employee = (Employee) session.getAttribute("employee");
	%>
	<form action="UpdateEmployeeServlet" method="post">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="employeeid"
					value="<%=employee.getEmployeeId()%>"  ></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname"
					value="<%=employee.getFirstName()%>"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname"
					value="<%=employee.getLastName()%>"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"
					value="<%=employee.getSalary()%>"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Clear"></td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>