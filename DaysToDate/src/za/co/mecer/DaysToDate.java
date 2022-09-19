package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DaysToDate {

    public static void main(String[] args) {
        new DaysToDate().run(args);
    }

    private void run(String[] args) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = Integer.parseInt(args[0]),
                month = Integer.parseInt(args[1]),
                year = Integer.parseInt(args[2]);

        for (int mnt = 1; mnt < month; mnt++) {
            day += days[mnt];
        }
        if (year % 4 == 0) {
            day += 1;
        }

        System.out.printf("Number of days is %d%n", day);

    }

}
