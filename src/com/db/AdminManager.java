package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Admin;

public class AdminManager {

	public static ArrayList<Admin> getAllAdmin() {
		ArrayList<Admin> admins = new ArrayList<Admin>();
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement();) {

			String sql = "SELECT * FROM ADMIN ORDER BY ADMIN_ID";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdmin_id(rs.getInt("ADMIN_ID"));
				admin.setName(rs.getString("NAME"));
				admin.setPassword(rs.getString("PASSWORD"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	public static boolean insert(Admin admin) {
		try {
			Connection conn = ConnectionManager.getConnection();

			String sql = "INSERT INTO ADMIN (NAME, PASSWORD) VALUES (?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, admin.getName());
			stmt.setString(2, admin.getPassword());

			int affected = stmt.executeUpdate();

			if (affected == 1) {
				return true;
			} else {
				return false;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean update(Admin admin) {
		try {
			Connection conn = ConnectionManager.getConnection();
			String sql = "update ADMIN set NAME=?, PASSWORD=? where ADMIN_ID=?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, admin.getName());
			stmt.setString(2, admin.getPassword());

			stmt.setInt(3, admin.getAdmin_id());

			int affected = stmt.executeUpdate();

			if (affected == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean delete(int admin_id) {
		try {
			Connection conn = ConnectionManager.getConnection();
			String sql = "DELETE FROM ADMIN WHERE ADMIN_ID = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, admin_id);

			int affected = stmt.executeUpdate();

			if (affected == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Admin getAdminById(int admin_id) {
		Admin admin = new Admin();
		try {
			Connection conn = ConnectionManager.getConnection();
			String sql = "SELECT * FROM ADMIN WHERE ADMIN_ID = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, admin_id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				admin.setAdmin_id(rs.getInt("ADMIN_ID"));
				admin.setName(rs.getString("NAME"));
				admin.setPassword(rs.getString("PASSWORD"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	public static boolean isExist(String name, String password) {
		try {
			Connection conn = ConnectionManager.getConnection();
			String sql = "SELECT * FROM ADMIN WHERE NAME = ? AND PASSWORD = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isNameExist(String name) {
		try {
			Connection conn = ConnectionManager.getConnection();
			String sql = "SELECT * FROM ADMIN WHERE NAME = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, name);
			

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
