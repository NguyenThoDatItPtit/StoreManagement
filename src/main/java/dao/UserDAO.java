package dao;

import model.User;
import util.DBConnect;
import java.sql.*;

public class UserDAO {

	public User login(String u, String p) {

		try (Connection con = DBConnect.getConnection()) {

			String sql = "select * from users where username=? and password=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u);
			ps.setString(2, p);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean register(User u) {

		try (Connection con = DBConnect.getConnection()) {

			String sql = "insert into users(username,password,email,phone) values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPhone());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}