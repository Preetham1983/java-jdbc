
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class friends {
    static final String url="jdbc:mysql://localhost:3306/";
    static final String username="root";
    static final String pass="preetham123";
    static final String createdb="create database friends";

    static final String CREATE_TABLE_QUERY = 
        "CREATE TABLE friends.dhost (" +
        "id INT AUTO_INCREMENT PRIMARY KEY," + 
        "name VARCHAR(255) NOT NULL" +
        ")";
    public static void main(String[] args) throws Exception{
         Connection conn = null;
         Statement stmt=null;
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, pass);
            stmt = conn.createStatement();
            stmt.executeUpdate(createdb);

            // Reconnect to the 'friends' database
            conn = DriverManager.getConnection(url + "friends", username, pass);
            stmt = conn.createStatement();

            // Create table
            stmt.executeUpdate(CREATE_TABLE_QUERY);

            System.out.println("Database 'friends' and table 'dhost' created successfully.");


         }catch(SQLException se){
            System.out.println(se.getMessage());
         }catch(Exception e){
            System.out.println(e.getMessage());
         } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
         }
         
         
         
        





    }
        
}

