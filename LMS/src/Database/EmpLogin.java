package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpLogin
 */
@WebServlet("/EmpLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLogin() {
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
			String userid = request.getParameter("uname");    
		    String pwd = request.getParameter("pword");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"ep","ep123");
			System.out.println("Connected to database");
			 Statement st = con.createStatement();
			 
			 String sql = "select * from employee1 where ename = ? and password = ?";
			 PreparedStatement pst = con.prepareStatement(sql);
			   
			    pst.setString(1, userid);
			    pst.setString(2, pwd);
			    ResultSet resultSet = pst.executeQuery();
			    if(resultSet.next()) {
			    	RequestDispatcher rd = request.getRequestDispatcher("emplogin2.html");
			    	rd.forward(request, response);
			    }else {
			    	RequestDispatcher rd = request.getRequestDispatcher("emplogin.html");
			    	rd.forward(request, response);
			    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
}

private PreparedStatement prepareStatement(String string) {
	// TODO Auto-generated method stub
	return null;
}
}

