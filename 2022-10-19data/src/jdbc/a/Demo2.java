package jdbc.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo2 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist = true";
		String user = "root";
		String password = "1234";
		//	String sql = "insert into person values (105,'Mira', 88)";
String sql = "create table `person`(`id` int primary key auto_increment, `name` varchar(20), `age` int)";
try(Connection con = DriverManager.getConnection(url, user, password);) {
	
	Statement stmt = con.createStatement();
	stmt.executeUpdate(sql);
System.out.println(sql);
} catch (SQLException e) {
	e.printStackTrace();
}

	}

}
