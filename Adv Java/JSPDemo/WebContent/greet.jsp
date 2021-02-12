<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>    

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Greetings</title>
<%@include file="bootstraplink.jsp"%>
</head>
<body>

<h2 class="display-3"> Welcome. </h2>


<%
	GregorianCalendar gc = new GregorianCalendar();		
	request.setAttribute("gc", gc);
%>

	<c:choose>
		<c:when  test="${gc.get(GregorianCalendar.HOUR) le 11} ">
			<h2 class="display-3"> Good Morning! </h2>
		</c:when>
		<c:when test="${gc.get(GregorianCalendar.HOUR) le 14}">
			<h2 class="display-3"> Good Noon!</h2>
		</c:when>
		<c:otherwise>
			<h2 class="display-3"> Good Evening! </h2>
		</c:otherwise>
	</c:choose>
	

</body>
</html>