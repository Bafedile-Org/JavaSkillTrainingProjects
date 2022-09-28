package za.co.mecer.generic;

/**
 *
 * @author Dimakatso Sebatane
 * @param <T>
 */
public class GenericBound<T extends Number> {

    private T t;

    public GenericBound(T t) {
        this.t = t;
    }

    public void printValue() {
        System.out.printf("Value: %s%n", t);
        printType();
    }

    public void printType() {
        System.out.printf("Object Type: %s%n%n", t.getClass().getName());
    }

    @Override
    public String toString() {
        return String.format("%s%n", t);
    }
}
