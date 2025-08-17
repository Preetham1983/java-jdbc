// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;

// public class CSVReadExample {
//     public static void main(String[] args) {
//         String filePath = "C://Users//bandi//OneDrive//Desktop//jdbc//jdbcdemo//src//example.csv"; // Specify the path to your file

//         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             boolean isHeader = true; // To skip the header line
//             while ((line = br.readLine()) != null) {
//                 // Split the line by commas
//                 String[] values = line.split(",");
//                 if (isHeader) {
//                     isHeader = false; // Skip the header line
//                     continue;
//                 }
//                 // Parse age and check the condition
//                 int age = Integer.parseInt(values[1].trim());
//                 if (age < 28) {
//                     // Display the values
//                     for (String value : values) {
//                         System.out.print(value + " ");
//                     }
//                     System.out.println();
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriteManualExample {
    public static void main(String[] args) {
        String filePath = "C://Users//bandi//OneDrive//Desktop//jdbc//jdbcdemo//src//example.csv"; // Specify the path to your file
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            while (true) {
                System.out.println("Enter Name (or type 'exit' to finish): ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Enter Age: ");
                String age = scanner.nextLine();

                System.out.println("Enter City: ");
                String city = scanner.nextLine();

               
                bw.write(String.join(",", name, age, city));
                bw.newLine();
            }

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
