package za.co.mecer.foo;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Foo {

    private StringBuilder sb;

    public Foo(StringBuilder sb) {
        this.sb = new StringBuilder(sb);
    }

    public StringBuilder getSB() {
        return new StringBuilder(sb);
    }

}
