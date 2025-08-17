
// import java.io.IOException;
// import java.sql.SQLException;
// import java.util.*;
// public class FinalRethrowExample {

//     public static void main(String[] args) throws Exception {
//         try {
//             methodA();
//         } catch (IOException e) {
//             System.out.println("Caught IOException in main: " + e.getMessage());
//         }
//     }

//     public static void methodA() throws Exception {
//         try {
//             methodB();
//         } catch (SQLException e) {
//             // The following line will ensure that the rethrown exception is either IOException or SQLException
//             throw e;  // Re-throws the exception to the caller
//         }
//     }

//     public static void methodB() throws SQLException {
//         // Simulating an exception being thrown
//         throw new SQLException("Database error occurred.");
//     }
// }

import java.io.*;

class demo {
    static void meth1(int x) throws IOException, InterruptedException {
        try {
            if (x == 0)
                throw new IOException();
            else
                throw new InterruptedException();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String args[]) {
        try {
            meth1(0);
        } catch (IOException | InterruptedException e) {
            System.out.println("exception throen "+e);
        }
    }
}
