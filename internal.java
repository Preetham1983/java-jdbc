// Develop a multithreaded Quiz application where BOT would ask the question and multiple users can answer concurrently. The chat system should handle synchronization properly to avoid race conditions and ensure message integrity. 
// The output should appear in the following order : 
// BOT asks: What is the capital of India?
// User1: Delhi
// User2: Bombay
// User3: New Delhi
// BOT asks: What is the largest planet in our solar system?
// User1: Jupiter
// User2: Saturn
// User3: Earth
// ………. Etc. 
// Make sure after every user answers then only the BOT can ask the next question.
import java.util.*;
class user1 implements Runnable{
    public void run(){
        Scanner sc=new Scanner(System.in);
        System.out.print("User1: ");
        sc.next();


    }

}
class user2 implements Runnable{
    public void run(){
        Scanner sc=new Scanner(System.in);
        System.out.print("User2: ");
        sc.next();


    }

}
class user3 implements Runnable{
    public void run(){
        Scanner sc=new Scanner(System.in);
        System.out.print("User3: ");
        sc.next();

    }

}
class bot{
        public void bot(){
            System.out.println("Bot asks: "+"what is the capital of india? ");

        }
        void nextq(){
            System.out.println("Bot asks: "+"what is the largest planet on earth?? ");
        }
        void nexttq(){
            System.out.println("Bot asks: "+"WHAT is a thread? ");
        }
}
public class internal {
    public static void main(String[] args) throws Exception{
        user1 u1=new user1();
        user2 u2=new user2();
        user3 u3=new user3();
        bot b1= new bot();
        Thread t1=new Thread(u1);
        Thread t2=new Thread(u2);
        Thread t3=new Thread(u3);
        Thread t4=new Thread(u1);
        Thread t5=new Thread(u2);
        Thread t6=new Thread(u3); 

        b1.bot();
        
       
       


        

   
        Scanner sc=new Scanner(System.in);
        // String n=sc.next();
      
       
       
            
            t1.start();
            t1.join();
            t2.start();
            t2.join();
    
            t3.start();
            t3.join();
            b1.nextq();
            t4.start();
            t4.join();
            t5.start();
            t5.join();
    
            t6.start();
            t6.join();

            b1.nexttq();
            Thread t=new Thread(u1);
            Thread tt=new Thread(u1);
            Thread ttt= new Thread(u1);
        }
}
