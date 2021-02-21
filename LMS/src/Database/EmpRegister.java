package Database;

import java.io.IOException;
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
 * Servlet implementation class EmpRegister
 */
@WebServlet("/EmpRegister")
public class EmpRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpRegister() {
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
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"ep","ep123");
			System.out.println("Connected to database");
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO employee1 VALUES(?,?,?,?,?,?,?)");
			
			pst.setString(1, (request.getParameter("empid"))); 
			
			pst.setString(2, (request.getParameter("ename"))); 
			
			pst.setString(3, (request.getParameter("salary"))); 
			
			pst.setString(4, (request.getParameter("dept"))); 
			
			pst.setString(5, (request.getParameter("add")));
			
			pst.setString(6, (request.getParameter("mobile"))); 
			
			pst.setString(7, (request.getParameter("pword"))); 
			
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