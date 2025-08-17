
import java.util.*;
import java.sql.*;
public class sam {
    static String url="jdbc:mysql://localhost:3306/sem";
    static String pass="preetham123";
    static String username="root";
    Connection conn=null;
    Statement st=null;
    public static void main(String[] args) throws Exception{
       
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url, username, pass);
        Statement st=conn.createStatement();
        String q1="create table student(name varchar(20));";
        st.executeUpdate(q1);
        System.out.println("table created suycess");
        String q2="insert into student values('preetham'),('naveen'),('smaran');";
        st.executeUpdate(q2);
        System.out.println("data inserted");
    


        
    }
}
