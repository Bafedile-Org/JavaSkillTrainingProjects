package za.co.mecer.cubbyhole;

import java.util.Stack;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CubbyHole {

    private Stack<Integer> values = new Stack<>();

    public CubbyHole() {

    }

    public synchronized void putContents(int contents) throws InterruptedException {

        while (values.isEmpty()) {
            this.values.push(contents);

        }
        notifyAll();
    }

    public synchronized int getContent() throws InterruptedException {
        while (!values.isEmpty()) {
            return values.pop();
        }
        System.out.printf("%n%nNo items in the stack%n%n");
        wait();
        return -1;

    }

    public Stack getContents() {
        return values;
    }

}
