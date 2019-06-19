<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ include file = "header.html" %>
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


background-color:#f1f1f1;
opacity:5;
	background-repeat: no-repeat;
	background-size:100%;
	background-position:center;
}
img{
opacity:0.5;
filter:alpha(opacity=50);}

</style>
 <script type="text/javascript">

 
 $(document).ready(function() {        
     $(".chkEdit").click(function(event) {
         var total = 0;
         $(".chkEdit:checked").each(function() {
             total += parseInt($(this).val());
         });
         
         if (total == 0) {
             $('#amount').val('');
         } else {                
             $('#amount').val(total);
         }
     });
 });    


 $(document).on('change', '.chkView', function() {
     $(this).closest('tr').find('.chkEdit').prop('disabled', !this.checked);
 })

 </script>



  
</head>
<body>

<center><h1><b>SERVICE CENTER DETAILS</b></h1></center>
<div class="container-fluid">

 
 <table class="table table-bordered">
    <thead>
      <tr>

<th>SERVICE ID</th>
<th   width="300px"  align="center">CENTER NAME</th>
<th  width="200px" align="center">WASHING COST</th>
<th   width="200px"  align="center">OILING COST</th>
<th   width="200px" align="center">REPAIRING COST</th>
<th    align="center">AVAILABILITY</th>
<th   align="center">RATING</th>
<th align="center">REQUEST GENERATION</th>
<th align="center"> VIEW </th>





</tr>
 
    </thead>
    <tbody>
    <c:forEach items="${serList}" var="ser">
    
      <tr>


<td  >${ser.serviceId } </td>
<td  >${ser.centerName}</td>
<td >${ser.cost}&nbsp;&nbsp;&nbsp;</td>
<td  >${ser.cost1}&nbsp;&nbsp;&nbsp;</td>
<td  >${ser.cost2}&nbsp;&nbsp;&nbsp;</td>

<td  align="center">${ser.availability}</td>
<td   align="center">${ser.rating}</td>



<td> <a href="<c:url value='/confirmRequest/${ser.serviceId}'/>" "style=color:#4682B4">GENERATE REQUEST</a></td>
<td><a href="<c:url value='/viewStatus'/>">View Status</a></td>
</tr>
</c:forEach>
</tbody>
</table>


</div>
</body>
</html>