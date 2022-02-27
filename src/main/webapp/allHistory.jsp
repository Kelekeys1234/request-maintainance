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
<h2>ALL HISTORY MAINTENANCE REQUEST</h2>
<s:form action ="jasper">
<button> Generate Pdf</button>
</s:form>
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
      
    </tr>
  </thead>
  <tbody>
  <s:iterator  value="history" >
   
         <tr>
         <td><s:property value="Id"/></td>
         <td><s:property value="office"/></td>
          <td><s:property value="client"/></td>
           <td><s:property value="vehicle"/></td>
            <td><s:property value="driver"/></td>
             <td><s:property value="breakdown"/></td>
              <td><s:property value="location"/></td>
               <td><s:property value="complaint"/></td>
                <td><s:property value="createdOn"/></td>
                
        
          
      </tr>

  </s:iterator>
  </tbody>
    </table>

</body>
</html>