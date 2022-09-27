package za.co.mecer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CounterFileTest {

    private int lines = 0, words = 0, characters = 0;

    public static void main(String[] args) {
        new CounterFileTest().run(args);
    }

    private void run(String[] args) {
        Path path = Paths.get(args[0]);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                testCharacters(str);
                testWords(str);
                lines++;
            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
        System.out.printf("File [%s] contains%n"
                + "Number of Characters: %d%n"
                + "Number of Words: %d%n"
                + "Number of Lines: %d%n", path.getFileName(), characters, words, lines);
    }

    private int testCharacters(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isWhitespace(ch)) {
                characters++;
            }
        }
        return characters;
    }

    private int testWords(String str) {
        String[] strings = str.split(" ");
        words += strings.length;
        return words;
    }
}
