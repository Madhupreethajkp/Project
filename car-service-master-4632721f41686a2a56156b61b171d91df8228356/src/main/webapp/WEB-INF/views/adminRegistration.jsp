<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"  %>
    <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<title>User registration</title>
<style>

body{

                            background-image: url('http://www.covenantauto.com/data1/images/1.jpg');
                      background-size:100%;
                      background-repeat: no-repeat;

                      
                     


}
*{
    scroll-behavior: smooth;
    
}

.btnSubmit{
    font-weight: 600;
    color: #fff;
    background-color: #353b48;
}


.form-control{
    background: #d3d3d3 !important;
    border-radius: 100px !important;
    padding: 6px auto !important;
}
.cusgrid{

    display: grid;
    grid-template-columns:repeat(auto-fill,minmax(400px,1fr));
    grid-gap:15px 20px;
}
.error
{
       color: red;
       border: pink;
}
.regForm{
    padding: 5%;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
</style>
<script>
window.history.forward();
function noBack()
{
    window.history.forward();
}
</script>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
  <div class="container  mt-5 mb-5">
        <div class="card shadow ">
            <div class="card-body">
                <div class="card-title"><h4 class="text-center">ADMIN REGISTRATION</h4></div>
                 <!-- Form -->
                 <c:url var="action" value="/admin/add1"></c:url>
                 <form:form class="b1  p-3 mb-2 bg-white rounded " commandName="admin" action="${action}" method="post">
                    <div class="container p-3 cusgrid">
                          <div class="form-group">
                                        <form:label path="fname">Firstname</form:label>
                                        <form:input path="fname" cssClass="form-control"/>
                                        <form:errors path="fname" cssClass="error">
                                        </form:errors>
                          </div>
                          <div class="form-group">
                                        <form:label path="lname">LastName</form:label>
                                        <form:input path="lname" cssClass="form-control"/>
                                        <form:errors path="lname" cssClass="error">
                                        </form:errors>
                          </div>
                          <div class="form-group">
                                        <form:label path="age">age</form:label>
                                        <form:input path="age" cssClass="form-control"/>
                                        <form:errors path="age" cssClass="error">
                                        </form:errors>
                          </div>
                          <div class="form-group">
                                        <form:label path="gender">
                                            <spring:message code="label.gender"/>
                                             </form:label>
                                    <td><form:select path = "gender" name = "gender" cssClass="form-control">
                                         <option value = "NONE">Select</option>
                                         <option value = "MALE">MALE</option>
                                         <option value = "FEMALE">FEMALE</option>   
                                     </form:select>       
                                     </td>
                                    <form:errors path="gender" cssClass="error"></form:errors>
                          </div>
                          <div class="form-group">
                                        <form:label path="contactNo">ContactNo</form:label>
                                        <form:input path="contactNo" cssClass="form-control"/>
                                        <form:errors path="contactNo" cssClass="error">
                                        </form:errors>
                          </div>
                          <div class="form-group">
                                        <form:label path="adminId">AdminId</form:label>
                                        <form:input path="adminId" cssClass="form-control"/>
                                         <form:errors path="adminId" cssClass="error">
                                        </form:errors>
                          </div>
                          
                          <div class="form-group">
                                        <form:label path="password">Password</form:label>
                                        <form:input path="password" cssClass="form-control"/>
                                        <form:errors path="password" cssClass="error">
                                        </form:errors>
                          </div>
                          
                   </div>
                    <div class="form-group text-center">
                        <input type="submit" value="submit" class="btn  btnSubmit" style="width: 100px ;">

                      </div>
                      
                </form:form>
                 <c:url var="action" value="/admin/back"></c:url>
                 <form:form class="b1  p-3 mb-2 bg-white rounded " commandName="admin" action="${action}" method="post">
               
                    <div class="form-group text-center">
                        <input type="submit" value="back" class="btn  btnSubmit" style="width: 100px ;">

                      </div>
                </form:form>
               



            </div>
        </div>
    </div>   
</body>
</html>
