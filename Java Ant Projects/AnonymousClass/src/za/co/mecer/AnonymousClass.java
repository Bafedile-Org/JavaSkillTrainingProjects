package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AnonymousClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new AnonymousClass().run();
    }

    private void run() {

        go(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Interface Method");
            }
        });

        goo(() -> {
            System.out.println("Lambda Run Interface Method");
        });

        goo(new CoolInterface() {
            @Override
            public void run() {
                System.out.println("Run Interface Method");
            }

//            @Override
//            public void foo() {
//                // System.out.println("Foo Interface Method");
//            }
//
//            @Override
//            public int calc() {
//                return 3 + 2;
//            }
        });

    }

    private void goo(CoolInterface ci) {
        ci.run();

    }

    private void go(Runnable ci) {
        ci.run();

    }
}

interface CoolInterface {

    void run();

//    void foo();
//
//    int calc();
}
