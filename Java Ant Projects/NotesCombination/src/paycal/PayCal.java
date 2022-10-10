package paycal;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class PayCal {
    private double []array = {200,100,50,20,10,1,0.5,0.2,0.1,0.05,0.02,0.01};         
    private long []numCom = new long[14];
    
    public long[] payCalc(double amt){
        for(int i=0;i<array.length;i++){
           numCom[i] = (long)((amt/array[i]));
           amt = amt*numCom[i];
        }
        return numCom;
    }
}
