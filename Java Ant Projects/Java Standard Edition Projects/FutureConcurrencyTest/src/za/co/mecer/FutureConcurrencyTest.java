package za.co.mecer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dimakatso Sebatane
 */
public class FutureConcurrencyTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new FutureConcurrencyTest().run();
    }

    private void run() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 5; i < 10; i++) {
            System.out.printf("Factorial service of %d = ", i);
            Future<Long> result = service.submit(new FactorialService(i));
            System.out.printf("%d%n%n", result.get());

        }

        Future<String> result = service.submit(() -> "I am a thingy");
        System.out.printf("Message: %s%n", result.get());
        service.shutdown();
    }

}

class FactorialService implements Callable {

    private long number;

    public FactorialService(long number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        return factorial();
    }

    private long factorial() throws InterruptedException {
        long result = 1L;
        while (number != 0) {
            result *= number--;
            TimeUnit.MILLISECONDS.sleep(100);
        }

        return result;
    }

}
