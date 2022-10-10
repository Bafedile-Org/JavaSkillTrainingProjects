package za.co.mecer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Dimakatso Sebatane
 */
public class NIO2Test {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
//        new NIO2Test().runTest1();
//        new NIO2Test().runTest2();
//        new NIO2Test().runTest3();
        new NIO2Test().runTest4();

    }

    private void runTest1() throws IOException {
        StringBuilder sb = new StringBuilder();
        Path path = Paths.get("C:\\test\\nio2.txt");
        sb.append("Hello World!\n");
        sb.append("Welcome to software version of HELL\n");
//        Files.write(path, sb.toString().getBytes(), StandardOpenOption.APPEND);
        //  Files.write(path, "As I was saying\n".getBytes(), StandardOpenOption.APPEND);

//        // Read data from the file
//        for (String str : Files.readAllLines(path)) {
//            System.out.printf("%s%n", str);
//        }
        List<String> read = Files.readAllLines(path);
//        for (String s : read) {
//            System.out.printf("%s%n", s);
//        }

        read.forEach((s) -> System.out.printf("%s%n", s));
        //   read.forEach(System.out::println);
    }

    private void runTest2() throws IOException {
        Path path = Paths.get("C:\\test\\nio2.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String read;
            while ((read = reader.readLine()) != null) {
                System.out.printf("%s%n", read);
            }
        } catch (IOException iox) {
            System.out.printf("ERROR: %s%n", iox.getMessage());
        }
    }

    private void runTest3() throws IOException {
        Path path = Paths.get("c:\\test\\test1.txt");
        System.out.println(Files.deleteIfExists(path) ? "File deleted" : "File does not exists");
    }

    private void runTest4() throws IOException {
        Path path = Paths.get("C:\\test\\nio2.txt");
        System.out.printf("Path: %s%n", path);
        path = path.normalize();
        System.out.printf("Path [normalized]: %s%n", path);
        path = path.toAbsolutePath();
        System.out.printf("Path [absolute]: %s%n", path);
        path = path.toRealPath();
        System.out.printf("Path [real]: %s%n", path);

    }
}
