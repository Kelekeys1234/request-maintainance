<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>     

  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<%@ include file="header.jsp" %>
<h1>VEHICLE MAINTENANCE REQUEST</h1>
<s:form action = "vechicle">

 <s:select key="select.office" list="{'Abuja Office'}" headerKey="None" headerValue="Select Office" label="Offices"></s:select>
   <s:select key="select.client" list="{'Airtel Nigeria',
         'EKEDP','FCMB','Helious Towers','Stanbic IBTC','KPMG','Work_In_Client'}" headerKey="None" headerValue="select " label="Client" align="right" ></s:select>
         <s:select key="select.vehicle" list="{'Standard SUV',
         'Saloon Car','15 Seeter Bus','Truck','Earth Moving Equipment'}" headerKey="None" headerValue="select " label="Vechicle" class="ml-auto"></s:select>
         <s:select key="select.driver" list="{'JohnSon Adewobi'}" headerKey="None" headerValue="select Client" label="Drivers" class="ml-auto"></s:select>
       
         <s:select key="select.breakdown" list="{'Accident',
         'BreakDown','Corrective','Routing Service','','Inspection','NA'}" headerKey="None" headerValue="select Client" label="Fualt type" class="ml-auto"></s:select>
         <s:textfield key="select.location" label="location"></s:textfield>
         <s:textarea key="select.complaint" label="Complaint*"></s:textarea>
      <s:submit ></s:submit>

</s:form>
</body>
</html>