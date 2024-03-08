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
<form:form action="http://localhost:8080/SpringMVCProject/category/registercategory" method="post" modelAttribute="category">
<p><form:hidden path="category_id" /></p>
<p>Category Name:<form:input path="category_name" placeholder="Enter the category name" required="true"/></p>
<p><Button type="submit" value="Register">Register</Button>
</form:form>
</body>
</html>