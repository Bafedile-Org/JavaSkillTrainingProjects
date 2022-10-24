package za.co.mecer.date;

import static java.time.DayOfWeek.TUESDAY;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.next;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DateTest {

    public void dateTest() {
        LocalDate date = LocalDate.now();
        System.out.printf("Today's date: %s%n", date);
        date = date.of(1868, 10, 31);
        System.out.printf("The other date: %s%n", date);
        System.out.printf("Is %s a Leap year?: %s%n", date.getYear(), date.isLeapYear());
        System.out.printf("The next day: %s%n", date.plusDays(3));
        System.out.printf("Date in the next 4 months is : %s%n", date.plusMonths(4));
        System.out.printf("Date in the previous 4 months is: %s%n", date.minusMonths(120));
        LocalDate now = LocalDate.now();
        System.out.printf("Is %s before %s? %s%n", now, date, now.isBefore(date));
        now = now.with(next(TUESDAY));

        System.out.printf("The Date: %s%n%n%n", now);
    }
}
