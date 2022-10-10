package za.co.mecer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CyclicBarrierConcurrencyTest {

    private CyclicBarrier barrier;
    private String dogs1[] = {"tyson", "mike", "bob", "susan", "anatoly"};
    private String dogs2[] = {"cat", "bridget", "dog", "snoopy", "fido"};
    private ArrayList<String> dogsList = new ArrayList<>();

    public static void main(String[] args) {
        new CyclicBarrierConcurrencyTest().run();
    }

    private void run() {
        barrier = new CyclicBarrier(2,
                () -> {
//                    Thread.currentThread().setName("Barrier Thread");
                    dogsList.addAll(Arrays.asList(dogs1));
                    dogsList.addAll(Arrays.asList(dogs2));
                    System.out.printf("ArrayList of dogs: %s%n", dogsList);
//                    System.out.printf("%s Finished Running%n", Thread.currentThread().getName());
                }
        );
        Thread t1 = new Thread(new Cyclic(dogs1));
        t1.start();
        Thread t2 = new Thread(new Cyclic(dogs2));
        t2.start();

    }

//**********************************************************************************************
    class Cyclic implements Runnable {

        private String[] dogs;

        public Cyclic(String[] dogs) {
            this.dogs = dogs;
        }

        @Override
        public void run() {
            for (int i = 0; i < dogs.length; i++) {
                dogs[i] = dogs[i].substring(0, 1).toUpperCase() + dogs[i].substring(1);
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException | InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            } finally {
                System.out.printf("%s Finished Running%n", Thread.currentThread().getName());
            }
        }
    }
}
