<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h2>LIST OF VEHICLE MAINTENANCE REQUEST</h2>

 <table class="table">
  <thead class="thead-dark">
   
         <tr>
        <th>ID</th>
      <th>OFFICE</th>
      <th>CLIENT</th>
       <th>VEHICLE</th>
        <th>DRIVER</th>
         <th>FUALT TYPE</th>
          <th>LOCATION</th>
           <th>COMPLAINT</th>
           <th>Date</th>
      <th colspan="3">Action</th>
    </tr>
    

  </thead>
  <tbody>
  <s:iterator  value="create" var="get" >
   
         <tr>
        <td><s:property value="#get.id"/></td>
         <td><s:property value="#get.office"/></td>
          <td><s:property value="#get.client"/></td>
           <td><s:property value="#get.vehicle"/></td>
            <td><s:property value="#get.driver"/></td>
             <td><s:property value="#get.breakdown"/></td>
              <td><s:property value="#get.location"/></td>
               <td><s:property value="#get.complaint"/></td>
                <td><s:property value="#get.createdOn"/></td>
                
        
          <td><a href="delete?Id=<s:property value="#get.Id"/>">
          <button >Delete</button></a> </td>
            
           <td><a href="updateId?Id=<s:property value="#get.Id"/>">
          <button >Update</button></a> </td>
          <td><a href="audReader?ID=<s:property value="#get.Id"/>">
          <button >History</button></a> </td>
      </tr>

  </s:iterator>
  </tbody>
    </table>

</body>
</html>