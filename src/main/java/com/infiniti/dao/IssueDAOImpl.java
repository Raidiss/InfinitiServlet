package com.infiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infiniti.models.Issue;
import com.infiniti.util.JDBCConnection;

public class IssueDAOImpl implements IssueDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Issue getIssue(int id) {
		
		try {

			String sql = "SELECT * FROM issues WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// return the issue from this result set
				Issue i = new Issue(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getString("STATUS"));
				return i;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Issue> getAllIssues() {
		
		try {

			String sql = "SELECT * FROM issues";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<Issue> issuesReport = new ArrayList<Issue>();

			while (rs.next()) {
				issuesReport.add(new Issue(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getString("STATUS")));
			}
			return issuesReport;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean createIssue(Issue i) {
		
		try {

			String sql = "INSERT INTO issues (description, status) VALUES (?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, i.getDescription());
			ps.setString(2, i.getStatus());
			
			ResultSet rs = ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean changeIssueStatus(Issue change) {
		
		try {
			String sql = "UPDATE issues SET description = ?, status = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, change.getDescription());
			ps.setString(2, change.getStatus());
			ps.setInt(3, change.getId());

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteIssue(int id) {
		
		try {
			String sql = "DELETE issues WHERE id = ?";
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
