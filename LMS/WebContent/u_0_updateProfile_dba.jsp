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
<title>Update Profile</title>
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
    
        <% 
 
		try {
			String  username = request.getParameter("uname");
		     String password = request.getParameter("pword");
		     String email = request.getParameter("email");
		     String phnum = request.getParameter("phnum");
		     String name = request.getParameter("name");
		     String gender = request.getParameter("gender");
		       
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","lms","lms123");
			
			String sql = "update RegisterJDBC set email = ?, mobile = ?, name = ?, gender = ?, password = ? where username = ?";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, phnum);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setString(5, password);
			pstmt.setString(6, username);
	
			int count = pstmt.executeUpdate();
				
				if(count>0){
					out.println("<h3>Successfully updated Profile</h3>");
					out.println("<h3>Click <a href='u_profile.jsp'> here</a> to view profile</h3>");
				} else {
					out.println("<h3>update failed</h3>");
				}	
	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		%>
</body>
</html>