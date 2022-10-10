package za.co.mecer.integer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class IntegerClass {

    private Integer i;

    public IntegerClass(Integer i) {
        this.i = i;
    }

    public void printValue() {
        System.out.printf("Value: %s%n", i.toString());
        printType();
    }

    public void printType() {
        System.out.printf("Object Type: %s%n%n", i.getClass().getName());
    }

    @Override
    public String toString() {
        return String.format("%d%n", i);
    }
}
