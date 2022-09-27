package za.co.mecer;

import java.io.IOException;
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
        new NIO2Test().run();
    }

    private void run() throws IOException {
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
    }

}
