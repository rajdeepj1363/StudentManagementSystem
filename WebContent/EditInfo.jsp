<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Info</title>
</head>
<style>

#editInfo_table th,#editInfo_table td{
border-style:solid;
border-width:1.5px;

}
</style>
<body>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>

<%
	ResultSet result =null;
	ResultSet resultMeta =null;
	/*if(session.getAttribute("email") == null && session.getAttribute("user").equals("student"))
	{
		response.sendRedirect("index.jsp");
	}
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");*/
	String user = "";
	if(request.getAttribute("result")!=null)
	{
		System.out.println("Found result");
		result =(ResultSet)request.getAttribute("result");
		resultMeta = result;
	}
	else
	{
		user = request.getParameter("user");
		session.setAttribute("EditUser",user);
	}
	
%>
<div id="first_block">
	
	<form action="AdminFunctions" method="post">
		<input type="text" name="function" value="editSearch" hidden>
		<input type="text" name="user" value='<%out.print(user); %>' hidden>
		<input type="text" name="email" placeholder="Enter your email" required>
		<button type="submit">Search</button>
	</form>

</div>

<div id="fetchedInfo">
	<form action="AdminFunctions" method="post">
	<input type='text' name='function' value='editAction' hidden>
	<input type='text' name='user' value=<%out.print(session.getAttribute("EditUser")); %> hidden>
		<table id="editInfo_table">
			<%
				int count = 2;
			if(result!=null)
			{
				
			
				if(session.getAttribute("EditUser").equals("student"))
				{
					if(result.next())
					{
						System.out.println("Result was not null");
						ResultSetMetaData rmd = resultMeta.getMetaData();
						while(count<=24)
						{
							if(rmd.getColumnName(count).equals("email"))
							{
								
								session.setAttribute("oldEmail",result.getString(count));
							}
							System.out.println("Inside While");
							out.print("<tr><th>"+rmd.getColumnName(count)+"</th>");
							out.print("<td><input type='text' name='"+rmd.getColumnName(count)+"' value='"+result.getString(count)+"'></td></tr>");
							System.out.println(count);
							count++;
						}
						
					}
				}
				if(session.getAttribute("EditUser").equals("teacher"))
				{
					if(result.next())
					{
						
						ResultSetMetaData rmd = resultMeta.getMetaData();
						while(count<=11)
						{
							
							if(rmd.getColumnName(count).equals("uname"))
							{
								
								session.setAttribute("oldEmail",result.getString(count));
							}
							out.print("<tr><th>"+rmd.getColumnName(count)+"</th>");
							out.print("<td><input type='text' name='"+rmd.getColumnName(count)+"' value='"+result.getString(count)+"'></td></tr>");
							System.out.print(count);
							count++;
						}
						
						
					}
				}
				out.print("<button type='submit' name='editInfoBtn'>Make Change</button>");
			}
			%>
		
		</table>
		
		
	</form>
	

</div>

	

</body>
</html>