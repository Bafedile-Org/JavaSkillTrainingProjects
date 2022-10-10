package za.co.mecer;

import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class NumberEncoding {

    /**
     * @param args the command line arguments
     */
    private final char[] symbols = {'*', 'B', 'E', 'A', '@', 'F', 'K', '%', 'R', 'M'};

    public static void main(String[] args) {
        new NumberEncoding().runThandeksCode();
    }

    private void run() {
        StringBuilder sb = new StringBuilder();
        String numString = getString();

        if (Integer.parseInt("" + numString.charAt(numString.length() - 1)) == 0) {
            encode(sb, numString, '#');
        } else if (!(Integer.parseInt("" + numString.charAt(0)) % 2 == 0
                && Integer.parseInt("" + numString.charAt(numString.length() - 1)) % 2 == 0)) {
            encode(sb, numString, 'X');

        } else {
            encode(sb, numString, '$');
        }

    }

    private void encode(StringBuilder sb, String numString, char ch) {

        sb.append(ch);
        for (int i = 1; i < numString.length() - 1; i++) {
            sb.append(symbols[Integer.parseInt("" + numString.charAt(i))]);
        }
        sb.append(ch);
        System.out.printf("%s%n", sb);
    }

    private String getString() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a sequence of numbers: ");
        return input.next();
    }

    /**
     * Thandeka's Code
     *
     * @param number
     * @return
     */
    private void runThandeksCode() {
        String numString = getString();

        System.out.printf("Encoded Numerals: %s%n", generateSymbol(numString));
    }

    private String generateSymbol(String number) {
        StringBuilder sb = new StringBuilder(number);
        int myLastValue = number.length() - 1;
        for (int i = 0; i < number.length(); i++) {
            char ch = symbols[Character.getNumericValue(number.charAt(i))];
            sb.setCharAt(i, ch);
        }

        if (Character.getNumericValue(number.charAt(myLastValue)) == 0) {
            sb.setCharAt(myLastValue, '#');
        } else if (Character.getNumericValue(number.charAt(0)) % 2 != 0
                && Character.getNumericValue(number.charAt(myLastValue)) % 2 != 0) {
            sb.setCharAt(0, 'X');
            sb.setCharAt(myLastValue, 'X');

        } else {
            sb.setCharAt(0, '$');
            sb.setCharAt(myLastValue, '$');
        }

        return sb.toString();
    }

}
