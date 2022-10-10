
package za.co.mecer.product;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public interface Product extends IFace{
    default float getPrice(){
        return 100.00F;
    }
    String getName();
    
    static void msg(){
        System.out.println("This is a static msg method in the interface");
    }
    
}
