<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Users Admin Page</h1>
<p><a href="add">Add New User</a></p>
<table width="100%" border="1" cellspacing="0" cellpadding="10">

<tr>
<th>Name</th><th>Country</th><th>Gender</th><th>Languages</th><th>UserName</th><th>Action</th>
</tr>

<c:forEach var="user" items="${lstusers}">
<tr>
<td>${user.getFirstname()} &nbsp; ${user.getLastname()}</td>
<td>${user.getCountry()}</td>
<td>${user.getGender()}</td>
	<td>
	<c:forEach var="lang" items="${user.getLanguage()}">
	${lang} &nbsp;
	</c:forEach>
	</td>
<td>${user.getEmailid()}</td>
<td><a href="edit/${user.getEmailid()}">Edit</a> | <a href="delete/${user.getEmailid()}" onclick="return confirm('Are you sure, do you want to delete this record??')">Delete</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>