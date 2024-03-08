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
<h1> User Registration </h1>
<form:form action = "http://localhost:8080/SpringMVCProject/users/updateuser" method="post" modelAttribute="users_update">
<p> First Name: <form:input path="firstname" placeholder="Enter your FirstName" required="true"/></p>
<p> Last Name: <form:input path="lastname" placeholder="Enter your LastName" required="true"/></p>
<p> Country: <form:select path="country">
				<form:option value="India">India</form:option>
				<form:option value="UK">UK</form:option>
				<form:option value="USA">USA</form:option>
			 </form:select>
</p>
<p> Gender: <form:radiobutton path="gender" value="Male"/> Male
			<form:radiobutton path="gender" value="Female"/> Female 
</p>
<p> Languages: <form:checkbox path="language" value="C"/> C
			   <form:checkbox path="language" value="C#"/> C#
			   <form:checkbox path="language" value="Java"/> Java
</p>
<p> Email: <form:input path="emailid" placeholder="Enter your emailid" required="true" readonly="true"/></p>
<!-- It is not possible to keep displaying password field and not updating as in case of other input fields
     like "First Name", "Last Name" etc., -->
<!-- If we want the password also to be updated, we have to give it as below -->
<p>Password: <form:password path="passwd" placeholder="Enter your password" required="true"/></p>
<!-- If we don't want to update the password field, we have to give it as below -->
<!-- <p> <form:hidden path="passwd" placeholder="Enter your password"/></p>  -->
<p><input type="submit" name="submit" value="Submit">&nbsp;&nbsp;<input type="submit" name="delete" value="Delete"></p>
</form:form>
</body>
</html>