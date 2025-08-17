// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.sql.ResultSet;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.*;
// class test{
//     static final String url="jdbc:mysql://localhost:3306/22bd1a052a";
//     static final String user="root";
//     static final String pass="preetham123";
//     static final String table="CREATE TABLE customers("+
//     "id INT PRIMARY KEY AUTO_INCREMENT,"+
//     "name VARCHAR(100) NOT NULL,"+
//     "email VARCHAR(100) NOT NULL,"+
//     "phone VARCHAR(20) NOT NULL)";
//     static final String insert="INSERT INTO customers(name, email, phone)VALUES"+
//     "('Alice Smith', 'alice.smith@example.com', '555-1234'),"+
// "('Bob Johnson', 'bob.johnson@example.com', '555-5678'),"+
// "('Charlie Brown', 'charlie.brown@example.com', '555-8765'),"+
// "('Diana Prince', 'diana.prince@example.com', '555-4321'),"+
// "('Edward Norton', 'edward.norton@example.com', '555-9876'),"+
// "('Fiona Gallagher', 'fiona.gallagher@example.com', '555-1111'),"+
// "('George Michael', 'george.michael@example.com', '555-2222'),"+
// "('Hannah Baker', 'hannah.baker@example.com', '555-3333'),"+
// "('Isaac Newton', 'isaac.newton@example.com', '555-4444'),"+
// "('Jessica Jones', 'jessica.jones@example.com', '555-5555'),"+
// "('Kevin Bacon', 'kevin.bacon@example.com', '555-6666'),"+
// "('Lara Croft', 'lara.croft@example.com', '555-7777'),"+
// "('Michael Scott', 'michael.scott@example.com', '555-8888'),"+
// "('Nancy Drew', 'nancy.drew@example.com', '555-9999'),"+
// "('Oscar Wilde', 'oscar.wilde@example.com', '555-0000'),"+
// "('Pam Beesly', 'pam.beesly@example.com', '555-1010'),"+
// "('Quentin Tarantino', 'quentin.tarantino@example.com', '555-2020'),"+
// "('Rachel Green', 'rachel.green@example.com', '555-3030'),"+
// "('Steve Rogers', 'steve.rogers@example.com', '555-4040'),"+
// "('Tony Stark', 'tony.stark@example.com', '555-5050')";

   
//     // PreparedStatement=null;
//     public static void main(String[] args) throws Exception{
//             Statement st=null;
//            Connection conn=null;
//           Class.forName("com.mysql.cj.jdbc.Driver");
//           conn = DriverManager.getConnection(url,user,pass);
//           st = conn.createStatement();
//           st.executeUpdate(table);
//           System.out.println("table created sucess");
//           st.execute(insert);
//           System.out.println("inserted");
//           String query="select name as n,email as e,phone as p from customers";
//           ResultSet rs=st.executeQuery(query);
//           while(rs.next()){
//             String name=rs.getString("n");
//             String email=rs.getString("e");
//             String number=rs.getString("p");
//             System.out.print(name);
//             System.out.print(email);
//             System.out.print(number);
            
            
//           }
//         // String q="select name as n from customers";
//         // ResultSet r=st.executeQuery(q);
//         //   while(r.next()){
//         //     String name=r.getString("n");
//         //     // String email=rs.getString("e");
//         //     // String number=rs.getString("p");
//         //     // System.out.print(name);
//         //     // System.out.print(email);
//         //     System.out.print(name);
            
//         //    rs.moveToCurrentRow();
//         //   }
          
         
//           String query2="select name as n ,email  as e ,id as id from customers";
//           ResultSet r2=st.executeQuery(query2);
//           Map<Integer,String> m= new HashMap<>();
          
//           while(r2.next()){
                
//                 String name=r2.getString("n");
//                 // String email=r2.getString("e");
//                 Integer id=r2.getInt("id");
//                 // String number=r2.getString("p");
//                 // System.out.print(name);
//                 // System.out.print(email);
//                 // System.out.print(number);
//                 m.put(id,name);
//             }
//             System.out.println("enter s: ");
//             Scanner sc=new Scanner(System.in);
//             // String s=sc.nextLine();
          
//            int n=sc.nextInt();
//            System.out.println(m.get(n));
//            String query3="drop database 22bd1a052a";
//            boolean b=sc.nextBoolean();
//            if(b){
//             st.executeUpdate(query3);
//            }
          
         
        
//         }
//     }


import java.sql.*;
import java.util.Scanner;


public class Main {
    static ResultSet rs;
    public static void main(String[] args){
        String jdbcURL = "jdbc:mysql://localhost:3306/22bd1a052a";
        String username = "root";
        String password = "preetham123";
        Connection con = null;
        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, username, password);
            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,//resultset open is not affected (when changes made in data base)
                    ResultSet.CONCUR_UPDATABLE);// result set is updatable
            rs = stmt.executeQuery("SELECT * FROM customers");
            String s="";
            rs.first();
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            System.out.println(name+" "+email+" "+phone);
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsmd.getColumnName(i));
            }

            while(s!="E"){
                System.out.println("ENTER :");
                s=sc.next();
                switch (s) {
                    case "n":
                        rs.next();
                        break;
                    case "p":
                        rs.previous();
                        break;
                    case "f":
                        rs.first();
                        break;
                    case "l":
                        rs.last();
                        break;
                    case "i":
                        rs.moveToInsertRow();
                        System.out.println("Enter name");
                        String name2=sc.next();
                        rs.updateString(2, name2);
                        System.out.println("Enter email");
                        String email2=sc.next();
                        rs.updateString(3, email2);
                        System.out.println("Enter no.");
                        String no2=sc.next();
                        rs.updateString(4, no2);
                        rs.insertRow();
                        break;
                    case "d":
                        rs.deleteRow();
                    case "e" :
                        s="e";
                    default:
                        break;
                }
                name = rs.getString(2);
                email = rs.getString(3);
                phone = rs.getString(4);
                System.out.println(name+" "+email+" "+phone);
            }
        }
        catch(Exception E){
            System.out.println(E);
        }
    }
}