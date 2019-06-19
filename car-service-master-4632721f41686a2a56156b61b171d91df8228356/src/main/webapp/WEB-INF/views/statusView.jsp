<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ include file = "header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
<style>






body{
background-color:#f1f1f1;
}

</style>

</head>
<body  background=>
<div class="container">
<center>
<table  class="table table-bordered">

<tr>
<th width="180" align="left">REQUEST ID</th>
<th width="180"  align="left">SERVICE ID</th>


<th width="180"   align="left">STATUS</th>
<th></th>


</tr> 


<c:forEach items="${serList}" var="ser">


<tr>


<td width="180"> ${ser.requestId }</td>
  

<td width="180">${ser.serviceId } </td>
<td width="180">${ser.status}</td>
<c:set var = "status" value="accepted"/>
<c:if test = "${ser.status eq status}">
<td width="180"> <a href="<c:url value='/deliveryBoy/${ser.requestId}'/>" style="color:lightgreen">Delivery Boy Details</a></td>
</c:if>
</tr>
</c:forEach>

</table>
</center>
</div>
</body>
</html>