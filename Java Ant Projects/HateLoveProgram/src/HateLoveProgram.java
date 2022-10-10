
import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class HateLoveProgram {

    public static void main(String[] args) {
        new HateLoveProgram().run();
    }

    private void run() {
        Scanner input = new Scanner(System.in);
        String message;
        System.out.print("Please enter a sentence: ");
        message = input.nextLine();
        System.out.printf("Message:: %s%n", replaceFirstOccurence(message, "hate", "love"));
        System.out.printf("Message:: %s%n", replaceAllOccurence(message, "hate", "love"));
    }

    private String replaceFirstOccurence(String str, String replace, String replaceWith) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);

//        return sb.replace(sb.indexOf(replace), sb.indexOf(replace) + replace.length(), replaceWith).toString();
        return str.replaceFirst(replace, replaceWith);
    }

    private String replaceAllOccurence(String str, String replace, String replaceWith) {
        return str.replaceAll(replace, replaceWith);
    }
}
