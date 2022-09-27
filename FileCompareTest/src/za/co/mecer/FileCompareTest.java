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
public class FileCompareTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FileCompareTest().run(args);
    }

    private void run(String[] args) {
        if (args.length == 2) {
            if (args[0].endsWith(".txt") && args[1].endsWith(".txt")) {
                compareFiles(args[0], args[1]);
            }
        }
    }

    private void compareFiles(String file1, String file2) {
        String file1Str, file2Str;

        file1Str = readFile(file1);
        file2Str = readFile(file2);

        if (file1Str.equals(file2Str)) {
            System.out.printf("Files are equal%n");
        } else {
            String[] file1Arr = file1Str.split("\\n");
            String[] file2Arr = file2Str.split("\\n");

            for (int i = 0; i < file1Arr.length; i++) {
                if (!file1Arr[i].equals(file2Arr[i])) {
                    System.out.printf("[file: %s][Line: %d]  %s%n", file1, (i + 1), file1Arr[i]);
                    System.out.printf("[file: %s][Line: %d]  %s%n", file2, (i + 1), file2Arr[i]);
                }
            }
        }

    }

    private String readFile(String file) {
        StringBuilder sb = new StringBuilder();
        Path path = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }

        return sb.toString();
    }

}
