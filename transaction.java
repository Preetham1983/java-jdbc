import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class transaction {
    private static Savepoint sp1;

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement checkStockStmt = null;
        PreparedStatement updateStockStmt = null;
        PreparedStatement insertOrderStmt = null;
        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "preetham123");
            conn.setAutoCommit(false); 
            // conn.setSavepoint();
            int userId = 1;
            int productId = 2;
            int orderQuantity = 2;

        
            checkStockStmt = conn.prepareStatement("SELECT stock FROM Products p WHERE p.product_id = ?");
            checkStockStmt.setInt(1, productId);
            ResultSet rs = checkStockStmt.executeQuery();
            if (rs.next()) {
                int stock = rs.getInt("stock");
                if (stock >= orderQuantity) {
                   
                    updateStockStmt = conn.prepareStatement("UPDATE Products SET stock = stock - ? WHERE product_id = ?");
                    updateStockStmt.setInt(1, orderQuantity);
                    updateStockStmt.setInt(2, productId);
                    updateStockStmt.executeUpdate();
                    System.out.println("Order placed successfully.");
                    Savepoint sp1=conn.setSavepoint("sp1");
                        
                    
                    
              
                    insertOrderStmt = conn.prepareStatement("INSERT INTO Orders (user_id, product_id, quantity) VALUES (?, ?, ?)");
                    insertOrderStmt.setInt(1, userId);
                    insertOrderStmt.setInt(2, productId);
                    insertOrderStmt.setInt(3, orderQuantity);
                    insertOrderStmt.executeUpdate();

                   
                    conn.commit();
                    System.out.println("stock updated");
                   
                } else {
                    System.out.println("Insufficient stock for the order.");
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    System.out.println("Rolling back to savepoint...");
                    if (sp1 != null) {
                        conn.rollback(sp1);
                        conn.commit();
                    } else {
                        conn.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (checkStockStmt != null) {
                try {
                    checkStockStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (updateStockStmt != null) {
                try {
                    updateStockStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (insertOrderStmt != null) {
                try {
                    insertOrderStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

