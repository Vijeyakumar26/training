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
<%@include file="header.jsp"%>
<br>
<br>

<div class ="container">
<h3>Update User</h3><br><br>
	<form action="updateUser" method="post">
		<h5>Enter username : </h5><input type="text" class ="form-control" name="uname" />
		 <br /></br/> 
		 <h5>Contactno:	</h5><input type="text" class ="form-control" name="contact"> 
		 <br /></br/> 
		 <input type="submit"class="btn btn-primary" value="Update User" />
	</form>
</div>
<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<%@include file="footer.jsp"%>
</body>
</html>