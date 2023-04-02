package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String url = "jdbc:mysql://localhost:3306/db3";
String user = "root";
String password = "1234";

String sql = "insert into users values(0, 'Avi', 'avi@email')";

try (Connection connection = DriverManager.getConnection(url, user, password);){
	
	Statement stmt = connection.createStatement();
	stmt.executeUpdate(sql);
	System.out.println(sql);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println(sql);
}

	}

}
