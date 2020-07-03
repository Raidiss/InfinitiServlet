package com.infiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infiniti.models.Plan;
import com.infiniti.models.User;
import com.infiniti.util.JDBCConnection;

public class UserDAOImpl implements UserDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public User getUser(int id) {
		try {

			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			//PreparedStatement is ready to be executed.
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("FIRSTNAME"),  rs.getString("LASTNAME"));
				return u;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User getUser(String username) {
	 try {

		String sql = "SELECT * FROM users WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, username);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			User u = new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("FIRSTNAME"),  rs.getString("LASTNAME"));
			return u;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return null;
}

	@Override
	public List<User> getAllUsers() {
		try {

			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();

			while (rs.next()) {
				users.add(new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("FIRSTNAME"),  rs.getString("LASTNAME")));
			}
			return users;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean addUser(User u) {
		try {

			String sql = "INSERT INTO users (username, firstname, lastname) VALUES (?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			
			ResultSet rs = ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateUser(User change) {
		try {
			String sql = "UPDATE users SET plan_id = ?, username = ?, firstname = ?, lastname = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, change.getPlanId());
			ps.setString(2, change.getUsername());
			ps.setString(3, change.getFirstName());
			ps.setString(4, change.getLastName());
			ps.setInt(5, change.getId());
			
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deleteUser(int id) {
		try {
			String sql = "DELETE users WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
