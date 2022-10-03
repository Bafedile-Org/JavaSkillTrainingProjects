package za.co.mecer;

import za.co.mecer.sortthread.SortThread;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SortingAlgoThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        new SortingAlgoThread().sortInts();
//        new SortingAlgoThread().sortStrings();
    }

    private void sortInts() {
        Integer[] nums = {1, 3, 61, 38, 2, 39, 1, 37, 29, 37, 27, 3, 8, 2, 8, 3};

        new Thread(new SortThread(nums)).start();
        new Thread(new SortThread(nums)).start();

        Thread thread = new Thread(() -> {
            for (int value : nums) {
                System.out.printf("%d  ", value);
            }
        });
        thread.start();

    }

    private void sortStrings() throws InterruptedException {
        String[] strings = {"hello", "abc", "World", "they", "them", "i", "we", "ours"};
        Thread t1, t2;
        t1 = new Thread(new SortThread(strings));
        t2 = new Thread(new SortThread(strings));
        t1.start();
        t2.start();

        Thread thread = new Thread(() -> {
            for (String value : strings) {
                System.out.printf("%s  ", value);
            }
        });
        thread.start();

    }
}
