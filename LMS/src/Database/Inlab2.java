package Database;
import java.sql.*;
import java.util.Scanner;
public class Inlab2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con =
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
		System.out.println("Connection Success to database");
		System.out.println("Enter 1 to create 'WORKSHOP' table and insert 'student_id'");
		int n = s.nextInt();
		if(n == 1) {
		PreparedStatement st = con.prepareStatement("create table workshop(STUDENT_ID number(10))");
		st.execute();
		System.out.println("Created workshop table");
		Statement stmt = con.createStatement();
		String sql = "select student_id from students";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
		int sid = rs.getInt("STUDENT_ID");
		CallableStatement stm = con.prepareCall("{call students_pro(?)}");
		stm.setInt(1, sid);
		stm.execute();
		System.out.println("Values inserted to workshop table");
		}
		rs.close();
		}
		System.out.println("Enter 2 to UPDATE 'WORKSHOP' table with 'studentname,email' and insert values");
		int m = s.nextInt();
		if(m == 2) {
		Statement stmt = con.createStatement();
		String sql1 = "ALTER TABLE workshop ADD SNAME varchar2(30)";
		stmt.executeUpdate(sql1);
		System.out.println("Added column sname");
		String sql2 = "ALTER TABLE workshop ADD EMAIL varchar2(100)";
		stmt.executeUpdate(sql2);
		System.out.println("Added column email");
		//190030061
		String sql = "select student_id,Student_name,email from students";
		ResultSet rs1 = stmt.executeQuery(sql);
		System.out.println("Resultset");
		while(rs1.next()) {
		int sid1 = rs1.getInt("STUDENT_ID");
		String sname = rs1.getString("student_name");
		String email = rs1.getString("email");
		PreparedStatement stm =
		con.prepareStatement("UPDATE workshop SET sname = ?, email = ? where student_id =?");
		stm.setString(1, sname);
		stm.setString(2, email);
		stm.setInt(3, sid1);
		stm.executeUpdate();
		System.out.println("Values inserted to workshop table");
		}
		rs1.close();
		}
		System.out.println("Enter 3 to DELETE a student details from workshop table");
		int o = s.nextInt();
		if(o == 3) {
		System.out.println("Enter student id to delete student details");
		int std_id = s.nextInt();
		PreparedStatement stm1 = con.prepareStatement("DELETE FROM workshop WHERE student_id = ?");
		stm1.setInt(1, std_id);
		stm1.executeUpdate();
		System.out.println("Student deleted");
		}
		System.out.println("Execution completed!");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		}
