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
<title>Profile</title>
<link rel='stylesheet' href='styles.css'>
</head>
<body>
<div class="topnav">
  <a href="lmslogin2.html">HOME</a>
  <a href="u_profile.jsp">PROFILE</a>
  <a href="u_courses.jsp">COURSES</a>
  <a href="lmsdashboard.html">DASHBOARD</a>
  <a href="lmsnotifications.html">GRADES</a>
  <a href="lmscontact.html">SUBMISSIONS</a>
  <a href="LogoutJDBC" style="float:right">Log Out</a>
</div><br>
    
        <h2> Profile</h2>
        <table>
        <% 
 
		try {
			String  username = (String)session.getAttribute("un");
		     String password = (String)session.getAttribute("pw");
		       
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","lms","lms123");
			
			String sql = "select * from RegisterJDBC where username = ?";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, (String)session.getAttribute("un"));
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
		%>
        	<tr>
				<th>Email</th>
				<td><%= rs.getString(1) %></td>
			</tr>
			<tr>
					<th>Username</th>
					<td><%= rs.getString(2) %></td>
			</tr>
			<tr>
					<th>Name</th>
					<td><%= rs.getString(3) %></td>
			</tr>
			<tr>
					<th>Phone Number</th>
					<td><%= rs.getString(4) %></td>
			</tr>
			<tr>
					<th>Gender</th>
					<td><%= rs.getString(6) %></td>
			</tr>
		<%	
			break;
			}	
	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		%>
	</table>
		<a href='u_0_updateProfile.jsp'>Update Profile</a>

</body>
</html>