package za.co.mecer.person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.setName(name);
        this.age = age;
    }

    public Person(String name) {
        this.setName(name);
        this.age = 18;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return new String(name);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Person%n"
                + "Person Name: %s%n"
                + "Person Age: %d%n", getName(), getAge());
    }
}
