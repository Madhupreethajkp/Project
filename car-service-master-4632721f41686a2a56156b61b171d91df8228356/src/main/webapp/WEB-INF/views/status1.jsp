<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ include file = "adheader.html" %>
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
body{
background-color:#f1f1f1;
}



</style>
</head>
<body>

<div class="container">
<center><h1><i>KNOW YOUR STATUS</i></h1><center>
<table class="table table-bordered">
<tr>

<th width="80" align="center">Request ID</th>
<th width="80"  align="center">SERVICE ID</th>


<th width="100"  align="center">status</th>



</tr>
<c:forEach items="${ser1List}" var="ser">
<tr>
<td width="80">${ser.requestId } </td>
<td width="80">${ser.serviceId } </td>
<td width="80">${ser.status}</td>



</tr>
</c:forEach>
</table>
</div>
</body>
</html>