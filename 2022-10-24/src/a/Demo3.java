package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/db3";
		String user = "root";
		String password = "1234";

		String sql = "select * from users";

		try (Connection connection = DriverManager.getConnection(url, user, password);){
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			
			int id=rs.getInt(1);//"id"
			String name =  rs.getString(2);
			String email= rs.getString(3);
			System.out.println(id + ", " + name + ", " + email);
			}
			//System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(sql);
		}

	}

}
