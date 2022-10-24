/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Square extends Rectangle{
    public Square(int length,String name) {
        super(length,name);
    }
    
    @Override
    public double calculateArea(){
        return Math.pow(super.getLength(),2);
    }
    
}
