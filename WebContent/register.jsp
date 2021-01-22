<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
 <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    
</head>
<style>
.registerForm{
	position:absolute;
	top:30vh;
	left:40vw;
	border-style:solid;
	border-width:2px;
	padding:40px;
}
.registerForm form input,button{
	margin:6px auto;
}

</style>
<body>
<div class = "registerForm">
	<form action ="admission" method="post" enctype="multipart/form-data">
		<input type="text" name="name" value="Rajdeep">
		<input type="text" name="name1" value="Jadhav">
		<input type="file" name="file_name">
		
		<button>SUBMIT</button>
	</form>
</div>
	
</body>
<script type="text/javascript">
	document.querySelector(".registerBtn").addEventListener("click",function(){
		var pwd1 = document.querySelector(".pwd1").value;
		var pwd2 = document.querySelector(".pwd2").value;
		if(pwd1 == pwd2)
			{
				document.querySelector(".registerForm form").submit();
			}
		else
			{
			alert("Passwords do not match!");
			location.reload();
			}
		
	});
</script>
</html>