// import java.util.*;
// class bankexe extends Exception{

//     bankexe(String s){
//         super(s);
//     }
// }


// class bank{
//     int accno;
//     String name;
//     int balance;
//     bank(String name,int accno,int balance){
//         this.accno=accno;
//         this.name=name;
//         this.balance=balance;
//     }
//     public void withdraw(int amount) throws bankexe{
//         if(this.balance <amount){
//             throw new bankexe("no funds");
//         }else{
//             this.balance=this.balance-amount;
//             System.out.println("sucessfully withdrawed: "+amount);
//             System.out.println("balance amount: "+this.balance);
//         }
//     }
// }


// public class userdefinee {
//     public static void main(String[] args) {

      
//         try{
//             bank b=new bank("preetham",12 , 1230);
//             b.withdraw(200);

//         }catch(bankexe e){
//             System.out.println(e.getMessage());
//         }
       
//     }
// }
// Custom Exception Class
class BankException extends Exception {
    // Constructor
    BankException(String message) {
        super(message); // Initialize the Exception base class with the message
    }
}

// Bank Class
class Bank {
    int accno;
    String name;
    int balance;

    // Constructor
    Bank(String name, int accno, int balance) {
        this.accno = accno;
        this.name = name;
        this.balance = balance;
    }

    // Method to withdraw money
    public void withdraw(int amount) throws BankException {
        if (this.balance < amount) {
            // Throw custom exception with a message
            throw new BankException("No funds available");
        } else {
            this.balance -= amount;
            System.out.println("Successfully withdrew " + amount);
            System.out.println("Remaining balance: " + this.balance);
        }
    }
}

// Main Class
public class UserDefineException {
    public static void main(String[] args) {
        Bank b = new Bank("Preetham", 123456, 1230);

        try {
            b.withdraw(200); // Try withdrawing 200
        } catch (BankException e) {
            // Catch and handle the custom exception
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
