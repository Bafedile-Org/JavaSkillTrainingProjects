package za.co.mecer.producer;

import za.co.mecer.cubbyhole.CubbyHole;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Producer extends Thread {

    private CubbyHole cubbyHole;

    public Producer(CubbyHole cubbyHole) {

        this.cubbyHole = cubbyHole;
    }

    @Override
    public void run() {

        if (cubbyHole.getContents().isEmpty()) {
            for (int i = 0; i < 10; i++) {
                int val = (int) (Math.random() * 10) + 1;
                cubbyHole.putContents(val);
                System.out.printf("Producer put => %d%n", val);
                try {

                    Thread.sleep((int) (Math.random() + 100));
                } catch (InterruptedException ex) {
                    System.out.printf("Error: %s%n", ex.getMessage());
                }
            }
        }
    }
}
