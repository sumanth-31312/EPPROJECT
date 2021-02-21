package Database;
import java.sql.*;
import java.util.*;

//190031251-SUSHANTH

public class prac4prelab {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		Statement stmt = null;
		try {
			//load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection establishment
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
			System.out.println("Connection Success");
			CallableStatement csmt = conn.prepareCall("{call student1_pro(?,?,?)}");
			stmt = conn.createStatement();
			System.out.println("Enter no.of records to be created");
			int n=s.nextInt();
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter id,name,age");
				long id=s.nextLong();
				String name=s.next();
				int age=s.nextInt();
				csmt.setLong(1, id);
				csmt.setString(2, name);
				csmt.setInt(3, age);
				csmt.execute();
				System.out.println("Inserted values Successfully");
			}
			System.out.println("\n");
			System.out.println("age<21");
			String sql="SELECT id, name, age FROM student1 " + " WHERE age < 21 ";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				int id=rs.getInt("id");
				int age=rs.getInt("age");
				String name=rs.getString("name");
				System.out.println("id="+id);
				System.out.println("name"+name);
				System.out.println("age"+age);
				System.out.println("\n");
			}
			rs.close();
			System.out.println("Query has been completed");
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
