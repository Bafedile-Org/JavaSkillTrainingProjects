package za.co.mecer;

import za.co.mecer.singleton.Singleton;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SingletonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SingletonTest().run();
    }

    private void run() {
        Singleton f = Singleton.getInstance();
        Singleton f2 = Singleton.getInstance();
        f.setName("Dimakatso");
        System.out.printf("%S%n", f.getName());
        f2.setName("Bafedile");
        System.out.printf("%S%n", f2.getName());
        System.out.printf("Same ref: %s%n", (f == f2));

    }
}
