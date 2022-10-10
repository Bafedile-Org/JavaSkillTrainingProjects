package za.co.mecer;

import java.util.Scanner;
import za.co.mecer.exception.DayException;
import za.co.mecer.exception.MonthException;
import za.co.mecer.exception.YearException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MonthFormatting {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new MonthFormatting().run();
    }

    private void run() {

    }

    private int getDay(int day, int month) throws DayException {
        if (!(day < 1 && day > 31)) {
            if (month == 2) {
                if (day > 30) {
                    throw new DayException("February Month does not have the 30th or 31st day");
                }
            }
        } else {
            throw new DayException("A day cannot be less than 1 or greater than 31");
        }

        return day;
    }

    private int getMonth(int month) throws MonthException {
        if (month < 1 && month > 12) {
            throw new MonthException("Month cannot be less than 1 or greater than 12");
        }

        return month;
    }

    private int getYear(int year) throws YearException {
        if (year < 1000 && year > 3000) {
            throw new YearException("A year in this range cannot be less than 1000 or greater than 3000");
        }

        return year;
    }

    private void getDate() {
        Scanner input = new Scanner(System.in);
        String date;
        String[] dateArgs;
        boolean isValid = true;
        int day, month, year;

        do {
            try {
                System.out.print("Please enter a date in the format (MM/DD/YYYY) : ");
                date = input.next();

                dateArgs = date.split("/");

                month = getMonth(Integer.parseInt(dateArgs[0]));
                day = getDay(Integer.parseInt(dateArgs[1]), month);
                year = getYear(Integer.parseInt(dateArgs[2]));
            } catch (DayException | MonthException | YearException ex) {
                System.out.printf("ERROR: %s%n", ex.getMessage());
            }

        } while (!isValid);

    }
}
