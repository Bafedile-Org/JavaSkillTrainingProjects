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
        Message sms = new SMS();
        Message email = new Email("dk","dimakatso","mecer","subject");
        DisplayMessage dm = (msg) -> System.out.printf("%s", msg.toString());

        System.out.println(ContainsKeyword(sms, "Hello"));
//        perform(dm, sms);
//        perform(dm, email);

    }

    private void perform(DisplayMessage dis, Message msg) {
        dis.display(msg);
    }

    @FunctionalInterface
    interface DisplayMessage {

        void display(Message msg);
    }
    
    @FunctionalInterface
    interface Encode{
        String encodedString(Message msg);
    }

    public static boolean ContainsKeyword(Message messageObject, String keyword) {
        if (messageObject.toString().indexOf(keyword, 0) >= 0) {
            return true;
        }
        return false;
    }
}
