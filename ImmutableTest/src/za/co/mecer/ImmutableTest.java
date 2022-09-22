package za.co.mecer;

import za.co.mecer.attackanddelay.AttackAndDelay;
import za.co.mecer.foo.Foo;
import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ImmutableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ImmutableTest().run2();
    }

    private void run() {
        StringBuilder sb = new StringBuilder("Are you okay?!");
        Foo foo = new Foo(sb);

        System.out.printf("SB: %s%n", sb.toString());
        System.out.printf("FOO: %s%n", foo.getSB().toString());
        sb.append("This is FUN!!!!");
        System.out.println("===========================================");
        System.out.printf("SB: %s%n", sb.toString());
        System.out.printf("FOO: %s%n", foo.getSB().toString());
        System.out.println("===========================================");
        StringBuilder sbAndOther = foo.getSB();
        sbAndOther.append(" No I am not okay");
        System.out.printf("SB: %s%n", sb.toString());
        System.out.printf("FOO: %s%n", foo.getSB().toString());
        System.out.printf("Sb and other: %s%n", sbAndOther.toString());

    }

    private void run2() {
        StringBuilder sb = new StringBuilder("Dimakatso");
        Person p = new Person("Dk", 30);
        AttackAndDelay and = new AttackAndDelay(p, sb, 3, 4);

        System.out.printf("SB: %s%n", sb.toString());
        System.out.printf("AND: %s%n", and.toString());
        System.out.println("=============================");
        sb.append(" Sebatane");
        System.out.printf("SB: %s%n", sb.toString());
        System.out.printf("AND: %s%n", and.toString());
        System.out.println("=============================");
        StringBuilder sb2 = and.getName();
        sb2.append(" None");
        System.out.printf("SB: %s%n", sb.toString());
        System.out.printf("AND: %s%n", and.toString());
        System.out.printf("SB2: %s%n", sb2.toString());

        Person p2 = and.getPerson();
        System.out.println("=============================");
        System.out.printf("P1: %s%n", p.toString());
        System.out.printf("P2: %s%n", p2.toString());
        System.out.println("=============================");
        p2.setName("Bafedile");
        System.out.printf("P1: %s%n", p.toString());
        System.out.printf("P2: %s%n", p2.toString());
    }
}
