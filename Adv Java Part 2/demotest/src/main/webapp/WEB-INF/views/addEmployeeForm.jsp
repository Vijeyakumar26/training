<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
	<link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>
<body>
<center>
	<h1>Employee Form</h1>
	<form:form action="addEmployee" method="post" modelAttribute="emp">
	<table class="table table-striped">
	<tr><td><h5>Employee ID</h5></td><td><form:input path="empno"/></td></tr>
	<tr><td><h5>Employee Name</h5></td><td><form:input path="ename"/></td></tr>
	<tr><td><h5>Designation</h5></td><td><form:input path="job"/></td></tr>
	<tr><td><h5>Salary</h5></td><td><form:input path="salary"/></td></tr>
	<tr><td colspan="2"><input type="submit" class= "btn btn-primary" value ="Register Employee"/></td></tr>
	</table>
	</form:form>
</center>
</body>
</html>