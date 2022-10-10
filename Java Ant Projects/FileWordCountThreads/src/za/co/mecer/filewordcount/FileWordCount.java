package za.co.mecer.filewordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

/**
 *
 * @author Dimakatso Sebatane
 */
public class FileWordCount implements Callable {

    private Path path;

    public FileWordCount(String fileName) {
        this.path = Paths.get(fileName);
    }

    @Override
    public Object call() {
        return countWords();
    }

    private int countWords() {
        int counter = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] words = str.split(" ");
                counter += words.length;
            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }

        return counter;
    }

}
