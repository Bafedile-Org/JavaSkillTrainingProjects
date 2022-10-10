package za.co.mecer;

import za.co.mecer.message.Message;
import za.co.mecer.message.email.Email;
import za.co.mecer.message.sms.SMS;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Messaging {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Messaging().run();

    }

    private void run() {
        char alphas[] = new char[26];
        Message sms = new SMS("This is java", "+27183838383");
        Message email = new Email("DK has arrived", "dimakatso", "mecer", "subject");
        Alphabets ch = cha -> {
            int i = 0;
            for (char a = 'a'; a <= 'z'; a++) {
                cha[i] = a;
                i++;
            }
        };
        ch.getAlphabets(alphas);

        Encode encode = msg -> {
            StringBuilder sb = new StringBuilder();
            String str = msg.getText().toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    sb.append(alphas[(str.charAt(i) - 'a' + 1)]);
                } else {
                    sb.append(str.charAt(i));
                }
            }
            msg.setText(sb.toString());
            return msg.toString();

        };
        DisplayMessage dm = msg -> {
            System.out.printf("%S%n", encode.encodedString(msg));
        };
        dm.display(sms);
        dm.display(email);
    }

    @FunctionalInterface
    interface DisplayMessage {

        void display(Message msg);
    }

    @FunctionalInterface
    interface Encode {

        String encodedString(Message msg);
    }

    interface Alphabets {

        void getAlphabets(char alphas[]);
    }

    public static boolean ContainsKeyword(Message messageObject, String keyword) {
        if (messageObject.toString().indexOf(keyword, 0) >= 0) {
            return true;
        }
        return false;
    }
}
