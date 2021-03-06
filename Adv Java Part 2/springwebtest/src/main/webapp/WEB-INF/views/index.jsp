<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value='/static/css/bootstrap.min.css'/>"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>
<body>
	<center>
		<div class="container">
			<div class="row">
				<div class="col-md-12 header">
					<div class="page-header">
						<h2>
							<img width="80px" height="80px"
								src="<c:url value='/static/images/logo.png' /> "> Welcome
							To Spring Web MVC Application
						</h2>
							<a href="logout">Logout </a>
						</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 content-area">
					<div class="col-md-4 left">
						<br /> <a href="addItemForm">Add Item Employee</a><br /> <br />
						<a href="updateItemForm">Search & Update Item</a><br /> <br />
						<a href="listItems">List Items</a><br /> <br />
					</div>
				</div>
			</div>
		</div>
	</center>
</body>
</html>
