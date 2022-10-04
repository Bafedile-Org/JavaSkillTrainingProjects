package za.co.mecer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Dimakatso Sebatane
 */
public class QueueProducerConsumer {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public static void main(String[] args) {
        new QueueProducerConsumer().run();
    }

    private void run() {
        /**
         *
         * Remember that this code is not completed and does not work
         */
        Queue<Integer> queue = new LinkedList<>();

        queue.add(3);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();

    }

    class Producer implements Runnable {

        private Queue queue;

        Producer(Queue queue) {
            this.queue = queue;
        }

        public synchronized void produce() throws InterruptedException {

            while (queue.size() < 10) {
                int value = (int) (Math.random() * 1000);
                queue.add(value);
                System.out.printf("Produced [%d]:%n", value);
                TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 200));
            }
            notifyAll();
        }

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }
        }
    }

    class Consumer implements Runnable {

        private Queue queue;

        Consumer(Queue queue) {
            this.queue = queue;
        }

        public synchronized void consume() throws InterruptedException {
            while (!queue.isEmpty()) {
                System.out.printf("%s consumed from the queue%n", queue.poll());
                TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 150));
            }
            wait();
        }

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }
        }
    }
}
