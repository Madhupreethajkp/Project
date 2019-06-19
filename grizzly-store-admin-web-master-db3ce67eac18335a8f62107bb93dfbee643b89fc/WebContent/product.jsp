<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"  name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="cssfiles/form.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<%@ include file="header.html" %> 
<style>
.rectangle {
  height: 650px;
  width: 325px;
  background-color: #D3D3D3;
  padding-top:10px;
}
.picture {
  height: 100px;
  width: 100px;
  background-color: #B8B8B8;
  }
  .tab
{
background-color: #f1f1f1;
border: none;
float: left;
color: black;
width: 300px;
height: 50px;
font-size: 25px;
text-align: left;
font-weight: 550;

}
.tab:hover
{
background-color: #777D7D;
}

  
</style>


<div class="row">
<div class="rectangle">
<div class="navbar" style="background-color:#B8B8B8; height:60px; color:white;"><b>PROFILE</b>
</div><br><br>
<center><div class="picture">
</div></center>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%= session.getAttribute("username")%>
<h4 align="center">ID</h4>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%= session.getAttribute("userid")%>
<h4 align="center">Designation</h4>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%= session.getAttribute("designation")%>
<h4 align="center">Office</h4>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%= session.getAttribute("office")%>

</div>


<div class="col-md-8">
  <a href="/grizzly-store-admin-web/ProductController"><input type="button" value="PRODUCT" class="tab"></a>
  <a href="#home"><input type="button" value="VENDOR" class="tab"></a>
  <a href="#home"><input type="button" value=" " class="tab"></a>
  <br><br><br>
  <div class="col-md-8">
  
  <div style="float:left;"><img src="images/product-add.jpg" alter="sry" style="width:550px;"></div>

<div ><form action="/grizzly-store-admin-web/ProductController" method="post"><br>
<input type="text"  placeholder="Enter Product ID" class="form-rounded" name="id"><br><br>

  <select name="category" class="form-rounded" placehoder="Category"style=" width:180px; height:30px;text-align-last:center;">
    <option value="Personal Care">Personal Care</option>
    <option value="Laptops">Laptops</option>
    <option value="Art Supplies">Art Supplies</option>
   
  </select><br>
<br><input type="text"  placeholder="Name" class="form-rounded" name="name"><br><br>
<input type="text"  placeholder="Description" class="form-rounded" name="description"><br><br>
<input type="text"  placeholder="Price" class="form-rounded" name="price"><br><br>
<br><br><br><br><br>
<div style="float: right;">
<input type="submit" value="Add" class="form-rounded"  style="background-color:#000000bf;color:white;" ><br><br>

</form>

<form action="/grizzly-store-admin-web/list.jsp" >
  
  <input type="submit"  value="Cancel" class="form-rounded" style="float: right;">
  
</form>
</div>
</div>
<br>
<br>
<br>


</div>
</div>


</body>
</html>