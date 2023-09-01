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
	<h3>Add New Employee</h3>
	<br>
	<f:form action="saveemployee" modelAttribute="employee" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td><f:input path="firstName" /> <f:errors path="firstName" />
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><f:input path="lastName" /> <f:errors path="lastName" />
				</td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><f:input path="salary" /> <f:errors path="salary" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Employee" /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>