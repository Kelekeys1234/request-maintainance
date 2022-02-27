<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<s:head/>
</head>
<body>
<h1>Login</h1>
<s:form action="userLogin" >
<s:textfield key="user.email" label="Email"></s:textfield>
<s:password key="user.password" label="password"></s:password>
<s:submit key="submit" label="Submit"></s:submit>
</s:form>

</body>
</html>