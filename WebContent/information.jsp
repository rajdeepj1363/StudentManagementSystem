<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Info!</title>

<!-- Bootstrap CSS Link CDN -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link href="public/css/styles.css" rel="stylesheet">

<!-- Favicons -->
<link rel="apple-touch-icon" sizes="180x180" href="public/favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="public/favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="public/favicons/favicon-16x16.png">

</head>
<body>
<%@ page import="com.students.Controller.FetchInfo" %>
<%@ page import="java.util.*" %>
<%@ page import="com.students.POJO.*" %>
<%
	
	if(session.getAttribute("email") == null)
	{
		response.sendRedirect("index.jsp");
	}
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
		
%>
<%
	String email = (String)session.getAttribute("email");
	StudentInfo obj = new StudentInfo();
	obj = FetchInfo.fetchInfo(email);
	//HashMap<String,String> result = FetchInfo.fetchInfo(email);
	System.out.println("Im jsp\n Hello"+obj.getName());
%>
<form id="editInfo" action="editInfo" method="post" style="display:none;background-color:white">
	<div style="background-color:white">
		<button id="closeBtn" type="button">X</button>
		<input type="text" name="email" value=<%out.print(obj.getEmail()); %> hidden>
		<input type="text" name="mobile" placeholder="Enter your mobile number" value=<%out.print(obj.getPhone()); %>><br>
		<input type="text" name="father_name" placeholder="Enter your father's name" value=<%out.print(obj.getFatherName()); %>><br>
		<input type="text" name="fOccupation" placeholder="Enter your father's occupation" value=<%out.print(obj.getfOccupation()); %>><br>
		<input type="text" name="mother_name" placeholder="Enter your mother's name" value=<%out.print(obj.getMotherName()); %>><br>
		<input type="text" name="mOccupation" placeholder="Enter your mother's occupation" value=<%out.print(obj.getmOccupation()); %>><br>
		<input type="text" name="address" placeholder="Enter your address" value=<%out.print(obj.getAddress());%> ><br>
		<button type="submit">DONE</button>		
	</div>

</form>
<div id="wrapper">
<section id="NavigationBar">
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboard.jsp"><img src="public/favicons/favicon.ico"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="dashboard.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="information.jsp">Information</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Others
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="ViewAttendance.jsp">View Attendance</a></li>
            <li><a class="dropdown-item" href="ViewResult.jsp">View Result</a></li>
          </ul>
        </li>
       
      </ul>
      <form action="logout.jsp" class="d-flex">
        <button class="btn btn-outline-success" type="submit">Logout</button>
      </form>
    </div>
  </div>
</nav>
</section>	

<section id="infoBox">
	<div class="selfinfo">
            <h5>NAME: <%out.print(obj.getName()); %></h5>
            <h5>ADDRESS: <%out.print(obj.getAddress()); %></h5>
            <h5>PHONE NO: <%out.print(obj.getPhone()); %></h5>
            <h5>DOB: <%out.print(obj.getDob()); %></h5>
	</div>
	<hr>
    <div class="parentinfo">
        <h5>FATHER'S NAME: <%out.print(obj.getFatherName()); %></h5>
        <h6>OCCUPATION: <%out.print(obj.getfOccupation()); %></h6>
        <h5>MOTHER'S NAME: <%out.print(obj.getMotherName()); %></h5>
        <h6>OCCUPATION: <%out.print(obj.getmOccupation()); %></h6>
        <h5>PARENT PHONE: <%out.print(obj.getParentPhone()); %></h5>
       
	</div>
	<hr>
    <div class="collegeinfo">
        <h5>PRN: <%out.print(obj.getPRN()); %></h5>
        <h5>CURRENT YEAR: <%out.print(obj.getCurrentSTD()); %></h5>
        <h5>CURRENT ROLL NO: <%out.print(obj.getRollNo()); %></h5>
	</div>
	<button type="button" class="editInfoBtn">EDIT INFO</button>
</section>



<section id="footer">
	
	<div class="row">
		<div class="col-4 footerBlocks">
			<p class="footerHeading">CONTACT US</p>
			<p class="subheading">Address: <span class="Address">201, Shreenath Complex, Near K9 Fitness,Sinhgad College Rd, Vadgaon, Pune-411041</span></p>
			<p class="subheading">Email: <a href="mailto:rajdeepj1363@gmail.com">rajdeepj1363@gmail.com</a></p>
			<p class="subheading">Phone: <a href="tel:+917030499720">+917030499720</a></p>
		</div>
		<div class="col-4 footerBlocks">
		<p class="footerHeading">QUICK LINKS</p>
		
		</div>
		<div class="col-4 footerBlocks">
		<p class="footerHeading">ABOUT US</p>
		
		</div>
	
	</div>
</section>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script type="text/javascript">
	document.querySelector(".editInfoBtn").addEventListener("click",function(){
		document.querySelector("#editInfo").style.display = "block";
		//document.querySelector("#wrapper").style.opacity = "0.1";
	});
	document.querySelector("#closeBtn").addEventListener("click",function(){
		document.querySelector("#editInfo").style.display = "none";
		//document.querySelector("#wrapper").style.opacity = "1";
	});

</script>
</html>