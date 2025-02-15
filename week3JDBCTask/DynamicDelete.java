package week3JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicDelete {
	// database connection details
    private static final String URL = "database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    // SQL query to delete a row from the table
    private static final String DELETE_SQL = "DELETE FROM your_table WHERE id = ?";
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.print("enter the ID of the row to delete: ");
        int id = sc.nextInt();
        // delete the row from the database
        deleteRow(id);
        // close the scanner class
        sc.close();
    }
    private static void deleteRow(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            // set the ID in the preparedstatement
            preparedStatement.setInt(1, id);
            // execute the delete
            int rowsDeleted = preparedStatement.executeUpdate();
            // check if the row was deleted successfully
            if (rowsDeleted > 0) {
                System.out.println("row deleted successfully.");
            } else {
                System.out.println("no row found with ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("error deleting row: " + e.getMessage());
        }
    }
}
