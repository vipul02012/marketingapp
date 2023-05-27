<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Lead</title>
</head>
<body>
	<h2>Create Lead</h2>
	<form action="saveLead" method="post">
		<pre>
			First Name<input type="text" name="firstName">
			Last Name<input type="text" name="lastName">
			Email<input type="text" name="email">
			Mobile<input type="text" name="mobile">
			<input type="submit" value="save">
		</pre>
	</form>
	${msg}

</body>
</html>
