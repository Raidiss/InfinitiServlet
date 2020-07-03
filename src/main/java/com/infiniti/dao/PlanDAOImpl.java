package com.infiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infiniti.util.JDBCConnection;

import com.infiniti.models.Plan;

public class PlanDAOImpl implements PlanDAO {

	public static Connection conn = JDBCConnection.getConnection();

	public Plan getPlan(int id) {

		try {

			String sql = "SELECT * FROM plans WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			//PreparedStatement is ready to be executed.
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Plan p = new Plan(rs.getInt("ID"), rs.getInt("SPEED"), rs.getString("NAME"), rs.getFloat("PRICE"),
						rs.getString("DESCRIPTION"));
				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Plan getPlan(String name) {

		try {

			String sql = "SELECT * FROM plans WHERE name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Plan p = new Plan(rs.getInt("ID"), rs.getInt("SPEED"), rs.getString("NAME"), rs.getFloat("PRICE"),
						rs.getString("DESCRIPTION"));
				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Plan> getAllPlans() {

		try {

			String sql = "SELECT * FROM plans";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<Plan> plans = new ArrayList<Plan>();

			while (rs.next()) {
				plans.add(new Plan(rs.getInt("ID"), rs.getInt("SPEED"), rs.getString("NAME"), rs.getFloat("PRICE"),
						rs.getString("DESCRIPTION")));
			}
			return plans;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public boolean addPlan(Plan p) {

		try {

			String sql = "INSERT INTO plans (speed, price, name, description) VALUES (?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(p.getSpeed()));
			ps.setString(2, Float.toString(p.getPrice()));
			ps.setString(3, p.getName());
			ps.setString(4, p.getDescription());

			ResultSet rs = ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updatePlan(Plan change) {
		try {
			String sql = "UPDATE plans SET name = ?, speed = ?, description = ?, price = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, change.getName());
			ps.setString(2, Integer.toString(change.getSpeed()));
			ps.setString(3, change.getDescription());
			ps.setString(4, Float.toString(change.getPrice()));
			ps.setString(5, Integer.toString(change.getId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deletePlan(int id) {
		
		try {
			String sql = "DELETE plans WHERE id = ?";
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