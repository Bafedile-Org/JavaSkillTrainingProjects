package za.co.mecer.sortthread;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SortThread<T> implements Runnable {

    private T[] array;
    private int i, j, start, end;

    public SortThread(T[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            sort();
        } catch (InterruptedException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

    public void sort() throws InterruptedException {
        System.out.println("Sorting the array be patient...");
        for (i = start; i < end; i++) {
            for (j = start; j < i; j++) {
                T min = array[i];
                T max = array[j];
//                System.out.printf("Sorting by %s%n", Thread.currentThread().getName());
                sortIntegers(min, max, i, j);
                sortStrings(min, max, i, j);
            }
        }

    }

    void sortIntegers(T min, T max, int i, int j) {
        if ((min instanceof Integer) && (max instanceof Integer)) {
            if ((Integer) min < (Integer) max) {
                array[i] = (T) max;
                array[j] = (T) min;
            }
        }
    }

    void sortStrings(T min, T max, int i, int j) {
        if ((min instanceof String) && (max instanceof String)) {
            String mi = (String) min;
            String mx = (String) max;
            if (mi.length() < mx.length()) {
                array[i] = (T) mx;
                array[j] = (T) mi;
            }
        }
    }

    public void display() {
        System.out.println("");
        for (T value : array) {
            System.out.printf("%s  ", value);
        }
        System.out.println("\n");
    }
}
