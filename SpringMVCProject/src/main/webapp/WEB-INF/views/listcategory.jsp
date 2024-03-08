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
<h1>Category Admin Page</h1>
<p><a href="add"> Add New Category</a></p>
<table width="100%" border="1" cellspacing="0" cellpadding="10">
<tr><th>Category_id</th><th>Category_name</th><th>Action</th></tr>

<c:forEach var="catgry" items="${lstcatgries}">
<tr>
<td>${catgry.getCategory_id()}</td>
<td>${catgry.getCategory_name()}</td>
<td><a href="edit/${catgry.getCategory_id()}">Edit</a> | <a href="delete/${catgry.getCategory_id()}" onclick="return confirm('Are you sure, you want to delete?')">Delete</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>