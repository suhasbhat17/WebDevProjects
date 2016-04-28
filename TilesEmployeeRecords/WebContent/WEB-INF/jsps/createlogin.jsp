<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<h3>Please Enter the Sign Up Information</h3>
	<form:form action="${pageContext.request.contextPath}/doSignUp" method="post" commandName="user">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input type="text" name="username" path="username" /><br /> <form:errors
						path="username" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" name="email" path="email" /><br />
					<form:errors path="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" name="password" path="password" /><br />
					<form:errors path="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="confirm" /><br /></td>
			</tr>
			<tr>
			
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>