<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<%@include file="bootstraplink.jsp"%>
</head>
<body>
<center>
		<div class="container register">
			<%@include file="header.jsp"%>
			<br /> <br /> <a href="login.jsp" class=""><h3>Login</h3></a> <br/>
			<br /> <a href="searchUser.jsp" class=""><h3>Search User</h3></a> <br/>
			<br /> <a href="update.jsp" class=""><h3>Update User</h3></a> <br />
			<br /> <a href="delete.jsp" class=""><h3>Delete User</h3></a> <br />
			<br /> <a href="forEachDemo.jsp" class=""><h3>Get All Users</h3></a> <br/>
			<br />	<a href="greet.jsp" class=""><h3>Greetings</h3></a> <br/> <br/>
			<h3>New User?</h3>
			<a href='register.jsp'><h3>Register Here</h3></a> <br /> <br /> <br />
			<br />
			<%@include file="footer.jsp"%>
		</div>
	</center>
</body>
</html>