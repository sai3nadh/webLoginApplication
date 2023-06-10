<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- <base href="${pageContext.request.contextPath}"> --%>
<!-- <link rel="stylesheet" type="text/css" href="./css/style1.css"> -->
<link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet" > 
</head>
<body>
<% 
 	//HttpSession session=request.getSession(false);
	//implicit session object contains reference of
	//the session object explicitly created in LoginServlet
	String username= (String)session.getAttribute("username"); 
	//out.print(username);
	if(username!=null){
%>

<h2 align="center"><font color="orange">Welcome to Main Menu, <%=username %></font></h2>
<div class="bg-img1" class="container">
	  <!-- <div align="center">
	  		<h1><font color='blue'>Main Menu</font></h1>
	  </div> -->
	  
		  <div  class="container1" >
		  		<form action="" >
		  			<h2><input type="submit" name="Product" value="product" class="button"><br>
		  			<input type="submit" name="Order" value="order" class="button"><br>
		  			<input type="submit" name="Customer" value="customer" class="button"></h2>
		  		</form>
		  		<h5 align="center">
		 		<font color="cyan">
		 			<a href="http://localhost:9090/WebLoginApplication/logout">Logout</a>
		 		</font>
		 		</h5>
		  </div>
	  </div>
 <%}else{ %>
 	<h2>Login to access this page</h2>
 	<jsp:include page="/login.jsp"/>
 <%}%>
</body>
</html>
