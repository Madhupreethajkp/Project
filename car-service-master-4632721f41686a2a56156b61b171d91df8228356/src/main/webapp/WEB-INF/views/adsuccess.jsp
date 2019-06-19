 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ include file = "adheader.html" %>
       
  <!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

<center>
<div class="container "  >
  
  <form action=" /car-service/add" method="post">
    <div class="form-group">
      <label for="email">Center Name:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter service center name"  name="centerName ">
    </div>
     <br/> <br/>
     
   
    <div class="form-group">
     <label for="email">Type:</label>
      <label><input type="checkbox" value="Washing" name="type">Washing  <input type="email" class="form-control" id="email"   name="centerName "></label>
    </div>
     <br/> <br/>
    <div class="form-group">
      <label><input type="checkbox" value="Oiling" name="type">Oiling  <input type="email" class="form-control" id="email"   name="centerName "></label>
    </div>
     <br/> <br/>
    <div class="form-group ">
      <label><input type="checkbox" value="Repairing" name="type" >Repairing  <input type="email" class="form-control" id="email"    name="centerName "></label>
    </div>
     <br/> <br/>
    <div class="form-group">
      <label for="pwd"> Availablity:</label>
      <input type="date" class="form-control" id="pwd" placeholder="Enter availablity" name="trip-start">
    </div>
     <br/> <br/>
     <div class="form-group">
      <label for="email">Rating:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter rating" name="rating">
    </div>
     <br/> <br/>
    <button type="submit" class="btn btn-default" name="ADD">Submit</button>
     <br/> <br/>
  </form>
</div>
</center>
</body>
</html>  -->

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
  
  body{
  background-image:url("images/caree.jpg");
  background-repeat:no-repeat;
    background-size:150%;
   z-index: -2;
   
    color:#f1f1f1;
  }
  
  div.container{
  
  width:600px;
  height:800px;
  background-color:#686868;
 opacity:0.9;
 padding-right: 230px;
  }
 
  </style>
</head>
<body>
<center>
 <h1><b>ADD SERVICE DETAILS</b></h1></center>
<div class="container" >
 <div class="row"> 
 <div class="col-sm-4"></div>
 <div class="col-sm-4">
  <form action="/car-service/addCenter" commandName="center" method="post">
 
  <br><br>
    <div class="form-group">
      Center Name:
      <input type="text" class="form-control" placeholder="Enter service center name"  name="centerName" style="width:317px">
    </div>
   <br><br>
  <b> Type:</b>   <div class="checkbox">
      <input type="checkbox" value="Washing" name="type">Washing  <input type="text" class="form-control"    name="cost" style="width:300px">
    </div>
    <div class="checkbox">
   <input type="checkbox" value="Oiling" name="type">Oiling  <input type="text" class="form-control"    name="cost1" style="width:300px">
    </div>
    <div class="checkbox  ">
      <input type="checkbox" value="Repairing" name="type" >Repairing  <input type="text" class="form-control"    name="cost2" style="width:300px">
    </div>
    <br><br>
    <div class="form-group">
     Availablity:
      <input type="date" class="form-control"  placeholder="Enter availablity" name="availability" style="width:317px">
    </div>
    <br><br>
     <div class="form-group">
      Rating:
      <input type="text" class="form-control" placeholder="Enter rating" name="rating" style="width:317px">
    </div>
    <br><br>
    <button type="submit" class="btn btn-default" name="ADD">Add Service</button>
    <br><br>
    <a href="<c:url value='/viewRequests'/>" style="color:lightgreen">View Requests</a>
  </form>
  </div>
 <div class="col-sm-4"></div>
  </div>
  
</div>

</body>
</html>



