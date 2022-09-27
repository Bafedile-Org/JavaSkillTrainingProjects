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
public class WordPalindromes {

    int counter = 0;

    public static void main(String[] args) {
        new WordPalindromes().run();
    }

    private void run() {
        Path path = Paths.get("src\\za\\co\\mecer\\WordBuff.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                testPal(str);
            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
        System.out.printf("Number of word Palindromes are : %d%n", counter);
    }

    private int testPal(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(", ");
        for (String string : strings) {
            for (String strs : string.split(",")) {
                sb.replace(0, sb.length(), strs).reverse();
                if (sb.toString().equals(strs)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
