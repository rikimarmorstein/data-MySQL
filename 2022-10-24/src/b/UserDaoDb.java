package b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//this class is jdbc implementation for the UsersDao interfece

public class UserDaoDb implements UserDao {

	private String dburl = "jdbc:mysql://localhost:3306/db3";
	private String dbuser = "root";
	private String dbpassword = "1234";

	@Override
	public int create(User user) throws UsersException {
		String sql = "insert into users values(0, '" + user.getName() + "' ,'" + user.getEmail() + "')";
		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rsKeys = stmt.getGeneratedKeys();
			rsKeys.next();
			int id = rsKeys.getInt(1);
			user.setId(id);// set the user id from the database
			return id;
		} catch (SQLException e) {
			throw new UsersException("create user failed", e);
		}

	}

	@Override
	public User read(int id) throws UsersException {
		String sql = "select * from users where id = " + id;
		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				User user = new User();
				user.setId(id);
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				return user;
			} else {
				throw new UsersException("read user faild - id " + id + " not found");
			}

		} catch (SQLException e) {
			throw new UsersException("read user failed", e);
		}

	}

	@Override
	public List<User> readAll() throws UsersException {

		String sql = "select * from users";
		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;

		} catch (SQLException e) {
			throw new UsersException("read user failed", e);
		}
	}

	@Override
	public void update(User user) throws UsersException {
		String sql = "update users set name = '" + user.getName() + "', email = '" + user.getEmail() + "' ";
		sql += "where id = " + user.getId();

		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			throw new UsersException("update user failed", e);
		}
	}

	@Override
	public void delete(int id) throws UsersException {
		String sql = "delete from users where id = " + id;
		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println(sql);
			throw new UsersException("delete user failed", e);
		}

	}

}
