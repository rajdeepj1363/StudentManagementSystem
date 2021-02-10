<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>

<!-- Bootstrap CSS Link CDN -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link href="public/css/styles.css" rel="stylesheet">

<!-- Favicons -->
<link rel="apple-touch-icon" sizes="180x180" href="favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="favicons/favicon-16x16.png">

</head>
<style>
	.admission_form_toggle:hover,.teacher_form_toggle:hover,.deleteStudent:hover,.deleteTeacher:hover{
        cursor:pointer;
    }
    
    #admissionVerify,#deletionBox{
    	background-color:#fff;
        position:absolute;
        top:50%;
        left:50%;
        -ms-transform: translateX(-50%) translateY(-50%);
   	    -webkit-transform: translate(-50%,-50%);
   	    transform: translate(-50%,-50%);
        padding:50px;
        border-style:solid;
        border-width:3px;
         z-index:9999;
    }
      #insertTeacher{
      	background-color:#fff;
        position:absolute;
        top:50%;
        left:50%;
        -ms-transform: translateX(-50%) translateY(-50%);
   	    -webkit-transform: translate(-50%,-50%);
   	    transform: translate(-50%,-50%);
        padding:50px;
        border-style:solid;
        border-width:3px;
        z-index:9999;
    }
    #insertTeacher input{
    	margin:5px auto;
    }
    .close_box,.close_box2{
        position:absolute;
        top:5%;
        right:2%;
    }
    #closeDelBox{
    position:absolute;
        top:5%;
        right:2%;
    }
    
    
</style>
<body>

<%
	if(session.getAttribute("AdminUsername") == null)
	{
		response.sendRedirect("admin.jsp");
	}
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
%>
<form id="admissionVerify" action="ViewAdmissionDetails" method="post" style="display:none">
    <button class="close_box" type="button">X</button>
    <input type="text" placeholder="Enter candidate's Email" name="candidate_email" required>
    <button name="verifyCandidate">CHECK</button>
</form>

<form id="deletionBox" action="AdminFunctions" method="post" style="display:none">
    <button id="closeDelBox" type="button">X</button>
    <input type="text" placeholder="Enter candidate's Email" name="email" required>
    <input type="text" name="user" value="" hidden>
    <input type="text" name="function" value="del" hidden>
    <button name="deleteUser" type="button">DELETE</button>
</form>

<form id="insertTeacher" action="AddTeacher" method="post" style="display:none">
	<input name="function" value="addTeacher" hidden>
    <button class="close_box2" type="button">X</button>
    <div class="row">
    	<div class="col-6">
    	<input type="text" placeholder="Enter Name" name="teacher_name" required><br>
   		 <input type="text" placeholder="Enter Mobile" name="teacher_mobile" required><br>
    	</div>
    	<div class="col-6">
    	 <input type="text" placeholder="Enter Email" name="teacher_email" required><br>
    <input type="text" placeholder="Enter Address" name="teacher_address" required><br>
    	</div>
    	<div class="col-6">
    	<label>Date of Birth</label><br>
    	<input type="date" placeholder="Enter Date of Birth" name="teacher_dob" required><br>
    	<input type="text" placeholder="Enter Qualification" name="teacher_qualification" required><br>
    	</div>
    	<div class="col-6">
    	<input type="text" placeholder="Enter Designation" name="teacher_designation" required><br>
    <input type="text" placeholder="Enter Class Teacher Div" name="teacher_classTeacher" required><br>
    	</div>
    	<div class="col-6">
    	<input type="text" placeholder="Enter Teaching Div" name="teacher_divisions" required><br>
    	<input type="text" placeholder="Enter Teaching Subjects" name="teacher_subjects" required><br>
    	</div>
    </div>
   <button name="verifyCandidate">INSERT</button>
</form>
<section id="NavigationBar">
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboardAdmin.jsp"><img src="public/favicons/favicon.ico"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="dashboardAdmin.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Information</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Others
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item admission_form_toggle">Admissions</a></li>
            <li><form class="dropdown-item editInfo" action="EditInfo.jsp" method="post"><input type="text" name="user" value="student" hidden><button style="background-color:white;border-style:none;">Edit Student Info</button></form></li>
            <li><a class="dropdown-item deleteStudent" >Delete Student Data</a></li>
            <li><hr class="dropdown-divider"></li>
             <li><a class="dropdown-item teacher_form_toggle">Add Teacher</a></li>
            <li><form class="dropdown-item editInfo" action="EditInfo.jsp" method="post"><input type="text" name="user" value="teacher" hidden><button style="background-color:white;border-style:none;">Edit Teacher Info</button></form></li>
            <li><a class="dropdown-item deleteTeacher" >Delete Teacher Data</a></li>
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

<section id="footer" style="position:absolute;bottom:0;">
	
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

	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script type="text/javascript" >
document.querySelector(".admission_form_toggle").addEventListener("click",function(){
    document.querySelector("#admissionVerify").style.display="block";
});
document.querySelector(".close_box").addEventListener("click",function(){
    document.querySelector("#admissionVerify").style.display="none";
});
document.querySelector(".teacher_form_toggle").addEventListener("click",function(){
    document.querySelector("#insertTeacher").style.display="block";
});
document.querySelector(".close_box2").addEventListener("click",function(){
    document.querySelector("#insertTeacher").style.display="none";
});

document.querySelector(".deleteStudent").addEventListener("click",function(){
	console.log("Del St");
	$("#deletionBox").css("display","block");
	document.querySelector("#deletionBox input[name=user]").value = "student";
	var s = document.querySelector("#deletionBox input[name=user]").value;
	console.log(s);
});
document.querySelector(".deleteTeacher").addEventListener("click",function(){
	console.log("del teach");
	$("#deletionBox").css("display","block");
	document.querySelector("#deletionBox input[name=user]").value = "teacher";
	var s = document.querySelector("#deletionBox input[name=user]").value;
	console.log(s);
});
document.querySelector("#closeDelBox").addEventListener("click",function(){
    document.querySelector("#deletionBox").style.display="none";
});
document.querySelector("#deletionBox button[name=deleteUser]").addEventListener("click",function(){
	if(confirm("Are you sure you want to delete?"))
	{
		document.querySelector("#deletionBox").submit();
	}
	else
	{
		console.log("Cancelled");
		window.location = "dashboardAdmin.jsp";
	}
});
</script>

</html>