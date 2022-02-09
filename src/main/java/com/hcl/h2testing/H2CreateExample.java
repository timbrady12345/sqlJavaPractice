package com.hcl.h2testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create Statement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class H2CreateExample {

	private static final String createTableSQL = "create table employees (" + "  id  int primary key,"
			+ "  empname varchar(20)," + "  dob varchar(20)," + "  salary int," + "  age int ) ";

	private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees"
			+ "  (id, empname, dob, salary, age) VALUES " + " (?, ?, ?, ?, ?);";

	private static final String SELECT_QUERY = "select id,empname,dob,salary,age from employees where id =?";

	private static final String SELECT_ALL_QUERY = "select id,empname,dob,salary,age from employees";
	
	private static final String UPDATE_QUERY = "update employees set empname = 'Tim' where id = 2";
	
	private static final String DELETE_QUERY = "delete from employees where id = 1";
	
	private static final String SPECIFIC_QUERY = "select id,empname,dob,salary,age from employees where salary > 5000 and age > 21 and empname like 'B%'";
	
	public static void main(String[] argv) throws SQLException {
		H2CreateExample createTableExample = new H2CreateExample();

		try (Connection connection = H2JDBCUtils.getConnection()) {
			createTableExample.createTable(connection);
			createTableExample.insertRecord(connection);
			createTableExample.selectRecord(connection);
		} catch (SQLException e) {
			// print SQL exception information
			H2JDBCUtils.printSQLException(e);
		}

	}

	public void createTable(Connection connection) throws SQLException {

	//System.out.println(createTableSQL);
		// Step 1: Establishing a Connection
		try {
			// Step 2:Create a statement using connection object
			Statement statement = connection.createStatement();
			{

				// Step 3: Execute the query or update query
				statement.execute(createTableSQL);
			}
		} catch (SQLException e) {
			// print SQL exception information
			H2JDBCUtils.printSQLException(e);
		}
	}

	// information
	public void insertRecord(Connection connection) throws SQLException {
	//System.out.println(INSERT_EMPLOYEES_SQL);
		// Step 1: Establishing a Connection
		try {
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "Tim");
			preparedStatement.setString(3, "07/22/2000");
			preparedStatement.setInt(4, 60000);
			preparedStatement.setInt(5, 21);
		//System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_EMPLOYEES_SQL);
			preparedStatement2.setInt(1, 2);
			preparedStatement2.setString(2, "Bim");
			preparedStatement2.setString(3, "2/27/1974");
			preparedStatement2.setInt(4, 5001);
			preparedStatement2.setInt(5, 32);
		//System.out.println(preparedStatement2);
			// Step 3: Execute the query or update query
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {

			// print SQL exception information
			H2JDBCUtils.printSQLException(e);
		}

		// Step 4: try-with-resource statement will auto close the connection.
	}

	public void selectRecord(Connection connection) throws SQLException {
		try {

			// Step 2:Create a statement using connection object
		//PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
		//preparedStatement.setInt(1, 1);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String empname = rs.getString("empname");
				String dob = rs.getString("dob");
				String salary = rs.getString("salary");
				String age = rs.getString("age");
				System.out.println(id + "," + empname + "," + dob + "," + salary + "," + age);
			}
			preparedStatement = connection.prepareStatement(SPECIFIC_QUERY);
			System.out.println(preparedStatement);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String empname = rs.getString("empname");
				String dob = rs.getString("dob");
				String salary = rs.getString("salary");
				String age = rs.getString("age");
				System.out.println(id + "," + empname + "," + dob + "," + salary + "," + age);
			}
			preparedStatement = connection.prepareStatement(UPDATE_QUERY);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String empname = rs.getString("empname");
				String dob = rs.getString("dob");
				String salary = rs.getString("salary");
				String age = rs.getString("age");
				System.out.println(id + "," + empname + "," + dob + "," + salary + "," + age);
			}
			preparedStatement = connection.prepareStatement(DELETE_QUERY);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String empname = rs.getString("empname");
				String dob = rs.getString("dob");
				String salary = rs.getString("salary");
				String age = rs.getString("age");
				System.out.println(id + "," + empname + "," + dob + "," + salary + "," + age);
			}
		} catch (SQLException e) {
			H2JDBCUtils.printSQLException(e);
		}
	}
}
