package Database;
import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"ep","ep123");
			System.out.println("Connected to database");
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO registeruser VALUES(?,?,?,?,?,?)");
			
			pst.setString(1, (request.getParameter("username"))); 
			
			pst.setString(2, (request.getParameter("email"))); 
			
			pst.setString(3, (request.getParameter("phone"))); 
			
			pst.setString(4, (request.getParameter("branch"))); 
			
			pst.setString(5, (request.getParameter("gender")));
			
			pst.setString(6, (request.getParameter("password"))); 
			
			pst.executeUpdate();
			
			System.out.println("Inserted Values Success fully");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}