import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class pratice {
    static String url="jdbc:mysql://localhost:3306/bandi";
    static String pass="preetham123";
    static String username="root";
   
    public static void main(String[] args) {
        Connection conn=null;
        Statement smt=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url, username, pass);
            smt=conn.createStatement();
            String q1="create table test1(" +
            "id int AUTO_INCREMENT PRIMARY KEY ,"+
            "name varchar(50) "+
            ")";
            smt.executeUpdate(q1);
            System.out.println("table  created sucessfully");
            String q2="insert into test1(id,name) values " +
            "(1,'preetham')," +
            "(2,'naveen') ";
            smt.executeUpdate(q2);
            System.out.println("data inserted sucesfully");
            String q3="select * from test1";
            ResultSet rs= smt.executeQuery(q3);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                System.out.println("id: "+id);
                System.out.println("name: "+ name);
            }
            
            



        }catch(ClassNotFoundException c){
            System.out.println(c);
        }catch(Exception se){
            System.out.println(se);
        }
    
       
        
    }
    
}
