<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.79.0">
    <title>STES Student Management System</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<!-- Favicons -->
<link rel="apple-touch-icon" sizes="180x180" href="favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="favicons/favicon-16x16.png">

    

<meta name="theme-color" content="#7952b3">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      #navBar
      {
      	position:fixed;
      	top:0;
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">

    
    
<main class="form-signin">
  <div id="navBar">
  		<a href="admissionForm.jsp">Admission</a>
  		<a href="admin.jsp">Admin</a>
  </div>
  <form action="verify" method="post">
    
    
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    <label for="inputEmail" class="visually-hidden">Email address</label>
    <input name = "email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="visually-hidden">Password</label>
    <input name = "pwd" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	<br>
	<input name = "var" type="number" hidden value=0>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    
  </form>
</main>


    
  </body>
  <script type="text/javascript">
  	document.onload = function(){
  		if(document.querySelector("input[name=var]").value == 1)
  			{
  				alert("Invalid Credentials");
  			}
  	}
  </script>

</html>
    