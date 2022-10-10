package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AssertionsTest {

    private int addPositiveValue(int val) {
        assert (val >= 0) : "A number has to be greater than 0";
        return val + val;
    }

    private void switchAssert(char ch) {
        assert (Character.isLetter(ch)) : "Only letters should be passed as argument";
        switch (ch) {
            case 'a':
                System.out.println("In A");
                break;
            case 'b':
                System.out.println("In B");
                break;
            case 'c':
                System.out.println("In C");
                break;
            default:
                assert (false) : "Sould not get to default: " + ch;
        }
    }

    public static void main(String[] args) {
        new AssertionsTest().run();
    }

    private void run() {
        try {
//           
            switchAssert('2');
            addPositiveValue(-12);
        } catch (AssertionError ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

}
