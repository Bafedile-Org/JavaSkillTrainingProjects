package za.co.mecer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Dimakatso Sebatane
 */
public class InputOutputTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        new InputOutputTest().fileRun();
//        new InputOutputTest().readerWriterRun();
        new InputOutputTest().printRun();
    }

    private void fileRun() throws IOException {
        File file = new File("barb.txt");
        System.out.printf("File exists? %s%n", file.exists());
        file.createNewFile();
        System.out.printf("File Readable? %s%n", file.canRead());
        System.out.printf("Is a file? %s%n", file.isFile());
        System.out.printf("Is a directory? %s%n", file.isDirectory());
        System.out.printf("Path of %s is %s%n", file.getName(), file.getPath());
        System.out.printf("Absolute Path of %s is %s %n", file.getName(), file.getAbsolutePath());
    }

    private void readerWriterRun() {
        File file = new File("barb.txt");
        System.out.printf("Does te file exist? %s%n", file.exists());
        if (file.exists()) {
            System.out.printf("Writing to the file...%n%n");
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write("It was early in the morning when the little rabbit was going out to get breakfast.\n");
                writer.write("As he was crossing the river he saw a crocodile feeding on a leopard.\n");
                writer.write("The rabbit was terrified and ran back to his little mushroom house.\n");
                writer.flush();
            } catch (IOException ex) {
                System.out.printf("Write Error: %s%n", ex.getMessage());
            }
        }

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                char[] readChars = new char[4096];
                reader.read(readChars);
                for (char ch : readChars) {
                    System.out.printf("%c", ch);
                }
                System.out.println();
            } catch (IOException ex) {
                System.out.printf("Read Error: %s%n", ex.getMessage());
            }
        }

    }

    private void printRun() throws IOException {
        File file = new File("barb1.txt");
        System.out.printf("Does the file exist? %s%n", file.exists());
        file.createNewFile();
        if (file.exists()) {
            System.out.printf("Writing to the file...%n%n");
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("It was early in the morning when the little rabbit was going out to get breakfast.\n");
                writer.println("As he was crossing the river he saw a crocodile feeding on a leopard.\n");
                writer.println("The rabbit was terrified and ran back to his little mushroom house.\n");
                writer.flush();

            } catch (IOException ex) {
                System.out.printf("Write Error: %s%n", ex.getMessage());
            }
        }

        if (file.exists()) {
            try (FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader)) {
                System.out.printf("%nReading from file...%n%n");
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    System.out.println(s);
                }
                System.out.println();
            } catch (IOException ex) {
                System.out.printf("Read Error: %s%n", ex.getMessage());
            }
        }
    }

}
