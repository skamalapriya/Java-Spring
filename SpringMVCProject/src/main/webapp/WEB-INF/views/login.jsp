<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> User Login</h1>
<form action = "checkLogin" method = "post">
<p> User Name : <input type = "text" name = "uname" id = "uname" placeholder = "Enter user name" required> </p>
<p> Password : <input type = "password" name = "passwd" id = "passwd" placeholder = "Enter user password" required> </p>
<p> <input type = "Submit" value = "Login"> </p>
</form>
</body>
</html>