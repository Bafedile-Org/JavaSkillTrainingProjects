package za.co.mecer;

import java.util.List;
import za.co.mecer.priorityqueue.PriorityQ;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PriorityQueues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PriorityQueues().run();
    }

    private void run() {
        List<PriorityQ> list;
        list = PriorityQ.list;
        list.add(new PriorityQ("Name", 3));
        list.add(new PriorityQ("This", 10));
        list.add(new PriorityQ("That", 2));
        list.add(new PriorityQ("Execute", 9));
        PriorityQ pq = new PriorityQ("me", 1);
        list.add(pq);
        pq.remove();

        display(list);
        System.out.println("-----------------------");
        pq.remove();

        display(list);

    }

    private void display(List<PriorityQ> list) {
        list.stream().forEach(System.out::println);
    }

}
