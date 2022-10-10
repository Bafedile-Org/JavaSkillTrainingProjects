package za.co.mecer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ReentrantTest {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private String msg = "\n";

    public static void main(String[] args) {
        try {
            new ReentrantTest().run();
        } catch (InterruptedException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

    private void run() throws InterruptedException {
        Thread t1 = new Thread(new WriterA());
        Thread t2 = new Thread(new WriterB());
        Thread t3 = new Thread(new Reader());

        t1.setName("Writer A");
        t2.setName("Writer B");
        t3.setName("Reader");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.printf("Message: %s%n", msg);
    }

    class Reader implements Runnable {

        @Override
        public void run() {
            if (lock.isWriteLocked()) {
                System.out.printf("Method is Write locked.");
            }
            lock.readLock().lock();
            try {
                Long duration = (long) (Math.random() * 10000);
                System.out.printf("%n%s%n", Thread.currentThread().getName() + String.format(": Time taken : %d seconds", (duration / 1000)));
                Thread.sleep(duration);
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            } finally {
                System.out.printf("%nPrinted OK: %s%n", Thread.currentThread().getName());
                lock.readLock().unlock();
            }
        }
    }

    class WriterA implements Runnable {

        @Override
        public void run() {
            lock.writeLock().lock();
            try {
                Long duration = (long) (Math.random() * 10000);
                System.out.printf("%n%s%n", Thread.currentThread().getName() + String.format(": Time taken : %d seconds", (duration / 1000)));
                Thread.sleep(duration);
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            } finally {
                msg = msg.concat("Writer A Finished\n");
                lock.writeLock().unlock();
            }
        }
    }

    class WriterB implements Runnable {

        @Override
        public void run() {
            lock.writeLock().lock();
            try {
                Long duration = (long) (Math.random() * 10000);
                System.out.printf("%n%s%n", Thread.currentThread().getName() + String.format(": Time taken : %d seconds", (duration / 1000)));
                Thread.sleep(duration);
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            } finally {
                msg = msg.concat("Writer B finished\n");
                lock.writeLock().unlock();
            }
        }
    }
}
