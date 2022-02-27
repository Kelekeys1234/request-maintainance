<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>     
  <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<h1>VEHICLE MAINTENANCE REQUEST</h1>
<s:form>

 <s:select list="{'Abuja Office'}" headerKey="None" headerValue="Select Office" label="Offices"></s:select>
   <s:select list="{'Airtel Nigeria',
         'EKEDP','FCMB','Helious Towers','Stanbic IBTC','KPMG','Work_In_Client'}" headerKey="None" headerValue="select " label="Client" align="right" ></s:select>
         <s:select list="{'Standard SUV',
         'Saloon Car','15 Seeter Bus','Truck','Earth Moving Equipment'}" headerKey="None" headerValue="select " label="Vechicle" class="ml-auto"></s:select>
         <s:select list="{'JohnSon Adewobi'}" headerKey="None" headerValue="select Client" label="Drivers" class="ml-auto"></s:select>
         <s:date name = "currentDate"   format = "dd/MM/yyyy" />
         
        
         
         <s:select list="{'Accident',
         'BreakDown','Corrective','Routing Service','','Inspection','NA'}" headerKey="None" headerValue="select Client" label="Fualt type" class="ml-auto"></s:select>
         <s:textfield label="location"></s:textfield>
         <s:textarea label="Complaint*"></s:textarea>
      <s:submit ></s:submit>
   
 
  

</s:form>
</body>
</html>