<%@page import="com.htc.servlet.bo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search</title>
<%@include file="bootstraplink.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<br>
	<jsp:useBean id="userDAO" class="com.htc.servlet.dao.UserDAOImpl" />

	<%
		String username = request.getParameter("uname");

		User user = userDAO.getUser(username);
		if (user != null) {
	%>
	<center>
	<table>
		<tr>
			<td><h3>Username</h3></td>
			<td><h3><%=user.getUsername()%></h3></td>

		</tr>
		<tr>
			<td><h3>Address</h3></td>
			<td><h3><%=user.getAddress()%></h3></td>
		</tr>
		<tr>
			<td><h3>Email</h3></td>
			<td><h3><%=user.getEmail()%></h3></td>
		</tr>
		<tr>
			<td><h3>Phone</h3></td>
			<td><h3><%=user.getContactno()%></h3></td>
		</tr>
			<tr>
			<td><h3>Gender</h3></td>
			<td><h3><%=user.getGender()%></h3></td>
		</tr>
	</table>
	</center>
	<%
		}
		else
		{
	%>
	<h2>Invalid Username. User doesnt exist!!</h2>
	<%		
	}
%>
<br>
	<br>
	<br>
	<br>
<%@include file="footer.jsp"%>
</body>
</html>