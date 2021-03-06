<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/static/css/bootstrap.min.css'/>"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
<script src="<c:url value='/static/js/jquery-3.5.1.min.js'/>"></script>
<script src="<c:url value='/static/js/myscript.js'/>"></script>
</head>
<body>
	<h2>Item Update Form</h2>
	<form:form action="updateItem" method="post" modelAttribute="item">
		<table class="table table-striped ">
			<tr>
				<td>Item Code</td>
				<td><form:input path="itemPrice" id="itemCode" /></td>
			</tr>
			<tr>
				<td>Item Desc</td>
				<td><form:input path="itemDesc" id="itemDesc" /></td>
			</tr>
			<tr>
				<td>Item Price</td>
				<td><form:input path="itemPrice" id="itemPrice" /></td>
			</tr>
			<tr>
				<td>Quantity on Hand</td>
				<td><form:input path="qoh" id="qoh" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><form:input path="category" id="category" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update Item" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>