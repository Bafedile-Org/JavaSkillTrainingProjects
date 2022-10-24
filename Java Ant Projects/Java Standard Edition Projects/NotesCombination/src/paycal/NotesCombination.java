package paycal;

import java.util.Arrays;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class NotesCombination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PayCal pay = new PayCal();
        System.out.println(Arrays.toString( pay.payCalc(100)));
    }
    
}
