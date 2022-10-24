package za.co.mecer.dateprogram;

import java.util.Scanner;
import za.co.mecer.exceptions.DayException;
import za.co.mecer.exceptions.MonthException;
import za.co.mecer.exceptions.YearException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DateProgram {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new DateProgram().getDate();
    }

    private void getDate() {
        boolean isValid;
        String date = "";
        String[] dateValues;
        do {
            try {
                System.out.print("Please enter a date in the format (DD/MM/YYYY): ");
                date = input.next();

                dateValues = date.split("/");
                isValid = determineDate(dateValues);

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                System.out.printf("%nERROR: %s%n", ex.getMessage());
                isValid = false;
            }
        } while (!isValid);
        System.out.printf("%nDate: %s%n", date);

    }

    private boolean determineDate(String[] date) {
        int day = Integer.parseInt(date[0]), month = Integer.parseInt(date[1]), year = Integer.parseInt(date[2]);
        try {
            month = getMonth(month);

            year = getYear(year);
            day = getDay(day, month, year);
            return true;
        } catch (DayException | MonthException | YearException ex) {
            System.out.printf("ERROR: %s%n", ex.getMessage());
            return false;
        }

    }

    private int getDay(int day, int month, int year) throws DayException {
        if (month == 2 && day > 28) {
            if ((year % 4) == 0) {
                return day;
            } else {
                throw new DayException(String.format("%d is not a leap, February this year does not have days after 28th", year));
            }

        } else if (day < 1 || day > 31) {
            throw new DayException("A day in a month can not exceed 31");
        }

        return day;
    }

    private int getMonth(int month) throws MonthException {
        if (month < 1 || month > 12) {
            throw new MonthException("Month range should be between 1 - 12");
        }
        return month;

    }

    private int getYear(int year) throws YearException {
        if (year < 1000 || year > 3000) {
            throw new YearException("A year in this example can not be less than 1000 or greater than 3000");
        }

        return year;
    }

}
