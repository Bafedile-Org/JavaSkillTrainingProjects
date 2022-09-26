package za.co.mecer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Dimakatso Sebatane
 */
public class FileCopying2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FileCopying2().run(args);
    }

    private void copy(String arg, String[] args) throws IOException {
        File file1, file2;
        if (args[0].endsWith(".txt") && args[1].endsWith(".txt")) {
            file1 = new File(args[0]);
            file2 = new File(args[1]);
            file1.createNewFile();
            file2.createNewFile();
            copyTo(file1, file2, arg);
        } else {
            System.out.println("Usage: java file file1.txt file2.txt [-l] [-u]");
        }
    }

    private void run(String[] args) {
        try {
            if (args.length == 2) {
                copy("", args);
            }
            if (args.length == 3) {
                copy(args[2], args);
            }
        } catch (IOException iox) {
            System.out.printf("File Error: %s%n", iox.getMessage());
        }
    }

    private String readFile(File file, String arg) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException iox) {
            System.out.printf("Reader Error: %s%n", iox.getMessage());
        }
        switch (arg) {
            case "-u":
                return sb.toString().toUpperCase();
            case "-l":
                return sb.toString().toLowerCase();
            default:
                return sb.toString();
        }
    }

    private void copyTo(File file1, File file2, String arg) {
        try (PrintWriter writer = new PrintWriter(file2)) {
            writer.println(readFile(file1, arg));
            System.out.printf("%s content Copied to %s%n", file1.getName(), file2.getName());
        } catch (IOException iox) {
            System.out.printf("Writer Error: %s%n", iox.getMessage());
        }
    }

}
