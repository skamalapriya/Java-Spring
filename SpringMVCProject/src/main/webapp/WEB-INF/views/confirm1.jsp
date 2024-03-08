<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Confirm Registration credentials</h1>
<p> Full Name: ${user.getFirstname()}&nbsp;${user.getLastname()} </p>
<p> Country: ${user.getCountry()} </p>
<p> Gender: ${user.getGender()} </p>
<p> Languages: ${user.getLanguage()} </p>
</body>
</html>