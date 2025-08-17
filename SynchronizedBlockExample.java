// class counter{
//     int count;
//     public synchronized void incr(){
//         count ++;
//     }
// }



// public class sys {
//     public static void main(String[] args) throws Exception{
//         counter c=new counter();
//         c.incr();
//         Thread t1=new Thread(new Runnable() {
//             public void run(){
//                 for(int i=1;i<=100;i++){
//                     c.incr();
//                 }
//             }
//         });
//         Thread t2=new Thread(new Runnable() {
//             public void run(){
//                 for(int i=1;i<=100;i++){
//                     c.incr();
//                 }
//             }
//         });
//         t1.start();
//         t2.start();
        
        
//         System.out.println("count "+c.count);
//     }
    
// }
class BankAccount {
    private int balance = 1000;

    // Non-synchronized method
    public void withdraw(int amount) {
        synchronized (this) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + ", Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient funds for withdrawal: " + amount);
            }
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class SynchronizedBlockExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Create two threads that will perform withdrawal operations
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(200);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(300);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}
