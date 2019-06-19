<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="cssFiles/form.css">
<title>Insert title here</title>
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
</head>
<body>
<%@ include file="header.html" %>

<br>
<div class="row">
<div class="col-sm-3">
<div class="rectangle">
<div class="navbar" style="background-color:#B8B8B8; height:60px; color:white;"><b>PROFILE</b>
</div><br><br>
<center><div class="picture">
</div></center>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<center><h3><b><%= session.getAttribute("username")%></b></h3>
</center>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img src="images/star.jpg" width="25px"><%= session.getAttribute("rating")%>
<h6 align="center">Contact</h6>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%= session.getAttribute("contact")%>
<h6 align="center">Address</h6>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%= session.getAttribute("address")%>
<br><br><br>
<center><input type="submit"  class="form-rounded" value="Contact Grizzly" style="background-color:#B8B8B8">
</center>
</div>
</div>

<div class="col-sm-7">
  <a href="/grizzly-store-vendor-web/ProductController"><input type="button" value="PRODUCT" class="tab"></a>
  <a href="/grizzly-store-vendor-web/VendorController"><input type="button" value="VENDOR" class="tab"></a>
  <a href="#home"><input type="button" value=" " class="tab"></a>
<br><br><br>


<p><b>${pro.name}</b> by ${pro.brand}&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/icon.jpg" width=25px;></p>



<img src="images/star.jpg" width="25px;">&nbsp;&nbsp;${pro.rating}

<br><br>
<div class="row">
<div class="col-sm-6">
<img src="images/product-view.jpg"/>
</div>
<div class="col-md-4"><h3>Product Description</h3><br>
<p>${pro.description}</p><br><br><br><br><br><br><br><br>
<div ><h4>Rs.${pro.price}- ${pro.discount}off</h4></div><br>
</div>

</div>
</div>
<div class="col-md-2"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<form action="/grizzly-store-vendor-web/ProductController">
<input type="submit" class="form-rounded" value="finish" style="background-color:#000000bf;color:white;"></form><br>
<form action="/grizzly-store-vendor-web/ProductController">
<input type="submit" class="form-rounded" value="cancel"></form><br>
</div>

</div>
</body>
</html>
