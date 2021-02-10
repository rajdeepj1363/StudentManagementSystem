<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verify Data</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link href="public/css/admissionForm.css" rel="stylesheet" >
</head>
<style>
    body{
        background-color:#48426d;
    }
    h1{
        color:#00af91;
    }

</style>
<body>
<%@ page import="com.students.POJO.AdmissionInfo" %>
<%
	if(session.getAttribute("AdminUsername") == null)
	{
		response.sendRedirect("admin.jsp");
	}
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	if(request.getAttribute("admissionInfo")  == null)
	{
		response.sendRedirect("admin.jsp?error");
	}
	AdmissionInfo obj = (AdmissionInfo)request.getAttribute("admissionInfo");
	
	
%>
<div id="admissionForm">
    <div class="tab1">
    <h1>BASIC DETAILS</h1>
    <div class="row"><br>
        <div class="col-6 ">
            <label>Title</label><br>
            <input type="text" name="title" value = <%out.print(obj.getTitle()); %> readonly><br>
            <label>First Name</label><span class="required-mark">*</span><br> 
            <input type="text" name="fname" value = <%out.print(obj.getFname()); %> readonly><br>
            <label>Middle Name</label><br> 
            <input type="text" name="mname" value = <%out.print(obj.getMname()); %> readonly><br>
            <label>Last Name/Surname</label><span class="required-mark">*</span> <br>
            <input type="text" name="lname" value = <%out.print(obj.getLname()); %> readonly><br>         
            <label>Gender</label><span class="required-mark">*</span><br> 
            <input type="text" value = <%out.print(obj.getGender()); %> readonly><br>
            <label>Mobile</label><span class="required-mark">*</span><br> 
            <input type="tel" name="mobile" value = <%out.print(obj.getMobile()); %> readonly><br>
            
            <label>Phone</label><br> 
            <input type="tel" name="phone" value = <%out.print(obj.getPhone()); %> readonly><br>
            <label>Email</label><span class="required-mark">*</span><br> 
            <input type="email" name="email" value = <%out.print(obj.getEmail()); %> readonly><br>
            <label>Date of Birth</label><span class="required-mark">*</span><br>
            <input type="date" name="dob" value = <%out.print(obj.getDob()); %> readonly><br>
            <label>Place of Birth </label><br> 
            <input type="text" name="pob" value = <%out.print(obj.getPob()); %> readonly><br>
            <label>Marital Status</label><br> 
            <input type="text" value = <%out.print(obj.getMarital_status()); %> readonly><br>
        </div>

        <div class="col-6">
            <label>Father Name</label><span class="required-mark">*</span><br>
            <input type="text" name="father_name" value = <%out.print(obj.getFather_name()); %> readonly><br>
            <label>Father Occupation</label><br> 
            <input type="text" name="father_occupation" value = <%out.print(obj.getfOccupation()); %> readonly><br>
            <label>Mother Name</label><span class="required-mark">*</span><br> 
            <input type="text" name="mother_name" value = <%out.print(obj.getMother_name()); %> readonly><br>
            <label>Mother Occupation</label><br> 
            <input type="text" name="mother_occupation" value = <%out.print(obj.getmOccupation()); %> readonly><br>
            <label>Parent's Phone</label><span class="required-mark">*</span><br> 
            <input type="text" name="parent_phone" value = <%out.print(obj.getParentPhone()); %> readonly><br>
            
            <label>Caste Category</label><span class="required-mark">*</span><br> 
            <input type="text" value = <%out.print(obj.getCaste_category()); %> readonly><br>
            <label>Sub Caste</label><br> 
            <input type="text" name="sub_caste" value = <%out.print(obj.getSub_caste()); %> readonly><br>
            <label>Nationality </label><span class="required-mark">*</span><br> 
            <input type="text" value = <%out.print(obj.getNationality()); %> readonly><br>
            <label>Religion </label><span class="required-mark">*</span><br> 
            <input type="text" value = <%out.print(obj.getReligion()); %> readonly><br>
            <label>Handicap</label><span class="required-mark">*</span><br> 
            <input type="text" value = <%out.print(obj.getHandicap()); %> readonly><br>
            
        </div>
        </div>
    </div>
    
    <div class="tab2">
        <h1>UPLOAD DOCUMENTS</h1>
        <label>Aadhar Card</label><span class="required-mark">*</span><br>
        <a href="public\uploads\aadhar\Rajdeep5574805Jadhavaadhar.jpg" target="_blank">Click Here</a><br>
        <a href=<%System.out.println(obj.getUp_aadhar());out.print("public/uploads/aadhar/"+obj.getUp_aadhar()); %> target="_blank">Click Here</a><br>
        <label>PAN Card</label><span class="required-mark">*</span><br>
        <a href=<%out.print("public/uploads/pan/"+obj.getUp_PAN()); %> target="_blank">Click Here</a><br>
        <label>10th Marksheet</label><span class="required-mark">*</span><br>
        <a href=<%out.print("public/uploads/10thMarksheet/"+obj.getUp_tenth()); %> target="_blank">Click Here</a><br>
        <label>12th Marksheet</label><span class="required-mark">*</span><br>
        <a href=<%out.print("public/uploads/12thMarksheet/"+obj.getUp_twelve()); %> target="_blank">Click Here</a><br>
    </div>
    <button class="next" type="button">NEXT</button>
    
    <form action="verifyCandidate" method="post" style="display:inline">
    	<input type="text" name="candidate_email" value=<%out.print(obj.getEmail()); %> hidden>
    	<%session.setAttribute("AdmissionData", obj); %>
    	<button class="verifyCandidateBtn" type="submit">VERIFY</button>
    </form>
    
    
    
</div>
    
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script src="public/js/javascript.js" type="text/javascript"></script>

</html>