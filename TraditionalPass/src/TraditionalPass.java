
import java.util.*;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class TraditionalPass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TraditionalPass().run();
    }

    private void run() {
        int[] pinNums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] num = new int[10];
        String pin;
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // assign the num array elements with randomized numbers
        sb.append("PIN: ");
        for (int i = 0; i < pinNums.length; i++) {
            sb.append(pinNums[i]);
            sb.append(" ");
        }
        sb.append("\n");
        sb.append("NUM: ");
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 3) + 1;
            sb.append(num[i]);
            sb.append(" ");
        }

        // Prompt the user to enter the pin 
        System.out.println("===========================================\n"
                + sb.toString()
                + "\n===========================================\n");
        sb.delete(0, sb.length());

        System.out.print("Enter the numbers representing the pin: ");
        sb.append(input.next());

        pin = sb.toString();
        sb.delete(0, sb.length());

        loop:
        for (int i = 0; i < pin.length(); i++) {
            for (int j = 0; j < num.length; j++) {
                if (Integer.parseInt("" + pin.charAt(i)) == num[j]) {
                    sb.append(pinNums[j]);
                    continue loop;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

}
