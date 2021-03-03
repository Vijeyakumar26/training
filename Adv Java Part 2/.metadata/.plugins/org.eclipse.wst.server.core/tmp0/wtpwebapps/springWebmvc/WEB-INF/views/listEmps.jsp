<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>
<body>
	<h2>Employee List</h2>
	<table class="table table-striped table-hovered">
		<tr>
			<td>Empno</td>
			<td>Empname</td>
			<td>Job</td>
			<td>Salary</td>
		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename }</td>
				<td>${emp.job}</td>
				<td>${emp.salary}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>