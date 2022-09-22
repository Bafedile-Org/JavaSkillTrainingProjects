package za.co.mecer.attackanddelay;

import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AttackAndDelay {

    private final StringBuilder name;
    private final Person p;
    private final int attack, delay;

    public AttackAndDelay(Person p, StringBuilder name, int attack, int delay) {
        this.p = new Person(p.getName());
        this.attack = attack;
        this.delay = delay;
        this.name = new StringBuilder(name);

    }

    public Person getPerson() {
        return new Person(p.getName());
    }

    public StringBuilder getName() {
        return new StringBuilder(name);
    }

    public int getAttack() {
        return attack;
    }

    public int getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return String.format("AND%n"
                + "Person: %s%n"
                + "Name: %s%n"
                + "Attack: %d%n"
                + "Delay: %d%n", getPerson(), getName(), getAttack(), getDelay());
    }
}
