package za.co.mecer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AtomicTest {

    public static void main(String[] args) {
        try {
            new AtomicTest().run();
        } catch (InterruptedException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

    private void run() throws InterruptedException {
        final Counter counter = new Counter();
        AtomicInteger count = new AtomicInteger(0);

        for (count.get(); count.get() < 1000; count.getAndIncrement()) {
            new Thread(() -> counter.increment()).start();
        }
//        for (int i = 0; i < 1000000; i++) {
//            new Thread(() -> counter.increment()).start();
//
//        }
        Thread.sleep(6000);
        System.out.println(counter.getCounter());
    }
}

class Counter {

    private AtomicInteger counter = new AtomicInteger(0);
//    private int counter = 0;

//    public Counter(int counter) {
//        this.counter = counter;
//    }
    public void increment() {
//        counter++;
        counter.getAndIncrement();
    }

    public int getCounter() {
        return counter.get();
    }
}
