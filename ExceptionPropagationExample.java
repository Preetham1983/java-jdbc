public class ExceptionPropagationExample {

    public static void main(String[] args) {
        try {
            methodA();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main method: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General exception caught in main method: " + e.getMessage());
        }
    }

    public static void methodA() {
        try {
            methodB();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in methodA: " + e.getMessage());
        }
    }

    public static void methodB() {
        methodC();
    }

    public static void methodC() {
        System.out.println("Inside methodC");
        int result = 10 / 0; // This will cause an ArithmeticException
        System.out.println("Result is: " + result);
    }
}

