<%@page import="java.util.ArrayList"%>
<%@page import="com.seclore.main.domain.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.seclore.main.service.EmployeeService"%>
<%@page import="com.seclore.main.service.EmployeeServiceInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee CRUD</title>
</head>
<body>
	<h2>Employee CRUD</h2>
	<hr>
	<%!EmployeeServiceInterface employeeService = new EmployeeService();%>
	<h3>All Employees</h3>
	<table border="1">
		<tr>
			<th>Employee id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Salary</th>
			<th colspan="2">Action</th>
		</tr>
		<%
		List<Employee> employeeList = new ArrayList();
		employeeList = employeeService.getAllEmployees();
		for (Employee employee : employeeList) {
		%>
		<tr>
			<td><%=employee.getEmployeeId()%></td>
			<td><%=employee.getFirstName()%></td>
			<td><%=employee.getLastName()%></td>
			<td><%=employee.getSalary()%></td>
			<td><a
				href=<%="DeleteEmployeeServlet?employeeId=" + employee.getEmployeeId()%>>Delete</a></td>
			<td><a
				href=<%="UpdateEmployeeServlet?employeeId=" + employee.getEmployeeId()%>>Update</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<a href="addnewemployee.html">Add New Employee</a>
</body>
</html>