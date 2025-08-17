import java.sql.*;

public class movie {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "preetham123";
    static final String CREATE_DB_QUERY = "CREATE DATABASE cinema";
    static final String CREATE_TABLE_QUERY = 
        "CREATE TABLE cinema.movies (" +
        "id INT AUTO_INCREMENT PRIMARY KEY, " +
        "title VARCHAR(255) NOT NULL, " +
        "release_date DATE NOT NULL)";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to create the database
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query to create a database
            System.out.println("Creating database...");
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_DB_QUERY);
            System.out.println("Database created successfully...");

            // Connect to the newly created database
            conn = DriverManager.getConnection(DB_URL + "cinema", USER, PASS);
            System.out.println(conn);
            stmt=conn.createStatement();
            // Execute a query to create a table
            System.out.println("Creating table in given database...");
            stmt.executeUpdate(CREATE_TABLE_QUERY);
            System.out.println("Table created successfully...");

            // Insert some data into the table
            String insertDataQuery = "INSERT INTO movies (title, release_date) VALUES " +
                                     "('Inception', '2010-07-16'), " +
                                     "('The Matrix', '1999-03-31'), " +
                                     "('Interstellar', '2014-11-07')";
            stmt.executeUpdate(insertDataQuery);
            System.out.println("Data inserted successfully...");

            // Perform a SELECT query
            String selectQuery = "SELECT * FROM movies";
            ResultSet rs = stmt.executeQuery(selectQuery);

            // Extract data from result set
            System.out.println("Retrieving data...");
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date releaseDate = rs.getDate("release_date");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Title: " + title);
                System.out.println(", Release Date: " + releaseDate);
            }
            rs.close();

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

