package za.co.mecer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import za.co.mecer.myrunnable.MyRunnable;
import za.co.mecer.mythread.MyThread;
import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ThreadExamples {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Started");
        new ThreadExamples().runMe();
//        Thread.sleep(500);
//        System.out.println("Ended");
    }

    private void run() {
        new MyThread().start();
        //  new Thread(new MyRunnable()).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("Standup for the %d time %n", i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
            }
        }).start();
    }

    private void runMe() {
        Stack<Person> list = new Stack<>();
        list.push(new Person("Jessie Michaels", 32, 'F', 17388.33));
        list.push(new Person("Nathalie Newton", 29, 'F', 27818.23));
        list.push(new Person("Molly Jean", 34, 'F', 12737.32));
        list.push(new Person("Jim Micha", 19, 'M', 8964.32));
        list.push(new Person("Anatoly Chuchkluck", 25, 'M', 5643.32));
        list.push(new Person("Will Meghan", 23, 'M', 12779.32));

        new Thread(new MyRunnable(list)).start();
        new Thread(new MyRunnable(list)).start();
    }

}
