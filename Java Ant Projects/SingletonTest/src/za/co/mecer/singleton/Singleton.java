package za.co.mecer.singleton;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Singleton {

    private static Singleton singleton;
    private String name;

    private Singleton() {

    }

    static {
        singleton = new Singleton();
    }

    public static Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
        return singleton;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
