<!DOCTYPE html> 
<html> 
<head> 
    <title>Page Layout</title> 
    <style> 
        .head1 { 
            font-size:40px; 
            color:#009900; 
            font-weight:bold; 
        } 
        .head2 { 
            font-size:17px; 
            margin-left:10px; 
            margin-bottom:15px; 
        } 
        body { 
            margin: 0 auto; 
            background-position:center; 
            background-size: contain; 
        } 
      
        .menu {    
            position: sticky; 
            top: 0; 
            background-color: #778899; 
            padding:10px 0px 10px 0px; 
            color:white; 
            margin: 0 auto; 
            overflow: hidden; 
        } 
        .menu a { 
            float left; 
            color: white; 
            text-align: center; 
            padding: 14px 16px; 
            text-decoration: none; 
            font-size: 20px; 
        } 
        .menu-log { 
            right: auto; 
            float: right; 
        } 
       
      
    </style> 
</head> 
  
<body> 
      
    <!-- Header Section -->
   
    <!-- Menu Navigation Bar -->
    <div class="menu"> 
        <a href="#home">HOME</a> 
        
        <a href="#notification">NOTIFICATIONS</a> 
        <div class="menu-log"> 
       <b>Welcome <%=session.getAttribute("userId")%></b>
            <a href="#login">LOGOUT</a> 
        </div> 
    </div> 
      
    <!-- Body section -->
   
</body> 
</html>                     
