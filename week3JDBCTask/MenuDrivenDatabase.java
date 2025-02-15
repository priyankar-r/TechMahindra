package week3JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuDrivenDatabase {
	// database connection details
    private static final String URL = "database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    // table and column names
    private static final String TABLE_NAME = "your_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN1 = "column1";
    private static final String COLUMN2 = "column2";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a new Row");
            System.out.println("2. Update a Row");
            System.out.println("3. Delete a Row");
            System.out.println("4. Select a Row");
            System.out.println("5. Exit");
            System.out.print("enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    insertRow(sc);
                    break;
                case 2:
                    updateRow(sc);
                    break;
                case 3:
                    deleteRow(sc);
                    break;
                case 4:
                    selectRow(sc);
                    break;
                case 5:
                    System.out.println("exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("invalid choice. Please try again.");
            }
        } while (choice != 5);
        sc.close();
    }
    private static void insertRow(Scanner sc) {
        System.out.print("enter value for " + COLUMN1 + ": ");
        String column1Value = sc.nextLine();
        System.out.print("enter value for " + COLUMN2 + ": ");
        String column2Value = sc.nextLine();
        String insertSQL = "INSERT INTO " + TABLE_NAME + " (" + COLUMN1 + ", " + COLUMN2 + ") VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, column1Value);
            preparedStatement.setString(2, column2Value);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("a new row is inserted successfully.");
            }
        } catch (SQLException e) {
            System.err.println("error inserting row: " + e.getMessage());
        }
    }
    private static void updateRow(Scanner sc) {
        System.out.print("enter the ID of the row to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("enter new value for " + COLUMN1 + ": ");
        String column1Value = sc.nextLine();
        System.out.print("enter new value for " + COLUMN2 + ": ");
        String column2Value = sc.nextLine();
        String updateSQL = "UPDATE " + TABLE_NAME + " SET " + COLUMN1 + " = ?, " + COLUMN2 + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, column1Value);
            preparedStatement.setString(2, column2Value);
            preparedStatement.setInt(3, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("row updated successfully.");
            } else {
                System.out.println("no row found with ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("error updating row: " + e.getMessage());
        }
    }
    private static void deleteRow(Scanner sc) {
        System.out.print("enter the ID of the row to delete: ");
        int id = sc.nextInt();
        String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("row deleted successfully.");
            } else {
                System.out.println("no row found with ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("error deleting row: " + e.getMessage());
        }
    }
    private static void selectRow(Scanner scanner) {
        System.out.print("enter the ID of the row to select: ");
        int id = scanner.nextInt();
        String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("row found:");
                System.out.println(COLUMN_ID + ": " + resultSet.getInt(COLUMN_ID));
                System.out.println(COLUMN1 + ": " + resultSet.getString(COLUMN1));
                System.out.println(COLUMN2 + ": " + resultSet.getString(COLUMN2));
            } else {
                System.out.println("no row found with ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("error selecting row: " + e.getMessage());
        }
    }
}
