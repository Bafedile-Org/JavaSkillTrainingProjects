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
public class NumOccuranceFileTest {

    /**
     * @param args the command line arguments
     */
    int counter = 0;

    public static void main(String[] args) {
        new NumOccuranceFileTest().run();
    }

    private void run() {
        Path path = Paths.get("C:\\test\\numsOccuranceFile.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                test(str);
            }
        } catch (IOException iox) {
            System.out.printf("ERROR: %s%n", iox.getMessage());
        }
        System.out.printf("Number [10] occurances in the file [%s] %nis %d%n", path.getFileName(), counter);
    }

    private void test(String str) {
        String chars[] = str.split(" ");
        for (String char1 : chars) {
            try {
                if (Integer.parseInt(char1) == 10) {
                    counter++;
                }
            } catch (NumberFormatException ex) {
                //System.out.printf("Error: %s%n", ex.getMessage());
            }
        }

    }

}
