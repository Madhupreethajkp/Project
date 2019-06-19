<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ include file = "adheader.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body { 
  color:white;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size:100%; 
}
</style>
</head>
<body  background="/car-service/images/stt.jpg" >
<div class="container" style="float:left">
<form commandName="requestId">
<br/><br/><br/><br/><br/><br/>
Request Id:${requestId}</form>
<form action="/car-service/addDeliveryList/${requestId}" commandName="deliveryList" method="post">
<br/><br/><br/>
<h1>Delivery Boys Available</h1>
<br/><br/>
 <select name="delivery" style="width:200px;height:35px;">
 
<c:forEach items="${deliveryList}" var="deliveryList">
 
    <option value="${deliveryList.dname}">${deliveryList.dname}</option>
  
  </c:forEach>
  </select>
  <br><br><br/><br/>
  <input type="submit">
</form>
</div>
</body>
</html>