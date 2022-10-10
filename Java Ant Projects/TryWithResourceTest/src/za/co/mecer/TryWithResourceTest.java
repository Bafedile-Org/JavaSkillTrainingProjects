package za.co.mecer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import za.co.mecer.TryWithResource.TryWithResource;

/**
 *
 * @author Dimakatso Sebatane
 */
public class TryWithResourceTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        new TryWithResourceTest().run();
        new TryWithResourceTest().tryWithResourceRun();
    }

    private void run() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Please enter something: ");
            String something = input.nextLine();
            System.out.printf("%s%n", something);
        }

    }

    private void tryWithResourceRun() {
        try (TryWithResource twr = new TryWithResource(34)) {
            twr.setValue(98);
        } catch (Exception ex) {
            System.out.printf("Exception: %s%n", ex.getMessage());
        }

        try (Scanner input = new Scanner(new File("test.txt"))) {
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.printf("ERROR: %S%n", ex.getMessage());
        }
    }
}
