package za.co.mecer.consumer;

import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mecer.cubbyhole.CubbyHole;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Consumer extends Thread {

    private CubbyHole cubbyHole;

    public Consumer(CubbyHole cubbyHole) {
        this.cubbyHole = cubbyHole;
    }

    @Override
    public void run() {
        int value;

        for (int i = 0; i < 10; i++) {
            try {
                value = cubbyHole.getContent();
                if (!(value == -1)) {
                    System.out.printf("Consumer read the value: %d%n", value);
                }

            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }

        }
    }
}
