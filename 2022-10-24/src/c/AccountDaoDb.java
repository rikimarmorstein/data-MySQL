package c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDaoDb implements AccountDao {

	private String dburl = "jdbc:mysql://localhost:3306/db3";
	private String dbuser = "root";
	private String dbpassword = "1234";

	@Override
	public void deposit(int accountId, double amount) {
		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);) {
			String sql = "update account set balance = balance + ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// if (Math.random() < 0.5) {
			// throw new RuntimeException("deposit failed - test error");
			// }
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, accountId);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(int accountId, double amount) {
		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);) {
			String sql = "update account set balance = balance - ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// if (Math.random() < 0.5) {
			// throw new RuntimeException("withdraw failed - test error");
			// }
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, accountId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}