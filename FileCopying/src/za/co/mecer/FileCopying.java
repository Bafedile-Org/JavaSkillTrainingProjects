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
public class FileCopying {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        new FileCopying().run(args);
        FileCopying2.main(args);
    }
    
    private void run(String[] args) {
        try {
            File file1 = new File(args[0]);
            File file2 = new File(args[1]);
            if (args[0].endsWith(".txt") && args[1].endsWith(".txt")) {
                file1.createNewFile();
                file2.createNewFile();
                copyTo(file1, file2);
            } else {
                throw new IOException("Usage: java file file1.txt file2.txt [-l] [-u]");
            }
            
        } catch (IOException iox) {
            System.out.printf("File Error: %s%n", iox.getMessage());
        }
    }
    
    private String readFile(File file) {
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
        
        return sb.toString();
    }
//    private String readFile(File file) {
//        StringBuilder sb = new StringBuilder();
//        try (FileReader reader = new FileReader(file)) {
//            char[] readChars = new char[4098];
//            reader.read(readChars);
//            for (char ch : readChars) {
//                sb.append(ch);
//            }
//        } catch (IOException iox) {
//            System.out.printf("Reader Error: %s%n", iox.getMessage());
//        }
//
//        return sb.toString();
//    }

    private void copyTo(File file1, File file2) {
        try (PrintWriter writer = new PrintWriter(file2)) {
            writer.println(readFile(file1));
            System.out.printf("%s content Copied to %s%n", file1.getName(), file2.getName());
        } catch (IOException iox) {
            System.out.printf("Writer Error: %s%n", iox.getMessage());
        }
    }
    
}
