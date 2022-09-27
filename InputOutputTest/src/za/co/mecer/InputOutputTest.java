package za.co.mecer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author Dimakatso Sebatane
 */
public class InputOutputTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
//        new InputOutputTest().fileRun();
//        new InputOutputTest().readerWriterRun();
//        new InputOutputTest().printRun();
//        new InputOutputTest().inputStreamRun();
        new InputOutputTest().dataStreamRun();
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

    private void inputStreamRun() throws IOException {
        File file = new File("c:\\test\\todayTxt.bin");
        byte[] byteArr = {65, 66, 67, 68, 69, 70, 0x0a, 0x0c};
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(12);
            out.write(byteArr);
            out.write(byteArr, 2, 6);

        } catch (IOException iox) {
            System.out.printf("ERROR: %s%n", iox.getMessage());
        }

        File file1 = new File("c:\\test\\todayTxt.bin");
        byte[] arrIn1 = new byte[20];
        byte[] arrIn2 = new byte[10];
        try (FileInputStream in = new FileInputStream(file1)) {
            in.read(arrIn1, 1, 5);
            in.read(arrIn2);
        } catch (IOException iox) {
            System.out.printf("ERROR: %s%n", iox.getMessage());
        }

        System.out.println("ArrIn1: " + Arrays.toString(arrIn1));
        System.out.println("ArrIn2: " + Arrays.toString(arrIn2));
    }

    private void dataStreamRun() throws IOException {
        double pi = 3.14159;
        int i = 12345;
        short s = 987;
        String str = "Hello world!";
        try (FileOutputStream out = new FileOutputStream("c:\\test\\fileOutputStream.bin");
                DataOutputStream output = new DataOutputStream(out)) {
            output.writeDouble(pi);
            output.writeInt(i);
            output.writeShort(s);
            output.writeChars(str);
            output.writeChars("\nThere");
        } catch (IOException iox) {
            System.out.printf("ERROR: %s%n", iox.getMessage());
        }

        try (FileInputStream in = new FileInputStream("c:\\test\\fileOutputStream.bin");
                DataInputStream input = new DataInputStream(in)) {
            System.out.printf("Read double: %.2f%n", input.readDouble());
            System.out.printf("Read int: %d%n", input.readInt());
            System.out.printf("Read short: %d%n", input.readShort());
            System.out.printf("Read String: %s%n", input.readLine());
            System.out.printf("Read String: %s%n", input.readLine());

        }
    }

}
