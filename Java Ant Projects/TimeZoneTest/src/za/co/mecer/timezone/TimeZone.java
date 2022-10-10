package za.co.mecer.timezone;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class TimeZone {

    Path path = Paths.get("times.txt");

    public String searchTimeZone(String timeZone) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                if (str.equals(timeZone) || str.contains(timeZone)) {
                    return str;
                }

            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
        return null;
    }

    public void determineDateTime(String timeZone) {
        try {
            if (searchTimeZone(timeZone) != null) {
                ZonedDateTime zDateTime = ZonedDateTime.now(ZoneId.of(searchTimeZone(timeZone)));
                System.out.printf("The Date and Time in %s is %s%n",
                        searchTimeZone(timeZone),
                        zDateTime.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss z")));
            } else {
                System.out.printf("Time Zone does not exist%n");
            }
        } catch (ZoneRulesException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
        System.out.println("\n");
    }

    public void displayAllTimes() {

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                determineDateTime(str);
            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }
}
