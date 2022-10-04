package za.co.mecer;

import java.util.InputMismatchException;
import java.util.Scanner;
import za.co.mecer.timezone.TimeZone;

/**
 *
 * @author Dimakatso Sebatane
 */
public class TimeZoneTest {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new TimeZoneTest().run();
    }

    private void run() {
        int choice;
        String timeZone;
        boolean isValid;
        choice = getChoice();
        loop:
        do {

            switch (choice) {
                case 1:
                    timeZone = getTimeZone();
                    new TimeZone().determineDateTime(timeZone);
                    break;
                case 2:
                    new TimeZone().displayAllTimes();
                    break;
                default:
                    System.out.printf("%nThank you for using our service %n");
                    break loop;
            }
            choice = getChoice();
            if (choice == 3) {
                System.out.printf("%nThank you for using our service %n");
            }
            isValid = !(choice < 1 && choice > 3);
        } while (!isValid);

    }

    private int getChoice() {
        boolean isValid = false;
        int choice = 0;

        do {
            try {
                System.out.print("Please choose from the below\n"
                        + "1 Enter Time Zone to display date and time\n"
                        + "2 Display Date and Time of all the TimeZones\n"
                        + "3 Exit the Program\n"
                        + "Your choice: ");
                choice = input.nextInt();
                isValid = !(choice < 1 && choice > 3);
            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }
        } while (!isValid);

        return choice;
    }

    private String getTimeZone() {
        String timeZone = null;
        do {
            System.out.print("Please enter the time zone [e.g Africa/Johannesburg]: ");
            timeZone = input.next();

        } while (timeZone.isEmpty());

        return timeZone;
    }

}
