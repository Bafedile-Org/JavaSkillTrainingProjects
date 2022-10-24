package za.co.mecer.doubles;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DoubleClass {

    private Double i;

    public DoubleClass(Double i) {
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
        return String.format("%.2f%n", i);
    }
}
