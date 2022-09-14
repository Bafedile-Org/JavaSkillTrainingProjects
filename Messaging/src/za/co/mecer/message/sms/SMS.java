package za.co.mecer.message.sms;

import za.co.mecer.message.Message;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SMS extends Message{
    private String recipientContactNo;
    
    public SMS(){
        this("Hello World","+27238282828");
    }
    
    public SMS(String text, String recipientContactNo){
        super(text);
        this.setRecipientContactNo(recipientContactNo);
    }
    
    public void setRecipientContactNo(String recipientContactNo){
        this.recipientContactNo = recipientContactNo;
    }
    
    public String getRecipientContactNo(){
        return recipientContactNo;
    }
    
    @Override
    public String toString(){
        return String.format("Message: %s%n"
                + "Recipient Contact Number: %s%n",getText(),getRecipientContactNo());
    }
}
