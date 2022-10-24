package za.co.mecer;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LocaleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LocaleTest().run();

    }

    private void run() {
        runLocale();
//        runInstant();
//        runPeriod();
//        runDuration();
    }

    private void runLocale() {
        Locale myLocale = Locale.getDefault();
        System.out.printf("Default  Locale: %s%n", myLocale);

        LocalDateTime dateTime = LocalDateTime.now();
//        LocalDateTime dateTime = LocalDateTime.of(2022, 5, 11, 9, 30, 36);
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss z");
        System.out.printf("Date and time is %s%n", dateTime.format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)));

        ZonedDateTime zDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Africa/Johannesburg"));
        System.out.printf("Zoned Date Time is: %s%n", zDateTime.format(dtFormat));

        Locale localItaly = new Locale("it", "IT");
        System.out.printf("Date of Italy: %s%n", zDateTime.format(DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.LONG)
                .withLocale(localItaly)));

        Locale locCan = new Locale("fr", "CA");
        System.out.printf("Date of Canada: %s%n", zDateTime.format(DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.LONG)
                .withLocale(locCan)));

        ZonedDateTime zDateNTime = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.printf("Date and Time of Australia is : %s%n", zDateNTime.format(dtFormat));
        ZonedDateTime zDateNTime2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.printf("Date and Time of America is : %s%n", zDateNTime2.format(dtFormat));
    }

    private void runInstant() {
        Instant instant = Instant.now();
        System.out.printf("Now instant: %s%n", instant.toString());
        instant = instant.minus(Duration.ofDays(3));
        System.out.printf("Instant minus 3 days: %s%n", instant.toString());

    }

    private void runPeriod() {
        Period p = Period.ofMonths(1);
        System.out.printf("Preriod 1 : %s%n", p);
        p = Period.ofMonths(8);
        System.out.printf("Preriod 2 : %s%n", p);
        p = p.minus(Period.ofDays(5));
        System.out.printf("Preriod 3 : %s%n", p);

    }

    private void runDuration() {
        Duration duration = Duration.ofHours(12);
        System.out.printf("Duration 1: %s%n", duration);

        duration = Duration.between(LocalTime.NOON, LocalTime.now());
        System.out.printf("Duration between noon and mid-night: %s%n", duration);
    }
}
