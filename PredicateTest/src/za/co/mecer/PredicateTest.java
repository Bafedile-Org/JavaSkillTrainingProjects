package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PredicateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PredicateTest().run();
    }

    private void run() {
//        _Predicate p = (str) -> str.contains("there");
//        System.out.println(p.test("Hello there mr world!"));
//        
//        System.out.printf("Ans: %s%n",evaluate((str)-> str.contains("there"),"Hello there mr world!"));
//        _Predicate p = (str)-> str.contains("+27") && (str.length() < 13 && str.length() > 11);
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("Please enter a telephone number: ");
//        String tel = input.next();
//        



        System.out.printf("The telephone number is %s%n",evaluate((str) -> str.contains("+27")
                && (str.length()==12), tel) ? "Valid" : "Invalid" );



//        
//        int value1=2,value2=3;
//        System.out.printf("The sum of %d and %d is %d%n",value1,value2,sum((num1,num2)-> num1+num2, value1,value2));

        

    }

    private boolean evaluate(_Predicate p, String str) {
        return p.test(str);
    }
    
    private int sum(_Testing p,Integer value1, Integer value2) {
        return p.test(value1,value2);
    }

}

@FunctionalInterface
interface _Predicate {

    boolean test(String s);
}

@FunctionalInterface
interface _Testing{
    int test(Integer num1,Integer num2);
}