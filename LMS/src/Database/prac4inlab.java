package Database;
import java.sql.*;
import java.util.*;

//190031251-SUSHANTH

public class prac4inlab {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		Statement stm=null;
		try {
			//load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection establishment
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
			System.out.println("Connection Success");
			CallableStatement csmt = conn.prepareCall("{call sales_pro(?,?,?)}");
			stm = conn.createStatement();
			System.out.println("Enter no.of items bought");
			int n=s.nextInt();
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter item_id=");
				int item_id=s.nextInt();
				System.out.println("Enter item_name=");
				String item_name=s.next();
				System.out.println("Enter cost_of_item=");
				int cost_of_item=s.nextInt();
			    csmt.setInt(1, item_id);
		        csmt.setString(2, item_name);
		        csmt.setInt(3, cost_of_item);
				csmt.execute();
				System.out.println("Inserted values successfully");
			}
			System.out.println("\n");
			String query="SELECT SUM(cost_of_item) FROM sales";
			ResultSet total = stm.executeQuery(query);
			total.next();
			System.out.println("Total Cose="+total.getString(1));
			System.out.println("\n");
			System.out.println("Listening the items bought");
			String query1="SELECT * FROM sales";
			ResultSet rs=stm.executeQuery(query1);
			while(rs.next())
			{
				int item_id =rs.getInt("item_id");
				String item_name =rs.getString("item_name");
				int cost_of_item=rs.getInt("cost_of_item");
				System.out.println("item_id="+item_id);
				System.out.println("item_name="+item_name);
				System.out.println("cost_of_item="+cost_of_item);
			}
			rs.close();
			System.out.println("Execution Completed");
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
