package za.co.mecer.TryWithResource;

/**
 *
 * @author Dimakatso Sebatane
 */
public class TryWithResource implements AutoCloseable {

    private int value;

    public TryWithResource(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("The value is : %d%n", value);
    }

    @Override
    public void close() throws Exception {
        System.out.printf("%S%n", toString());
    }

}
