<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Result</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<style>
    #afterSearch{
        display:none;
    }
</style>
<body>
<%@ page import="com.students.Controller.InsertAttendance" %>
<%@ page import="java.sql.ResultSet" %>



<%
	String submit = request.getParameter("submit");
	System.out.println(submit);
	
	if(submit!=null && submit.equals("confirm"))
	{
		System.out.println("Ghus gaya mai");
		String  course = request.getParameter("course_name");
		String year = request.getParameter("year");
		String div = request.getParameter("division");
		ResultSet result = InsertAttendance.StudentAttendance(course,year,div);
		session.setAttribute("StudentResult",result);
		}
	
%>
	<div id="resultMain">
    <form  method="post" >
            <div id="beforeSearch">
            <label for="">COURSE</label><br>
            <select name="course_name">
                <option value="">--select--</option>
                <option value="BE">BE</option>
            </select><br>
            <label for="">YEAR</label><br>
            <select name="year" >
                <option value="">--select--</option>
                <option value="FE">FE</option>
                <option value="SE">SE</option>
                <option value="TE">TE</option>
                <option value="BE">BE</option>
            </select><br>
            <label for="">DIVISION</label><br>
            <select name="division" id="">
                <option value="">--select--</option>
                <option value="A">A</option>
                <option value="B">B</option>
            </select><br>
            <button name="submit" value="confirm" type="submit" class="searchBtn" >SEARCH</button>
            </form>
            </div>
            

            <div id="afterSearch">
            <form action="ResultUpload" method="post" enctype="multipart/form-data">
            <label>STUDENT LIST</label><br>
            
            <select name="student_name">
                <option value="">--select--</option>
                <%
                	ResultSet result =(ResultSet)session.getAttribute("StudentResult");
            		String name = "";
                	while((submit!=null&&submit.equals("confirm"))&&result.next())
                	{
                		name = result.getString("fname")+" "+result.getString("mname")+" "+result.getString("lname");
                		System.out.println("name: "+name);
                		out.print("<option value='"+result.getString("email")+"'>"+result.getString("fname")+" "+result.getString("lname")+"</option>");
                	}
                %>
            </select><br>
            
            <label for="" >EXAM NAME</label><br>
            <input type="text" name="student_name" value=<% if(submit!=null&&submit.equals("confirm"))out.print(name); %> hidden>
            <input type="text" name="examname"><br>
            <input type="text" name="date" hidden>
    		<input type="file" name="resultFile" required><br>
    		<p><span style="color:red">*</span> PDF File only</p>
            <button name="insertAttendance" type="submit">UPLOAD RESULT</button>
            
            </form>
            

            </div>
           
        
        <%
        
    	if(submit!=null && submit.equals("confirm"))
    	{
    		out.print("<script type='text/javascript'>document.querySelector('#beforeSearch').style.display='none';</script>");
    		out.print("<script type='text/javascript'>document.querySelector('#afterSearch').style.display='block';</script>");
    	
    	}
        %>
	
</body>
<script type="text/javascript">
	var myDate = document.querySelector("input[name=date]");
	var today = new Date();
	myDate.value = today.toISOString().substr(0, 10);
	
</script>

</html>