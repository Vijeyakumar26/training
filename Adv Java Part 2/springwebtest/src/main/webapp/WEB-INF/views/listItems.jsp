<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items List</title>
<link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>
<body>
	<h2>Items List</h2>
	<table class="table table-striped table-hovered">
		<tr>
			<td>Item Code</td>
			<td>Item Desc</td>
			<td>Item Price</td>
			<td>Qoh</td>
			<td>Category</td>
		</tr>
		<c:forEach var="item" items="${itemList}">
			<tr>
				<td>${item.itemCode}</td>
				<td>${item.itemDesc }</td>
				<td>${item.itemPrice}</td>
				<td>${item.qoh}</td>
				<td>${item.category}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>