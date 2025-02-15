package week3JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicUpdate {
	// database connection details
	private static final String URL = "database_url";
	private static final String USER = "your_username";
	private static final String PASSWORD = "your_password";
	// SQL query to update a row in the table
	private static final String UPDATE_SQL = "UPDATE your_table SET column1 = ?, column2 = ? WHERE id = ?";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the ID of the row to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("enter the new value for column1: ");
		String column1Value = sc.nextLine();
		System.out.print("enter the new value for column2: ");
		String column2Value = sc.nextLine();
		// update the row in the database
		updateRow(id, column1Value, column2Value);
		// close the scanner class
		sc.close();
	}

	private static void updateRow(int id, String column1Value, String column2Value) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
			// set the new values and the ID in the preparedstatement
			preparedStatement.setString(1, column1Value);
			preparedStatement.setString(2, column2Value);
			preparedStatement.setInt(3, id);
			// execute the update
			int rowsUpdated = preparedStatement.executeUpdate();
			// check if the row was updated successfully
			if (rowsUpdated > 0) {
				System.out.println("row updated successfully.");
			} else {
				System.out.println("no row found with ID: " + id);
			}

		} catch (SQLException e) {
			System.err.println("error updating row: " + e.getMessage());
		}
	}
}
