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

}
.myDiv{
    width:40%;
    height:240%;
    background:grey;
}
.container{
background-color:grey;
width:25%;
}</style>
</head>


<body>
<center>
<h1>WE CARE FOR YOUR CARS!!!</h1>
<br>
<br>

<div style="float :center" class="myDiv">
<c:forEach items="${dList}" var="ser">



<h1>Bill Details</h1>

 <br/>
 <br/>
 

 <h3>Center name:</h3><h2>${ser.centerName}</h2>
 <br/>
 <br/>

 <h3>Total amount:</h3> <h2>${ser.total}</h2>
  <br/>
 <br/>
 
 
 <h3>Service date:</h3> <h2>${ser.date}</h2>
  
<br/><br/>



</c:forEach>

</div>
<br>
<br>
<b><h1>THANKS FOR VISITING...!</h1></b>
</center>

</body>
</html>