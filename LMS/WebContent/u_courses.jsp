<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%
    response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires","0");
	if(session == null || session.getAttribute("un") == null || session.getAttribute("pw") == null){
		response.sendRedirect("error.html");	
	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
<link rel='stylesheet' href='styles.css'>
</head>
<body>
<div class="topnav">
  <a href="lmslogin2.html">HOME</a>
  <a href="u_profile.jsp">PROFILE</a>
  <a href="u_courses.jsp">COURSES</a>
  <a href="lmsnotifications.html">GRADES</a>
  <a href="lmscontact.html">SUBMISSIONS</a>
  <a href="LogoutJDBC" style="float:right">Log Out</a>
</div><br>
   
        <h2>Select Course</h2>
        	<form method="post"  action='u_1_choose_course.jsp'>
<hr>

                      <label for="year"> Select Year AND SEM  </label>
                    <div>
                       
                			 <select name="year" id="year">
                			 		<option>Select Year</option>
                			 		<option value="1st">1st</option>
                			 		<option value="2nd">2nd</option>
                			 		<option value="3rd">3rd</option>
                			 		<option value="4th">4th</option>
                		       
                		        </select><br>
                		         <select name="sem" id="sem">
                			 		<option>Select Sem</option>
                		        	<option value="even">Even</option>
                			 		<option value="odd">odd</option>
                		        </select>
   						
                    </div>
 
                    <input type="submit" value="Search">

                </form>
    </div>
</body>
</html>