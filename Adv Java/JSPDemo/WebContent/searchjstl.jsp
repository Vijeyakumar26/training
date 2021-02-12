<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="com.htc.servlet.bo.User"%>
<%@page import="com.htc.servlet.dao.UserDAOImpl"%>
<%@page import="com.htc.servlet.dao.UserDAO" %>   

<%@page errorPage="error.jsp" %>    
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search JSTL</title>
</head>
<%@include file="bootstraplink.jsp"%>
<body>
	<%@include file="header.jsp"%><br>
	<jsp:useBean id="userDAO" class="com.htc.servlet.dao.UserDAOImpl" />

	<%
		String username = request.getParameter("uname");

		User user = userDAO.getUser(username);
		request.setAttribute("user", user);
	%>
	<c:choose>
		<c:when test="${user ne null }">
		<center>
			<table class="container table table-striped table-hovered">
				<tr>
					<td><b>Username</b></td>
					<td><%=user.getUsername()%></td>
				</tr>
				<tr>
					<td><b>Address</b></td>
					<td><%=user.getAddress()%></td>
				</tr>
				<tr>
					<td><b>Email</b></td>
					<td><%=user.getEmail()%></td>
				</tr>
				<tr>
					<td><b>ContactNo</b></td>
					<td><%=user.getContactno()%></td>
				</tr>
				<tr>
					<td><b>Gender</b></td>
					<td><%=user.getGender()%></td>
				</tr>
			</table>
		</center>
	</c:when>
		
		<c:otherwise>
		<div class = "container alert alert-danger">
			<center><h2>Invalid Username. User doesn't exist!!</h2></center>
		</div>
		</c:otherwise>
		
	</c:choose><br><br><br><br>
	<%@include file="footer.jsp"%>
</body>
</html>