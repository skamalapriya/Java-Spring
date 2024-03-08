<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Category Registration</h1>
<form:form action="http://localhost:8080/SpringMVCProject/category/updatecategory" method="post" modelAttribute="update_category">
<p><form:hidden path="category_id" /></p>
<p>Category Name:<form:input path="category_name" placeholder="Enter the category name" required="true"/></p>
<p><Button type="submit" name="register" value="Register">Register</Button>&nbsp;&nbsp;&nbsp;&nbsp;<Button type="submit" name="delete" value="Delete">Delete</Button></p>
</form:form>
</body>
</html>