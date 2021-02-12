<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<%@include file="bootstraplink.jsp"%>
</head>
<body>

	<center><h2>All Users</h2></center>

	<jsp:useBean id="dao" class="com.htc.servlet.dao.UserDAOImpl" />
	<table class="table table-striped table-hovered">
		<tr>
			<td><b>Username</b></td>
			<td><b>Address</b></td>
			<td><b>Email</b></td>
			<td><b>Phone</b></td>
			<td><b>Gender</b></td>
		</tr>

		<c:forEach var="user" items="${dao.getAllUsers()}">
			<tr>
				<td>${user.getUsername()}</td>
				<td>${user.getAddress() }</td>
				<td>${user.getEmail() }</td>
				<td>${user.getContactno() }</td>
				<td>${user.getGender() }</td>
			</tr>
		</c:forEach>
</body>
</html>