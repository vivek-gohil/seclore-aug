<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>
</head>
<body>
	<h3>Spring MVC Login Application</h3>
	<hr>

	<f:form action="loginaction" modelAttribute="userDetails">
		<table>
			<tr>
				<td>Login Id</td>
				<td><f:input path="userId" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><f:input path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</f:form>
	<%-- 	<form action="loginaction" method="post"> --%>
	<!-- 		<table> -->
	<!-- 			<tr> -->
	<!-- 				<td>Login Id</td> -->
	<!-- 				<td><input type="text" name="loginid"></td> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Password</td> -->
	<!-- 				<td><input type="password" name="password"></td> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td></td> -->
	<!-- 				<td><input type="submit" value="Login"></td> -->
	<!-- 			</tr> -->
	<!-- 		</table> -->
	<%-- 	</form> --%>
</body>
</html>