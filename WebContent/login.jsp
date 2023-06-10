<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- <base href="${pageContext.request.contextPath}"> --%>
<<!-- link rel="stylesheet" type="text/css" href="./css/style1.css"> -->
<link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet" > 

</head>
<body>

<h2>Login Form</h2>
<div class="bg-img">
  <form action="http://localhost:9090/WebLoginApplication/login" method="post" class="container">
    <h1>Login</h1>
	<label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
    
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    
    <!-- <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email">     -->
    

    <button type="submit" class="btn">Login</button>
  </form>
 </div>
 <div align="center">
 	<h3><font color="cyan">New User? <a href="views/user_registration.html">SignUp</a></font></h3>
 </div>
</body>
</html>
