class t1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("im in t "+Thread.currentThread().getName() + i);
        }
    }
}
public class t{
    public static void main(String[] args) throws Exception{
        t1 t11=new t1();

        t11.start();
        t11.join();
      
        t11.setName("ha");
       
        for(int i=0;i<10;i++){
            System.out.println("im in main thread "+i);
            // Thread.sleep(3000);
        }
    }
}
