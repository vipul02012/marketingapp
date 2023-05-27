<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leads</title>
</head>
<body>
	<h2>All Leads</h2>
	<form action="listAll" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach var="lead" items="${leads}">
			<tr>
	         		<td>${lead.id}</td>
	         		<td>${lead.firstName}</td>
	         		<td>${lead.lastName}</td>
	         		<td>${lead.email}</td>
	         		<td>${lead.mobile}</td>
	         		<td><a href="delete?id=${lead.id}">delete</a></td>
	         		<td><a href="update?id=${lead.id}">update</a></td>
			</tr>
			</c:forEach>
		</table>
		
	</form>

</body>
</html>
