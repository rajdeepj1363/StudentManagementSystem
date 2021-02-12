<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Attendance</title>
</head>
<body>
<%
	
	if(session.getAttribute("email") == null && session.getAttribute("user").equals("student"))
	{
		response.sendRedirect("index.jsp");
	}
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
%>
<%@ page import="com.students.Controller.GetAttendance" %>
<%@ page import="java.sql.ResultSet" %>
<%
	ResultSet result = GetAttendance.getAttendance((String)session.getAttribute("email"));
	if(result.next())
	{
		int totalLec = Integer.valueOf(result.getString("totalLec"));
		
		int attendedLec = Integer.valueOf(result.getString("attendedLec"));
		
		float percentage = (attendedLec/(float)totalLec)*100;
		out.print("<h3>Total Number of Lectures:"+totalLec+"</h3>");
		out.print("<h3>Attended Lectures:"+ attendedLec+"</h3>");
		out.print("<h3>Attendance Percentage:"+percentage+"%"+"</h3>");
		if(percentage > 60)
		{
			out.println("<h2 style='color:green'>You are safe</h2>");
		}
		else
		{
			out.println("<h2 style='color:red'>Low Attendance!</h2>");
		}
	}
	else
	{
		out.print("No attendance data available. Contact Class Teacher");
	}
	
	
%>


</body>
</html>