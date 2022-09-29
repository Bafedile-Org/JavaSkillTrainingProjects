package za.co.mecer;

import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class EqualsAndHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new EqualsAndHash().run();
    }

    private void run() {
        Person p = new Person("Decay", 88);
        Person p1 = new Person("Dk", 88);
        Person p2 = new Person("Decay", 88);
        System.out.printf("Equals: %s%n", p.equals(p1));
        System.out.printf("Equals: %s%n", p.equals(p2));
        System.out.printf("Equals: %s%n", p.equals("Hello World!"));
    }

}
