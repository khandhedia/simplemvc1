<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login JSP</title>
</head>
<body>
<h1><div><font color="red">${error}</font></div></h1>
<form action="login.jsp" method="post">
	Name: <input type="text" name="name"/> 
	Password: <input type="password" name="password"/>
	<input type="submit" value="Login"/>
</form>
</body>
</html>