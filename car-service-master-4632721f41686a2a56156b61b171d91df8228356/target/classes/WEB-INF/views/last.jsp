<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ include file = "header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{

background-repeat:no-repeat;
background-size:100%;
color:white;
}
.container{
background-color:grey;
width:25%;
}</style>
</head>


<body background="/car-service/images/carimg.jpg">
<div >
<c:forEach items="${dList}" var="ser">

<form action="/car-service/billGenerate" >

<h1>Delivery boy details</h1>

 <br/>
 <br/>
 

 <h3>Name:</h3><h2>${ser.dname}</h2>
 <br/>
 <br/>

 <h3>contact:</h3> <h2>${ser.contact}</h2>
  <br/>
 <br/>
 
 
 <h3>Experience:</h3> <h2>${ser.experience}</h2>
  
<br/><br/>
<input type="submit" value="GENERATE BILL">
</form>

</c:forEach>

</div>

</body>
</html>