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
    public static void main(String[] args) {
        new NumberEncoding().run();
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
        char[] symbols = {'*', 'B', 'E', 'A', '@', 'F', 'K', '%', 'R', 'M'};
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

}
