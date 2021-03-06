<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item</title>
	<link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>
<body>
<center>
	<h1>Add Item</h1>
	<form:form action="addItem" method="post" modelAttribute="item">
	<table class="table table-striped">
	<tr><td><h5>Item Code</h5></td><td><form:input path="itemCode"/></td></tr>
	<tr><td><h5>Item Desc</h5></td><td><form:input path="itemDesc"/></td></tr>
	<tr><td><h5>Item Price</h5></td><td><form:input path="itemPrice"/></td></tr>
	<tr><td><h5>Quantity on Hand</h5></td><td><form:input path="qoh"/></td></tr>
	<tr><td><h5>Category</h5></td><td><form:input path="category"/></td></tr>
	<tr><td colspan="2"><input type="submit" class= "btn btn-primary" value ="Add Item"/></td></tr>
	</table>
	</form:form>
</center>
</body>
</html>