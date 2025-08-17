public class RethrowExceptionExample {

    public static void main(String[] args) {
        try {
            methodA();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main method: " + e.getMessage());
        }
    }

    public static void methodA() {
        try {
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in methodA: " + e.getMessage());
            // Re-throwing the exception to the caller (main method)
            throw e;
        }
    }

    public static void methodB() {
        try {
            int result = 10 / 0; // This will cause an ArithmeticException
            System.out.println("Result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in methodB: " + e.getMessage());
            // Re-throwing the exception to methodA
            throw e;
        }
    }
}

