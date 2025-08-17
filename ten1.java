

import java.util.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ten1 {
    static final String url="jdbc:mysql://localhost:3306/jdbc1";
    static final String uname="root";
    static final String pass="preetham123";
    Connection conn=null;
        Statement st=null;
    static Scanner sc=new Scanner(System.in);
   
    public static void main(String[] args) {
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url, uname, pass);
            Statement st=conn.createStatement();
            int deptno=sc.nextInt();
            String q1="select emp.ename from emp where emp.deptno="+ deptno+" order by ename asc";
            ResultSet rs=st.executeQuery(q1);
            
            while(rs.next()){
                String s=rs.getString("ename");
                System.out.println(s);
            }

        }catch(Exception e){System.out.println(e);}
      

        
    }
}
