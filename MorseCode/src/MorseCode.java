
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class MorseCode {

    public static void main(String[] args) {
        // TODO code application logic here
        String[] morseCodeCharacters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".-.-.-", "--..--"};

//        char[] alphas = new char[28];
//        alphas[26] = '.';
//        alphas[27] = ';';
//        int counter = 0;
//
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            alphas[counter] = ch;
//            counter++;
//        }
//
//        // ask the user to enter a sent
//        String sent;
//        Scanner input = new Scanner(System.in);
//        
//        System.out.print("Please enter a sentence: ");
//        sent = input.nextLine();
//        
//        StringBuilder sb = new StringBuilder();
//        for (counter = 0; counter < sent.length(); counter++) {
//            char ch = sent.toLowerCase().charAt(counter);
//            for (int i = 0; i < alphas.length; i++) {
//                if (Character.isLetter(ch)) {
//                    if (ch == alphas[i]) {
//                        sb.append(morseCodeCharacters[i]);
//                         sb.append(" ");
//                    }
//                    if (ch == '.') {
//                        sb.append(morseCodeCharacters[26]);
//                         sb.append(" ");
//                    }
//                    if (ch == ';') {
//                        sb.append(morseCodeCharacters[27]);
//                         sb.append(" ");
//                    }
//                   
//
//                }
//            }
//            if (Character.isWhitespace(ch)) {
//                System.out.println(ch);
//                sb.append("  ");
//            }
//        }
//
//        System.out.println(sb.toString());
// ----------------------------------------------------------------------
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a sentence: ");
        String sent = input.nextLine().toLowerCase();
        loop:
        for (int cnt = 0; cnt < sent.length(); cnt++) {
            char ch = sent.charAt(cnt);
            switch (ch) {
                case '.':
                    System.out.print(morseCodeCharacters[26]);
                    break;
                case ',':
                    System.out.print(morseCodeCharacters[27]);
                    break;
                default:
                    if (ch >= 'a' && ch <= 'z') {
                        System.out.print(morseCodeCharacters[ch - 'a']);
                    } else {
                        System.out.print("Invalid character");
                        break loop;
                    }
            }
            System.out.print("  ");
        }
    }

}
