package za.co.mecer.myrunnable;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MyRunnable implements Runnable {

    private Stack<Person> stack;

    public MyRunnable(Stack<Person> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            popFromStack();
//        for (int i = 0; i < 10; i++) {
//            System.out.printf("Wake up  for the %d time %n", i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//            }
//        }
        } catch (InterruptedException ex) {
            Logger.getLogger(MyRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popFromStack() throws InterruptedException {
        while (!stack.isEmpty()) {
            System.out.printf("%s popped by %s %n", stack.pop().getName(), Thread.currentThread().getName());
            Thread.sleep((int) (Math.random() * 300) + 1);
        }
    }

}
