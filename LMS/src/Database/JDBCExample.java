package Database;

import java.sql.*;

public class JDBCExample {
	public static void main(String args[]) {
		
		try {
			//load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection establishment
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","lms","lms123");
			System.out.println("connection success");
			//create statement
			CallableStatement cstmt = conn.prepareCall("{call STUDENT_PRO(?,?) }");
			
			//Give values to ???
			cstmt.setInt(1, 190030056);
			cstmt.setString(2, "RahulSharma");
			
			//execute
			cstmt.execute();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
