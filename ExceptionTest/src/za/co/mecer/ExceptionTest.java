package za.co.mecer;

import za.co.mecer.exception.CoolException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ExceptionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new ExceptionTest().run();
        } catch (CoolException ce) {
            System.out.println("Main Error: " + ce.getMessage());
        }
    }

    private void run() throws CoolException {
        try {
            foo(7);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new CoolException("This is our Cool Exception");
        }
    }

    private void foo(int val) throws Exception {
        System.out.println("I am a foo");
        if (val > 5) {
            throw new Exception("Do not use 5 or more");
        }

    }

}
