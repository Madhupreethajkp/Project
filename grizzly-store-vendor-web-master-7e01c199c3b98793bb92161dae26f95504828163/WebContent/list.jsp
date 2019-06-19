<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  
<head>
<link rel="stylesheet" type="text/css" href="cssfiles/form.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.html" %> 

<style>
.rectangle {
  height: 650px;
  width: 325px;
  background-color: #D3D3D3;
}
.picture {
  height: 100px;
  width: 100px;
  background-color: #B8B8B8;
  }
table
{
border-collapse:collapse;
}
table th
{
border-right:2.5px solid #D1D5D5;
}
table th:last-child
{
border-right:0;
}
table th:nth-child(6)
{
border-right:0;
}
table th:nth-child(7)
{
border-right:0;
}
table td
{
border:2.5px solid #D1D5D5;
border-left:0;
}
table tr:first-child td
{
border-top:0;
}
table tr:last-child td
{
border-bottom: 0;
}
table tr td:last-child
{
border-right:0;
}
table tr td:nth-child(6)
{
border-right:0;
}
table tr td:nth-child(7)
{
border-right:0;
}
table td:first-child
{
border-right:0;
border-bottom:0;
}
table th:first-child
{
border-right:0;
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


<div class="col-md-8">
  <a href="/grizzly-store-vendor-web/ProductController"><input type="button" value="PRODUCT" class="tab"></a>
  <a href="/grizzly-store-vendor-web/VendorController"><input type="button" value="VENDOR" class="tab"></a>
  <a href="#home"><input type="button" value=" " class="tab"></a>
  <br><br><br>

<form action="/grizzly-store-vendor-web/product.jsp">

  <select name="category" class="form-rounded" placehoder="Choose Action" style="padding-left:40px;">
    <option value="c">Choose Action</option></select>
   &emsp;&emsp;&emsp;&emsp;
<input type="text" name="n2" placeholder="Category name" class="form-rounded">&emsp;&emsp;&emsp;&emsp;

<select name="category" class="form-rounded" placehoder="sort by">
    <option value="s">sort by</option></select>
   &emsp;&emsp;
<input type="submit" value="AddProduct" class="form-rounded" style="float: right;background-color:#000000bf;color:white;">
</form>

<c:if test="${!empty prodList }">

 <table  >
<tr>
<th width="20"></th>
<th width="150">Products List</th>
<th width="150">Brand</th>
<th width="150">Category</th>
<th width="80">Rating</th>

</tr>
<c:forEach items="${prodList}" var="product">
<tr>
              <td><input type="radio" name="product"></td>
<td>${product.name}</td>
<td>${product.brand}</td>
<td>${product.category}</td>
<td>${product.rating}</td>
<td><form action="/grizzly-store-vendor-web/ViewController?pname=${product.name}"  method="post"  style="padding-left:20px;"><input type="submit" class="form-rounded" value="View" style="border-radius:20px;"></form>
</td> 
<td><form action=""  style="padding-left:20px;" ><input type="submit" class="form-rounded" value="Block" style="border-radius:20px;"></form></td> 
<td><form action="/grizzly-store-vendor-web/DeleteProductController?pname=${product.name}"  method="post"  style="padding-left:20px;"><input type="submit" class="form-rounded" value="Remove"  style="border-radius:20px;"></form>
</tr>
</c:forEach>
</table>
</c:if>

</div>

</body>
</html>