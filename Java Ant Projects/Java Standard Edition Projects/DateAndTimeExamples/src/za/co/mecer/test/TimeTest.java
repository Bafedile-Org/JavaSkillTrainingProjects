package za.co.mecer.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 *
 * @author Dimakatso Sebatane
 */
public class TimeTest {

    public void timeTest() {
        LocalTime time = LocalTime.now();
        System.out.printf("The time is: %s%n", time);
        System.out.printf("Time in the next 24 hours: %s%n", time.plusHours(10));
        System.out.printf("Time of : %s%n", time.of(12, 23, 59));
        System.out.printf("Time of : %s%n%n%n%n", time.minusHours(525600 / 60));
        System.out.println(
                Period.between(
                        LocalDate.of(2015, 3, 20),
                        LocalDate.of(2015, 2, 20)));
    }
}
