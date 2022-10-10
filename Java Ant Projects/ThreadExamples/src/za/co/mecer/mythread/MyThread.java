package za.co.mecer.mythread;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        this.setName("Looping Thread");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Morning for the %d time [%s] %n", i, this.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}
