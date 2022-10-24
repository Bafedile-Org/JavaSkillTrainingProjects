package za.co.mecer.model;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Kids extends Person {

    @Override
    public String toString() {
        return String.format("%nName: %s%n"
                + "Age: %s%n%n", super.getName(), super.getAge());
    }
}
