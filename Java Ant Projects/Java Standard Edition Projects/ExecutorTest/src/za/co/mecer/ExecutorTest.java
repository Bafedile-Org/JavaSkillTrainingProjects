package za.co.mecer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ExecutorTest {

    public static void main(String[] args) {
        new ExecutorTest().run();
    }

    private void run() {
        Executor executor = Executors.newCachedThreadPool();
        for (int i = 0; i < (int) (Math.random() * 20) + 1; i++) {
            executor.execute(new Task());
        }
        ThreadPoolExecutor ourPool = (ThreadPoolExecutor) executor;
        ourPool.shutdown();
    }

}

class Task implements Runnable {

    @Override
    public void run() {
        Long duration = (long) (Math.random() * 5) + 1;
        System.out.printf("System is running: Duration is : %d%n", duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }
}
