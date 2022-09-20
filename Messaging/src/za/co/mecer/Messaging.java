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
        char ch[] = new char[26];
        Message sms = new SMS("This is java", "+27183838383");
        Message email = new Email("dk", "dimakatso", "mecer", "subject");
        DisplayMessage dm = (msg) -> System.out.printf("%s", msg.toString());
        Alphabets alphas = cha -> {
            int i = 0;
            for (char a = 'a'; a <= 'z'; a++) {
                cha[i] = a;
                i++;
            }

        };

        alphas.getAlphabets(ch);
        Encode encode = msg -> {
            StringBuilder sb = new StringBuilder();
            char alpha;
            for (int i = 0; i < msg.toString().toLowerCase().length(); i++) {
                alpha = msg.toString().toLowerCase().charAt(i);
                for (int j = 0; j < ch.length; j++) {
                    if (Character.isLetter(alpha)) {
                        if (alpha == ch[j]) {
                            sb.append(ch[(j)]);
                        }
                    }

                }
                sb.append(" ");
            }
            return sb.toString();
        };

        System.out.println(encode.encodedString(sms));

//        System.out.println(ContainsKeyword(sms, "Hello"));
//        perform(dm, sms);
//        perform(dm, email);
    }

//    private void perform(DisplayMessage dis, Message msg) {
//        dis.display(msg);
//    }
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
