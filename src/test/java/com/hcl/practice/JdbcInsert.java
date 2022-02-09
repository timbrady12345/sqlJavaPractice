package com.hcl.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class JdbcInsert {

	private static final String SQL = "INSERT INTO EMPLOYEE "
			+ "(EMPID, EMPNAME, DOB, SALARY, AGE)"
			+ " VALUES (?,?,?,?,?)";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test-server?useSSL=false", "root", "Realsteelfrom2011");
				PreparedStatement ps = conn.prepareStatement(SQL)) {

			ps.setLong(1, 5);
			ps.setString(2, "Tim");
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(4, 60000);
			ps.setLong(5, 21);

			int row = ps.executeUpdate();
			System.out.println("Record has been inserted into the DataBase Table User");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
