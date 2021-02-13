<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<b>Error code:</b> ${pageContext.errorData.statusCode}
	<br> Message:
	<b><%=exception%></b>

	<c:if test="${exception ne null }">

Error Message : <%=exception.getMessage()%>
	</c:if>
</body>
</html>