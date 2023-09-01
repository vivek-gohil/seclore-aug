<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee CRUD</title>
</head>
<body>
	<h3>Update Employee</h3>
	<br>
	<f:form action="/employeecrud/saveupdatedemployee"
		modelAttribute="employee" method="post">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><f:input path="employeeId" readonly="true" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><f:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><f:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><f:input path="salary" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update Employee" /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>