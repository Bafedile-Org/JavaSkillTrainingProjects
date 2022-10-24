package za.co.mecer.message;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Message {
    private String text;
    
    public Message(){
        this("Hello World!");
    }
    
    public Message(String text){
        this.setText(text);
    }
    
    public void setText(String text){
        this.text = text;
    }
    
    public String getText(){
        return text;
    }
    
    @Override
    public String toString(){
        return String.format("Message: %s%n",text);
    }
}
