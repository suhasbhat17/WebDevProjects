<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Page</title>
</head>
<body>
	<h3>Please enter the student details</h3>
	<form:form action="${pageContext.request.contextPath}/doCreate"
		method="post" commandName="stud">
		<table>
			
			<tr>
				<td>Name:</td>
				<td><form:input type="text" name="name" path="name" /><br />
					<span><form:errors path="name" /></td></span>
			</tr>
			<tr>
				<td>email:</td>
				<td><form:input type="text" name="email" path="email" /><br />
					<form:errors path="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>