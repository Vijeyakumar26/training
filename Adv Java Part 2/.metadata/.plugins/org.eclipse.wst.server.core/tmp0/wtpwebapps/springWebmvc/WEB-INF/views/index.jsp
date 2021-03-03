<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="<c:url value='/static/css/bootstrap.min.css'/>"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>
<body>
<center>
	<h2>Spring Web MVC Application</h2>
	<a href="addEmployeeForm">Add New Employee</a>
	<br />
	<br />
	<a href="searchEmpForm">Search & Update Employee</a>
	<br />
	<br />
	<a href="listEmps">List Employees</a>
	<br />
	<br />
	<span style="text-align:right"> <a href="logout">Logout </a></span>
</center>
</body>
</html>
