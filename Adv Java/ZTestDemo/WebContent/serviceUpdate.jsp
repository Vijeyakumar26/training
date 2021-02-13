<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service Update Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="script/updateService.js" type="text/javascript"></script>
</head>
<body>

	<center>
		<h1 class="display-4">Ajax Jquery Validation!</h1>

		<br>
		<div>
			<h3>Service Update Form</h3>
			<br>
			<form action="getServiceDetails" method="post">
			<tr>
				<td><h3>ServiceID</h3>
				<input type="text" class="form-control" name="serviceid"
					id="serviceid"> <span id="serviceidmsg"></span></td>
					<input type="button" id="show" value="Show" /></td>	
				</tr>
			</form>
			<form action="update" method="get">
				<table>
					<tr>
						<td><h3>Service Desc</h3></td>
						<td><input type="text" class="form-control"
							name="servicedesc" id="servicedesc"><span
							id="servicedescmsg"></span></td>
					</tr>
					<tr>
						<td><h3>Price</h3></td>
						<td><input type="text" name="price" id="price"
							class="form-control"><span id="pricemsg"></span></td>
					</tr>
					<tr>
						<td><h3>Status</h3></td>
						<td><input type="text" class="form-control" name="status"
							id="status"><span id="statusmsg"></span></td>
					</tr>
				</table>
				<br> <input type="submit" 
					id="submit" value="Update" />
			</form>
		</div>
	</center>
</body>
</html>