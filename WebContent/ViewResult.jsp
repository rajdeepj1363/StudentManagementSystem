<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Result</title>
<!-- Bootstrap CSS Link CDN -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link href="public/css/styles.css" rel="stylesheet">

<!-- Favicons -->
<link rel="apple-touch-icon" sizes="180x180" href="public/favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="public/favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="public/favicons/favicon-16x16.png">
</head>
<body>
<%

if(session.getAttribute("email") == null && session.getAttribute("user").equals("student"))
{
	response.sendRedirect("index.jsp");
}
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

%>
<%@ page import="com.students.Controller.FetchResults" %>
<%@ page import="java.sql.ResultSet" %>
<%
	String email = String.valueOf(session.getAttribute("email"));
	ResultSet result = FetchResults.fetchResult(email);
	
%>
<section id="result">
<div>
	<h2>RESULTS</h2>
</div>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Sr.No</th>
      <th scope="col">Name</th>
      <th scope="col">Exam Name</th>
      <th scope="col">Date Uploaded</th>
      <th scope="col">Result</th>
    </tr>
  </thead>
  <tbody>
    <%
    	int i=1;
    	while(result.next())
    	{
    		
    		out.print("<tr><th scope='row'>"+String.valueOf(i)+"</th><td>"+result.getString("name")+"</td><td>"+result.getString("exam")+"</td><td>"+result.getString("date")+"</td> <td><a href="+"public/uploads/results/"+result.getString("result")+" target='_blank'>View</a></td></tr>");
    		
    		i++;
    	}
    %>
   
  </tbody>
</table>
</section>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</html>