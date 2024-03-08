<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> User Registration </h1>
<form action = "saveUser" method="post">
<p> First Name: <input type="text" name="fname" id="fname" placeholder="Enter your FirstName" required></p>
<p> Last Name: <input type="text" name="lname" id="lname" placeholder="Enter your LastName" required></p>
<p> Country: <Select name="country" id="country">
				<option>India</option>
				<option>UK</option>
				<option>USA</option>
			 </Select>
</p>
<p> Gender: <input type="radio" name="gender" id="gender" value="Male"> Male 
			<input type="radio" name="gender" id="gender" value="Female"> Female 
</p>
<p> Languages: <input type="checkbox" name="lang" id="lang" value="C"> C
			   <input type="checkbox" name="lang1" id="lang1" value="C#"> C#
			   <input type="checkbox" name="lang2" id="lang2" value="Java"> Java
</p>
<p> <input type="submit" value="Submit"> </p>
</form>
</body>
</html>