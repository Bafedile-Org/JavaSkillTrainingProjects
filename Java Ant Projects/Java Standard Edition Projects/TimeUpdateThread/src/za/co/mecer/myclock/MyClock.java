package za.co.mecer.myclock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MyClock implements Runnable {

    @Override
    public void run() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY");
        System.out.printf("Date: %s%n%n", LocalDate.now());
        try {
            while (true) {
                System.out.print(timeFormatter.format(LocalTime.now()));
                Thread.sleep(1000);
                System.out.print("\r\n");

            }
        } catch (InterruptedException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }
}
