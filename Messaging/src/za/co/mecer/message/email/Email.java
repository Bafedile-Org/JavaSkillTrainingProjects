package za.co.mecer.message.email;

import za.co.mecer.message.Message;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Email extends Message {
    private String sender, receiver, subject;
    
    public Email(){
        this("Hello World","dimakatso","mecer","Java Programming");
    }
    
    public Email(String text,String sender, String receiver, String subject){
        super(text);
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
    }
    
    public String getSender(){
        return sender;
    }
    
    public String getReceiver(){
        return receiver;
    }
    
    public String getSubject(){
        return subject;
    }
    
    @Override
    public String toString(){
        return String.format( "%nSender: %s%n"
                + "Receiver: %s%n"
                + "Subject: %s%n%s",sender,receiver,subject,super.toString());
    }
}
