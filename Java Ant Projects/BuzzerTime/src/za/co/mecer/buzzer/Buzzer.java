package za.co.mecer.buzzer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mecer.impl.MonitorTime;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Buzzer extends Thread implements MonitorTime {

    @Override
    public void setBuzzerTime(long milliseconds, int numberOfTimes) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.printf("Starting time: %s%n%n", LocalTime.now().format(format));
        for (int counter = 0; counter < numberOfTimes; counter++) {

            try {
                Thread.sleep(milliseconds);
                System.out.printf("Buzz Buzz at %s%n", LocalTime.now().format(format));
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }
        }
    }

    @Override
    public void runBuzzer() {
        this.start();
    }

}
