package za.co.mecer;

import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaulCipher {

    public static void main(String[] args) {
        new PaulCipher().run();
    }

    private void run() {
        char[] alphas = new char[26];

        String string = getString();
        // Looping through and assigning alphabets to the array indexes
        Alphabets al = array -> {
            int i = 0;
            for (char value = 'A'; value <= 'Z'; value++) {
                array[i] = value;
                i++;
            }
        };
        al.getAlphabets(alphas);

        Cipher cipher = str -> cipher(str, alphas);
        System.out.printf("Paul Ciphered String:  %s%n", cipher.cipherText(string));
    }

    private String cipher(String str, char[] alphas) {
        StringBuilder sb = new StringBuilder();
        str = str.toUpperCase();
        loop:
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                sb.append(c);
            } else {
                if (!Character.isLetter(c)) {
                    sb.append(c);
                }
                for (int j = 0; j < alphas.length; j++) {
                    if (c == alphas[j]) {

                        // loop backward the string to find the last character which was an alphabet 
                        for (int k = 1; k <= str.indexOf(c); k++) {
                            if (Character.isLetter(str.charAt(i - k))) {

                                // 64 represent character 'A' in the ASCII Chart
                                sb.append(alphas[(((int) str.charAt(i - k)) - 64
                                        + (j)) % 26]);
                                continue loop;
                            }
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    private String getString() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.nextLine();

        return str;
    }
}

@FunctionalInterface
interface Cipher {

    String cipherText(String str);
}

@FunctionalInterface
interface Alphabets {

    void getAlphabets(char[] array);
}
