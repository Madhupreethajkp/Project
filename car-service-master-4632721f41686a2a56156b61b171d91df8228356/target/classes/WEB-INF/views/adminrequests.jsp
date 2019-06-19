<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
          <%@ include file = "adheader.html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
<title>Insert title here</title>
<style>
 body{
  background-image:url("images/1.jpg");
  background-repeat:;
  
    background-size:100%;
    
    color:white;
  }
div.container{
 width:1500px;
 
  background-color:#686868;
 opacity:0.7;
 
padding-top:100px;
}

</style>
</head>
<body>
<center>
<div class="container">
<h1><b>REQUEST DETAILS OF USERS</b></h1>
  
<table class="table table-bordered">
<tr>

<th width="80" align="center">REQUEST ID</th>
<th width="80"  align="center">SERVICE ID</th>


<th width="100"  align="center">STATUS</th>
<th>ACCEPT</th>
<th>REJECT</th>

</tr> 

<c:forEach items="${serList}" var="ser">

<tr>
<td width="80">

<a href="<c:url value='/drop/${ser.requestId}'/>"  style="color:lightgreen"> ${ser.requestId }</a>
  
</td>
<td width="80">${ser.serviceId } </td>
<td width="80">${ser.status}</td>



<td width="80"> <a href="<c:url value='/accept/${ser.requestId}'/>" style="color:lightgreen">Accept request</a></td>
<td width="80"> <a href="<c:url value='/reject/${ser.requestId}'/>" style="color:lightgreen">Reject request</a></td>


</tr>

</c:forEach>

</table>
 

 
</div>
</center>
</body>
</html>