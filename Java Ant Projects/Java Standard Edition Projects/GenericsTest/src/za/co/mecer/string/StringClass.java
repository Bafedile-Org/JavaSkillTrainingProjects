package za.co.mecer.string;

/**
 *
 * @author Dimakatso Sebatane
 */
public class StringClass {

    private String i;

    public StringClass(String i) {
        this.i = i;
    }

    public void printValue() {
        System.out.printf("Value: %s%n", i);
        printType();
    }

    public void printType() {
        System.out.printf("Object Type: %s%n%n", i.getClass().getName());
    }

    @Override
    public String toString() {
        return String.format("%s%n", i);
    }
}
