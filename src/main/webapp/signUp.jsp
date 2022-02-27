<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>
<body>
<h1>Sign In</h1>
<s:form action="userSign">
<s:textfield key="user.firstname" label="First Name" align="center"></s:textfield>
<s:textfield key="user.lastname" label="Last Name"></s:textfield>
<s:textfield key="user.email" label="Email"></s:textfield>
<s:password key="user.password" label="password"></s:password>
<s:submit key="submit" label="Submit"></s:submit>
</s:form>
</body>
</html>