import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();

        try {
            // Insert operation
            String insertQuery = "INSERT INTO mytable (column1, column2) VALUES ('value1', 'value2')";
            dbConnection.insert(insertQuery);

            // Update operation
            String updateQuery = "UPDATE mytable SET column1 = 'new value' WHERE id = 1";
            dbConnection.update(updateQuery);

            // Select operation
            String selectQuery = "SELECT * FROM mytable";
            ResultSet resultSet = dbConnection.select(selectQuery);
            while (resultSet.next()) {
                // Process each row of the result set
                // Example: String value = resultSet.getString("column_name");
                // Example: int value = resultSet.getInt("column_name");
            }
            resultSet.close();

            // Delete operation
            String deleteQuery = "DELETE FROM mytable WHERE id = 1";
            dbConnection.delete(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
