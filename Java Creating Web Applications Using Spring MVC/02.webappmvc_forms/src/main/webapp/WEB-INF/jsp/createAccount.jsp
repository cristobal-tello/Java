<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an account</title>
</head>
<body>
	<h1>Enter Account details:</h1>
	<spring-form:form commandName="aNewAccount">
		<table>
			<tr>
				<td>First name: <spring-form:input path="firstName" type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last name: <spring-form:input path="lastName" type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Address: <spring-form:input type="text" path="address" name="address" /></td>
			</tr>
			<tr>
				<td>Email: <spring-form:input type="text" path="email"  name="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create"></td>
			</tr>
		</table>
	</spring-form:form>
</body>
</html>