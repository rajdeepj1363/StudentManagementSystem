<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Info</title>
</head>
<body>
<%
	String user = request.getParameter("user");
	
%>
<div id="first_block">
	<form id="searchCandidate" action="AdminFunctions" method="post">
		<input type="text" name="function" value="edit" hidden>
		<input type="text" name="user" value=<%out.print(user); %> hidden>
		<input type="email" name="email" placeholder="Enter your email" required>
		<button>Search</button>
		
	</form>

</div>

	

</body>
</html>