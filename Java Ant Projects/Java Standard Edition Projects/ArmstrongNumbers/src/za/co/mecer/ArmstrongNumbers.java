package za.co.mecer;

import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ArmstrongNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ArmstrongNumbers().run();

    }

    private void run() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an ending number: ");
        int endNo = input.nextInt();
        for (int i = 100; i < endNo; i++) {
            determineArmstrongNumber(i);
        }
    }

    private void determineArmstrongNumber(int num) {
        int total = 0;
        String numString = String.valueOf(num);
        if (num > 99) {
            for (int i = 0; i < numString.length(); i++) {
                total += Math.pow(Integer.parseInt(String.valueOf(numString.charAt(i))), numString.length());
            }
            if (total == num) {
                System.out.printf("%d is an Armstrong%n", num);
            }
        }
    }

}
