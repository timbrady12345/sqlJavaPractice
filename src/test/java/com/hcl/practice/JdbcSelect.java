package com.hcl.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSelect {

	private static final String SQL = "SELECT * FROM test-server.employee";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test-server?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "Realsteelfrom2011");
				PreparedStatement ps = conn.prepareStatement(SQL)) {
			
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			while (rs.next()) {
				
				Employee employee = new Employee();
				employee.setEmpId(rs.getLong("ID"));
				employee.setEmpName(rs.getString("EMPNAME"));
				employee.setDob(rs.getDate("DOB"));
				employee.setSalary(rs.getLong("SALARY"));
				employee.setAge(rs.getLong("AGE"));
				
				employees.add(employee);
			}

			// rows inserted
			System.out.println(employees); 
			System.out.println("users list size is==>" +employees.size()); 

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
