<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>
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
<div class="container">
<table class="table">
<thead>
<tr>
<td>Id</td>
<td>Cost1</td>
<td>Cost2</td>
<td>Cost3</td>
<td>Action</td>
</tr>
</thead>
<tbody>
<c:forEach var="a" items="10,20,30">
<tr>
<td><input type="radio" class="chkView"/>View</td>
<td>${a}</td>
<td><input type="checkbox" class="chkEdit" name="cost" value="1000" disabled>1000</td>
<td><input type="checkbox" class="chkEdit" name="cost" value="1000" disabled>1000</td>
<td><input type="checkbox" class="chkEdit" name="cost" value="1000" disabled>1000</td>
<td><input type="text" name="amount" id="amount" /></td>
</tr>
</c:forEach> 
</tbody>
</table>

</div>
</body>
</html>


