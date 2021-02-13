<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service Details</title>
</head>
<body>
<center><h2>Service Details</h2>

	<jsp:useBean id="dao" class="com.htc.service.dao.ServiceDAOImpl" />
	<table>
		<tr>
			<td><b>ServiceId</b></td>
			<td><b>ServiceDesc</b></td>
			<td><b>Price</b></td>
			<td><b>Status</b></td>
		</tr>
<!-- JSTL -->
		<c:forEach var="service" items="${dao.getAllServiceDetails()}">
			<tr>
				<td>${service.getServiceId() }</td>
				<td>${service.getServiceDesc() }</td>
				<td>${service.getPrice() }</td>
				<td>${service.getStatus() }</td>
			</tr>
		</c:forEach>
</center>
</body>
</html>