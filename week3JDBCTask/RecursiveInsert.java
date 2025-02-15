package week3JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecursiveInsert {
	// database connection details
    private static final String URL = "databse_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // SQL query to insert a row into the table
    private static final String INSERT_SQL = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";

    public static void main(String[] args) {
        List<String[]> rows = new ArrayList<>();
        rows.add(new String[]{"Value1", "Value2"});
        rows.add(new String[]{"Value3", "Value4"});
        rows.add(new String[]{"Value5", "Value6"});
        // start recursive insertion
        insertRowsRecursively(rows, 0);
    }
    private static void insertRowsRecursively(List<String[]> rows, int index) {
        // check if all rows are processed
        if (index >= rows.size()) {
            System.out.println("all rows inserted successfully.");
            return;
        }
        // get the current row
        String[] row = rows.get(index);
        // insert the current row
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            // set values for the preparedstatement
            preparedStatement.setString(1, row[0]);
            preparedStatement.setString(2, row[1]);
            // execute the insert
            preparedStatement.executeUpdate();
            System.out.println("row inserted: " + row[0] + ", " + row[1]);
            // recursively insert the next row
            insertRowsRecursively(rows, index + 1);
        } catch (SQLException e) {
            System.err.println("error inserting row: " + e.getMessage());
        }
    }
}
