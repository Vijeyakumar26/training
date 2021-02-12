<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>searchUser</title>
<%@include file="bootstraplink.jsp"%>
</head>
<body>
	<br><br>
	<%@include file="header.jsp"%>
	<br>
	<br>
	
	<div class = "container"> 
		<form action="searchjstl.jsp" method="get">
	
		<h4>Enter username :</h4> <input type="text" class="form-control" name="uname" /> <br/><br/>
		<input type="submit"  class ="btn btn-primary" value="Search User" />
	
	</form>
	</div>
	<br />
	<br />
	<br />
	<%@include file="footer.jsp"%>
</body>
</html>