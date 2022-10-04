package za.co.mecer;

import za.co.mecer.sortthread.SortThread;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SortingAlgoThread {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
//        new SortingAlgoThread().sortInts();
        new SortingAlgoThread().sortStrings();
    }

    private void sortInts() {
        Integer[] nums = {1, 3, 61, 38, 2, 39, 1, 37, 29, 37, 27, 3, 8, 2, 8, 3};

        new Thread(new SortThread(nums, 0, (nums.length / 2))).start();
        new Thread(new SortThread(nums, (nums.length / 2) + 1, nums.length)).start();
        new Thread(new SortThread(nums, 0, nums.length)).start();
        display(nums);

    }

    private void sortStrings() throws InterruptedException {

        String[] strings = {"hello", "abc", "World", "they", "them", "i", "we", "ours"};
        Thread t1, t2, t3;
        t1 = new Thread(new SortThread(strings, 0, (strings.length / 2)));
        t2 = new Thread(new SortThread(strings, (strings.length / 2) + 1, strings.length));
        t1.start();
        t2.start();

        new Thread(new SortThread(strings, 0, strings.length)).start();
        display(strings);
    }

    private <T> void display(T[] array) {
        Thread thread = new Thread(() -> {
            for (T value : array) {
                System.out.printf("%s  ", value);
            }
            System.out.println("");
        });
        thread.start();
    }

}
