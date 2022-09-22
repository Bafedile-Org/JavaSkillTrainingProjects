package za.co.mecer;

import za.co.mecer.outerclass.OuterClass;

/**
 *
 * @author Dimakatso Sebatane
 */
public class NestedAndInner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new NestedAndInner().run();
    }

    private void run() {
        OuterClass outerClass = new OuterClass(31);
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(254);
        System.out.println("========================OUTER CLASS========================");
        System.out.println(outerClass.toString());
        System.out.println("========================INNER CLASS========================");
        System.out.println(innerClass.toString());

        System.out.println("========================INNER CLASS REF========================");
        outerClass.setInnerClassRef();
        System.out.printf("Value: %d%n%n", outerClass.getInnerClassRef().getInnerValue());

        System.out.println("========================STATIC CLASS========================");
        OuterClass.InnerStatic innerStatic = new OuterClass.InnerStatic("Dimakatso");
        System.out.printf("InnerStatic String: %s%n%n", innerStatic.getStr());
        System.out.println("========================METHOD CLASS========================");
        outerClass.calculate(34, 4);

    }
}
