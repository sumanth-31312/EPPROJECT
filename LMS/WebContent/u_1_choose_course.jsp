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
    
        <h2> Courses</h2>
        <table>
        <% 
 
		try {
			String  year = request.getParameter("year");
			String  sem = request.getParameter("sem");
		       
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","lms","lms123");
			
			String sql = "select * from courses where year = ? and sem = ?";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, year);
			pstmt.setString(2, sem);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
		%>
        	<tr>
				<th>Course Id</th>
				<td><%= rs.getString(1) %></td>
			</tr>
			<tr>
					<th>Course Name</th>
					<td><%= rs.getString(2) %></td>
			</tr>
			
		<%	
			
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

</body>
</html>