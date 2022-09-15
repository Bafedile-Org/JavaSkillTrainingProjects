package za.co.mecer;

import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AverageN {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new AverageN().run();
    }

    private void run() {
        int sum = 0, max, num, temp;
        System.out.println("Enter the maximum number");
        max = getNum();

        temp = max;
        System.out.println("===================================\n"
                + "Enter Numbers Below");
        do {
            num = getNum();
            sum += num;
            max--;
        } while (max != 0);

        System.out.printf("%nThe Average of the entered numbers is: %.2f%n", (double) (sum / temp));

    }

    private int getNum() {
        int num = 0;
        boolean isValid = true;
        do {
            try {
                System.out.print("Please enter a number: ");
                num = Integer.parseInt(input.next());
            } catch (NumberFormatException nfe) {
                System.out.printf("%nERROR: %s%n", nfe.getMessage());
                isValid = false;
            }
        } while (!isValid);

        return num;
    }

}
