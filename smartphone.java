// import java.sql.Connection;
// import java.sql.Date;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.io.BufferedReader;
// public class App {
//     static final String dburl = "jdbc:mysql://localhost:3306/phone";
//     static final String user = "root";
//     static final String pass = "preetham123";
//     private static final String createtable = 
//         "CREATE TABLE IF NOT EXISTS Smartphones (" +
//         "pid INT AUTO_INCREMENT PRIMARY KEY, " +
//         "smartphone VARCHAR(100), " +
//         "brand VARCHAR(50), " +
//         "model VARCHAR(50), " +
//         "ram VARCHAR(50), " +  
//         "storage VARCHAR(50), " + 
//         "color VARCHAR(50), " +
//         // "free BOOLEAN, " + 
//         "final_price DECIMAL(10, 2))"; 
//     private static final String insertdata = 
//         "INSERT INTO Smartphones (smartphone,brand,model,ram,storage,color,final_price) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
//     static String csvFilePath = "C://Users//bandi//OneDrive//Desktop//jdbc//jdbcdemo//src//smartphones.csv";

//     static String line;
//     static String csvSplitBy = ",";

//     PreparedStatement ps=null;
//     Connection conn=null;
//     public static void main(String[] args) throws Exception,IllegalArgumentException{
       
//         // try {
//         //     Class.forName("com.mysql.cj.jdbc.Driver");
//         //     Connection conn = DriverManager.getConnection(dburl, user, pass);
//         //     Statement sc = conn.createStatement();
//         //     String sql = "CREATE DATABASE jdbc";
//         //     sc.executeUpdate(sql);
//         //     System.out.println("Database created successfully...");
//         // } catch (SQLException se) {
//         //     System.out.println(se.getMessage());
//         // } catch (ClassNotFoundException e) {
//         //     e.printStackTrace();
//         // }
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         Connection conn = DriverManager.getConnection(dburl, user, pass);
//         Statement sc=conn.createStatement();
//         sc.executeUpdate(createtable);
        

//         PreparedStatement ps=conn.prepareStatement(insertdata);

//         // while(){
//         //     ps.setInt(1, 4);
//         //     ps.setString(2, "Kalki 2898AD");
//         //     ps.setDate(3, Date.valueOf("27-06-2024"));

//         // }
      
//         // int h=ps.executeUpdate();

//         // System.out.println(h);
//         BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
//         while ((line = br.readLine()) != null) {
//             String[] data = line.split(csvSplitBy);
//             ps.setString(1, data[0]);
//             ps.setString(2, data[1]);
//             ps.setString(3, data[2]);
//             ps.setString(4, data[3]);
//             ps.setString(5, data[4]);
//             ps.setString(6, data[5]);
//             ps.setDouble(7, Double.valueOf(data[6]));


          
//         }

//         // Execute batch
//         ps.executeBatch();
       
//         br.close();



//     }
// }
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class smartphone {
   
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "preetham123";

   
    private static final String CREATE_DB_SQL = "CREATE DATABASE phone";
    private static final String USE_DB_SQL = "USE phone";
    private static final String CREATE_TABLE_SQL = 
        "CREATE TABLE Smartphones(" +
        "pid INT AUTO_INCREMENT PRIMARY KEY, " +
        "smartphone VARCHAR(5000), " +
        "brand VARCHAR(5000), " +
        "model VARCHAR(4000), " +
        "ram VARCHAR(50), " +  
        "storage VARCHAR(50), " + 
        "color VARCHAR(50), " +
        "is_free BOOLEAN, " + 
        "final_price DECIMAL(10, 2))"; 
    private static final String INSERT_SQL = 
        "INSERT INTO Smartphones (smartphone, brand, model, ram, storage, color, is_free, final_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String COUNT_APPLE_SQL = "SELECT COUNT(*) AS apple_count FROM Smartphones WHERE brand = 'Apple'";
    static final String allmodel="select model as m from Smartphones where brand='Samsung'";
    static final String cheap="SELECT model as m,MIN(final_price) AS min_price FROM Smartphones WHERE brand = 'Nothing' group by model";
    private static final String CSV_FILE_PATH = "jdbcdemo//src//smartphones.csv";
    static final String sortt="select smartphone as sp from Smartphones order by final_price";
    static final String print="select brand as b ,model as m from Smartphones s where s.final_price<=500";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        PreparedStatement pst = null;
        BufferedReader br = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL server
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            st = conn.createStatement();

            // Create database and table
            st.executeUpdate(CREATE_DB_SQL);
            System.out.println("Database created successfully");
            st.executeUpdate(USE_DB_SQL);
            System.out.println("Using database");
            st.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("Table created");

            // Prepare statement for inserting data
            pst = conn.prepareStatement(INSERT_SQL);

            // Read data from CSV file and insert into the database
            br = new BufferedReader(new FileReader(CSV_FILE_PATH));
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); 
                pst.setString(1, values[0].trim()); 
                pst.setString(2, values[1].trim()); 
                pst.setString(3, values[2].trim()); 
                pst.setString(4, values[3].trim());                 pst.setString(5, values[4].trim()); // storage
                pst.setString(6, values[5].trim()); 
                pst.setBoolean(7, values[6].trim().equalsIgnoreCase("true") || values[6].trim().equalsIgnoreCase("yes")); // is_free
                pst.setBigDecimal(8, new java.math.BigDecimal(values[7].trim())); // final_price
                pst.executeUpdate();
            }
            System.out.println("Data inserted successfully from CSV");

          
            ResultSet rs = st.executeQuery(COUNT_APPLE_SQL);
            if (rs.next()) {
                int count = rs.getInt("apple_count");
                System.out.println("Number of Apple brand phones: " + count);
            }
            ResultSet r2=st.executeQuery(allmodel);
            while(r2.next()){
                String s=r2.getString("m");
                System.out.println("models :"+s);
            }
            ResultSet r3=st.executeQuery(cheap);
            while(r3.next()){
                Double price=r3.getDouble("min_price");
                System.out.println("cheap price in nothing :"+price);
            }
            st.executeQuery(sortt);
            System.out.println("sorted sucess");
            String query = "select brand as b, model as m from Smartphones s where s.final_price <= 500";
            ResultSet r4 = st.executeQuery(query);
            while (r4.next()) {
                String s1 = r4.getString("b");
                String s2 = r4.getString("m");

                System.out.print("brand name: " + s1);
                System.out.println("model: " + s2);
            }   


        } catch(SQLException se) { 
            System.out.println(se);
        } catch(ClassNotFoundException c) { 
            System.out.println(c);
        } catch(IOException ioe) {
            System.out.println("Error reading CSV file: " + ioe.getMessage());
        } finally {
            
            try {
                if (br != null) br.close();
                if (pst != null) pst.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
