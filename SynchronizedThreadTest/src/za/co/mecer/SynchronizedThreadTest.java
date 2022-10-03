package za.co.mecer;

import za.co.mecer.consumer.Consumer;
import za.co.mecer.cubbyhole.CubbyHole;
import za.co.mecer.producer.Producer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SynchronizedThreadTest {

    public static void main(String[] args) {
        new SynchronizedThreadTest().run();
    }

    private void run() {
        CubbyHole cubbyHole = new CubbyHole();
        Producer producer = new Producer(cubbyHole);
        Consumer consumer = new Consumer(cubbyHole);
        producer.start();
        consumer.start();
    }

}
