package za.co.mecer.generic;

/**
 *
 * @author Dimakatso Sebatane
 */
public class GenMethodClass {

    public GenMethodClass() {

    }

    public <T> void foo(T val) {
        System.out.printf("The type is %s%n", val.getClass().getName());
    }

    public <T, G> void foo(T val, G val2) {
        System.out.printf("The type [%s] is %s%n"
                + "The type [%s] is %s%n%n", val, val.getClass().getName(),
                val2, val2.getClass().getName());
    }
}
