package Database;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewEmployee
 */
@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><head><title>Viewing Employees</title></head><body>");
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");

			String sql = "SELECT * FROM employee1";
			PreparedStatement ps = con.prepareStatement(sql);
					 
		   ResultSet rs =  ps.executeQuery();
		   out.println("<h1>Employees</h1>");
		   out.println("<table border=1 width=50% height=25%>");  
           out.println("<tr><th>EMP ID</th><th>EMP NAME</th><th>SALARY</th><th>DEPT</th><th>Address</th><th>Phone Number</th><tr>"); 
		    
		   while(rs.next()) {
			   
			   String emp = rs.getString("empid");
			   String empname = rs.getString("ename");
			   String sal = rs.getString("salary");
			   String dept = rs.getString("dept");
			   String address = rs.getString("address");
			   String pn = rs.getString("mobile");
			  
			   out.println("<tr><td>" + emp + "</td><td>" + empname + "</td><td>" + sal + "</td><td>" + dept +  "</td><td>" + address + "</td><td>" + pn + "</td></tr>"); 
		   }

		   out.println("</table>");  
           out.println("</body></html>");  
           con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}