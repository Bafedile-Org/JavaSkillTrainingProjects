package za.co.mecer.person;

import java.io.Serializable;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Person implements Serializable {

    private int age;
    transient private String name;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%n-------------------------------------%n"
                + "Person"
                + "%n-------------------------------------%n"
                + "Name: %s%n"
                + "Age: %d%n", name, age);
    }
}
