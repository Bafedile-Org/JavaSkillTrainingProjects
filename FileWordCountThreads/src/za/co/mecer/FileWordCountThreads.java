package za.co.mecer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import za.co.mecer.filewordcount.FileWordCount;

/**
 *
 * @author Dimakatso Sebatane
 */
public class FileWordCountThreads {

    public static void main(String[] args) {
        new FileWordCountThreads().run(args);
    }

    private void run(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (String str : args) {
            if (Files.isReadable(Paths.get(str))) {
                Future<Integer> wordNums = executor.submit(new FileWordCount(str));
                try {
                    displayNumberOfWords(str, wordNums.get());
                    TimeUnit.MILLISECONDS.sleep(150);
                } catch (ExecutionException | InterruptedException ex) {
                    System.out.printf("Error: %s%n", ex.getMessage());
                }
            }
        }
        executor.shutdown();
    }

    private void displayNumberOfWords(String str, int wordNums) {
        System.out.printf("The number of words in %s is %d%n%n", str, wordNums);
    }

}
