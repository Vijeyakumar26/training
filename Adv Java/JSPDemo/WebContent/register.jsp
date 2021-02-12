<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<%@include file="bootstraplink.jsp"%>
</head>
<body>
	<br>
	<%@include file="header.jsp"%>
	<br>
	<br>
	<center>
		<div class="container formContent">
			<h3>Registration form</h3>
			<br>
			<form action="register" method="post">
				<table>
					<tr>
						<td><h5 class ="">Username </h5></td>
						<td><input type="text" class="form-control" name="uname"></td>
					</tr>
					<tr>
						<td><h5>Password </h5></td>
						<td><input type="password" class="form-control" name="pwd"></td>
					</tr>
					<tr>
						<td>
							<h5>Address </h5>
						</td>
						<td><textarea name="address" class="form-control"></textarea></td>
					</tr>
					<tr>
						<td>
							<h5>Contactno </h5>
						</td>
						<td><input type="text" class="form-control" name="contact"></td>
					</tr>
					<tr>
						<td><h5>Email </h5></td>
						<td><input type="text" class="form-control" name="email"></td>
					</tr>
					<tr>
						
						<td><h5>Gender </h5></td>
						<td>
						<div class="form-check">
						<input class="form-check-input" type="radio"
							name="gender" value="M"> Male 
							</div>
							
							<div class="form-check">
							<input	class="form-check-input" type="radio" name="gender" value="F">Female</td>
						</div>
					</tr>
					</table>
					<br>
						<input type="submit" class="btn btn-primary"
							value="Register" />
			</form>
		</div>
	</center>
	<br>
	<br>
	<%@include file="footer.jsp"%>
</body>
</html>