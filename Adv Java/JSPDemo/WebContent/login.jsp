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
	<%@include file="header.jsp"%>
	<br>
	<br>
	<center>
		<div class="container formContent">
			<form action="login" method="post">
				<h4>Username :</h4>
				<input type="username" class="form-control" name="uname" /> <br />

				<h4>Password :</h4>
				<input type="password" class="form-control" name="pwd" /> <br /> <br />
				<input type="submit" class="btn btn-primary" value="Login" /> <br />
			</form>
		</div>
	</center>
	<br />
	<br />
	<br />
	<br />
	<%@include file="footer.jsp"%>

</body>
</html>