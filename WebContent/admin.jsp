<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN</title>
<link rel="stylesheet" href="public/css/styles.css">
</head>
<body>
<div id="adminLoginForm">
	<form action="checkAdmin" method="post">
		<input type="text" name="adminUsername" placeholder="Enter Username" required><br>
		<input type="password" name="adminPwd" placeholder="Enter Password" required><br>
		<button type="submit">Login</button>
	</form>
</div>
	
	
</body>
</html>