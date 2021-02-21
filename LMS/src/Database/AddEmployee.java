package Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			PrintWriter out = response.getWriter();  
	        response.setContentType("text/html");  
	        
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
			System.out.println("Connection to database success");
			
			String empid = request.getParameter("empid");
			String empname = request.getParameter("ename");
			String salary = request.getParameter("salary");
			String dept = request.getParameter("dept");
			String address = request.getParameter("add");
			String pn = request.getParameter("mobile");
			String pword = request.getParameter("pword");
			String sql = "INSERT INTO employee1 VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, empid);
			ps.setString(2, empname);
			ps.setString(3, salary);
			ps.setString(4, dept);
			ps.setString(6, address);
			ps.setString(7, pn);
			ps.setString(8, pword);
			int count = ps.executeUpdate();
			
			if(count > 0) {
				out.println("<html><body><h3>Adding Employee Success Full</h3></body></html>");
			}else {
				out.println("<html><body><h3>Adding Employee Unsuccess Full</h3></body></html>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}