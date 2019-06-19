<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box}

/* Set height of body and the document to 100% */
body, html {
  height: 100%;
 
  margin-left:50px;
  margin-right:50px;
  font-family: Arial;
}

/* Style tab links */
.tablink {
  background-color: #555;
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  font-size: 17px;
  width: 50%;
}

.tablink:hover {
  background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
  
  display: none;
  padding: 100px 20px;
  height: 100%;
}

#Home {background-color: #f1f1f1;
font-color:red;
}
#News {background-color: #f1f1f1;
}

</style>
</head>
<body>
<center><h1>WELCOME TO CAR SERVICING</h1></center>
<center>
<img src="images/app.jpg" style="float:center;width:1200px;"/></center>
<button class="tablink" onclick="openPage('Home', this)">ADMIN</button>
<button class="tablink" onclick="openPage('News', this)">USER</button>
<div id="Home" class="tabcontent">

 <form    action="/car-service/validate1" style="margin-left:120px;margin-top:100px;" commandname="user" >
 
 Adminname: <input type="text" name="adminId"/><br><br><br>
 
 Password: <input type="password" name="password"/><br><br><br>
 <input type="submit" value="Login"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


  <a href="/car-service/ad">Register</a>
 
  </form>
 
</div>
<div id="News" class="tabcontent">

 <form action="/car-service/validate" style="float:right;margin-right:150px;margin-top:100px;" commandName="user">
 
 Username: <input type="text" name="userId"/><br><br><br>
 
 Password: <input type="password" name="password"/><br><br><br>
 <input type="submit" value="Login"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

 
 
 
  <a href="/car-service/use">Register</a>

  </form>
 
</div>

<script>
function openPage(pageName,elmnt,color) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
   


</body>
</html> 
