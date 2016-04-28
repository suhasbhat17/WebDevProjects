<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<h2>Welcome Employees</h2>
	<p>
	<table>
		<tr>
			<td><a href="${pageContext.request.contextPath}/read">Show all Records</a></td>
			
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/create">Insert New Record</a></td>
			
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/update">Update existing Record</a></td>
			
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/delete">Delete existing Record</a></td>
			
		</tr>
		<tr>
		
			<td><a href="<c:url value='/j_spring_security_logout'/>">Log out</a></td>
			
		</tr>

	</table>