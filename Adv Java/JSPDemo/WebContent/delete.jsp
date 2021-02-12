<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="bootstraplink.jsp"%>
</head>
<body>
<br>
<%@include file="header.jsp"%><br><br>	
<div class ="container">
	<h2>Delete User</h2><br><br>
	<form action="deleteUser" method="post">
	<h4>Enter username : </h4><input type="text" class="form-control" name="uname"/> 
	<br/>
	<input type="submit" class ="btn btn-danger" value="Delete"/>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<%@include file="footer.jsp"%>
</body>
</html>