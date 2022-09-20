package za.co.mecer.testdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DateTime {

    public void testDateTime() {
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        DateTimeFormatter tFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.printf("The date is %s%n"
                + "The time now is: %s%n",
                datetime.toLocalDate(), datetime.toLocalTime().format(tFormat));
        LocalDate date = LocalDate.now().plusMonths(3);
        System.out.printf("Date in December: %s%n", date.format(dFormat));
        System.out.printf("Date and Time: %s%n%n%n%n", datetime.format(format));

    }
}
